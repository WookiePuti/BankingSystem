package backend;

import dao.IDataService;

import java.util.Optional;

public interface ILogin {
    Optional<Account> login(String creditCardNumber, String password, IDataService dataService);
}
