package datasources;

import backend.Account;
import backend.CardConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataFakeService implements IDataService {

    private List<Account> accounts;
    private int availableCAN;

    public DataFakeService() {
        this.accounts = new ArrayList<>();
        this.availableCAN = 1;
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
        availableCAN++;
    }

    @Override
    public Optional<Account> getAccountByCredentials(String cardNumber, String password) {
        Optional<Account> matchedAccount =  accounts.stream()
                .filter(account -> account.matchCredentials(cardNumber, password))
                .findFirst();
        return matchedAccount;
    }

    @Override
    public boolean checkIfContainsAccount(String cardNumber, String password) {
        Optional<Account> matchedAccount =  accounts.stream()
                .filter(account -> account.matchCredentials(cardNumber, password))
                .findFirst();
        return matchedAccount.isPresent();
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
