package backend;

import java.util.Optional;

public interface IBankService {
    Optional<Account> login(String creditCardNumber, String password);
    void createAccount();
}
