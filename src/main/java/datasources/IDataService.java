package datasources;

import backend.Account;

import java.util.List;
import java.util.Optional;

public interface IDataService {
    List<Account> getAccounts();
    void addAccount(Account account);
    Optional<Account> getAccountByCredentials(String cardNumber, String password);
    boolean checkIfContainsAccount(String cardNumber, String password);
    String generateCAN();
}
