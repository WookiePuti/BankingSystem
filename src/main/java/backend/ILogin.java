package backend;

import datasources.IDataService;

import java.util.Optional;

public interface ILogin {
    Optional<Account> login(String creditCardNumber, String password, IDataService dataService);
}
