package dao;

import backend.Account;
import backend.CardConfig;
import datasources.IDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DataPostgresService implements IDataService{
    private IDataSource dataSource;
    private int availableCAN;

    public DataPostgresService(IDataSource dataSource) {
        this.dataSource = dataSource;
        availableCAN = 1;
    }

    @Override
    public List<Account> getAccounts() {

        return null;

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
        return Optional.empty();
    }

    @Override
    public boolean checkIfContainsAccount(String cardNumber, String password) {
        return false;
    }

    @Override
    public String generateCAN() {
        StringBuilder generatedCAN = new StringBuilder();
        generatedCAN.append(availableCAN);
        if (generatedCAN.length()< CardConfig.CANLength) {
            generatedCAN.insert(0,"0".repeat(CardConfig.CANLength -generatedCAN.length()));
        }
        return generatedCAN.toString();
    }
}
