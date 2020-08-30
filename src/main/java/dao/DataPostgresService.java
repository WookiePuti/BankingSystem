package dao;

import backend.Account;
import backend.CardConfig;
import backend.CreditCard;
import datasources.IDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DataPostgresService implements IDataService{
    private IDataSource dataSource;

    public DataPostgresService(IDataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        String statement = "SELECT * FROM account;";

        try (ResultSet resultSet = dataSource.executeReturnQuery(statement)) {
            while (resultSet.next()) {
                String cardNumber = resultSet.getString("cardNumber");
                String password = resultSet.getString("password");
                int balance = resultSet.getInt("balance");

                accounts.add(new Account(new CreditCard(cardNumber, password)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;

    }

    @Override
    public void addAccount(Account account) {
        String cardNumber = account.getCardNumber();
        String password = account.getPassword();
        int balance = account.getBalance();
        // uuid, cardNumber, password, balance
        String statement = "INSERT INTO account VALUES " +
                "(uuid_generate_v4(), '" +
                cardNumber + "', '" +
                password + "', " +
                balance +
                ");";

        dataSource.executeUpdate(statement);
    }

    @Override
    public Optional<Account> getAccountByCredentials(String cardNumber, String password) {
        List<Account> accounts = getAccounts();

        return accounts.stream()
                .filter(account -> account.matchCredentials(cardNumber, password))
                .findFirst();
    }

    @Override
    public boolean checkIfContainsAccount(String cardNumber, String password) {
        List<Account> accounts = getAccounts();
        Optional<Account> matchedAccount =  accounts.stream()
                .filter(account -> account.matchCredentials(cardNumber, password))
                .findFirst();
        return matchedAccount.isPresent();
    }

    @Override
    public String generateCAN() {

        String statement = "SELECT * FROM account_cannumber_seq;";
        int availableCAN = 0;

        try (ResultSet resultSet = dataSource.executeReturnQuery(statement)) {
            while (resultSet.next()) {
                availableCAN = resultSet.getInt("last_value") + 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        StringBuilder generatedCAN = new StringBuilder();
        generatedCAN.append(availableCAN);
        if (generatedCAN.length()< CardConfig.CANLength) {
            generatedCAN.insert(0,"0".repeat(CardConfig.CANLength -generatedCAN.length()));
        }
        return generatedCAN.toString();
    }
}
