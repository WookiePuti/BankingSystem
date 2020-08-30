package backend;

import dao.IDataService;

import java.util.Optional;

public class LoginService implements ILogin {

    @Override
    public Optional<Account> login(String creditCardNumber, String password, IDataService dataService) {
        if (dataService.checkIfContainsAccount(creditCardNumber, password)) {
            System.out.println("You have successfully logged in!");
        }
        else {
            System.out.println("Wrong card number or PIN!");
        }
        return dataService.getAccountByCredentials(creditCardNumber, password);
    }
}
