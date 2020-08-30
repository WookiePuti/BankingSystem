package backend;

import dao.DataFakeService;
import dao.DataPostgresService;
import dao.IDataService;
import datasources.IDataSource;
import datasources.PostgresDataSource;

import java.util.Optional;

public class BankService implements IBankService {
    private final ILogin loginService;
    private final ICreateAccount createAccountService;
    private final IDataService dataService;
    private final IPasswordGenerator passwordGenerator;
    private final ICreditCardGenerator creditCardNumberGenerator;
    private IDataSource dataSource;

    public BankService() {
        loginService = new LoginService();
        createAccountService = new CreateAccountService();
        dataSource = new PostgresDataSource();
        dataService = new DataPostgresService(dataSource);
        passwordGenerator = new PasswordGenerator();
        creditCardNumberGenerator = new CreditCardNumberGenerator(new CheckSumGenerator());
    }

    @Override
    public Optional<Account> login(String creditCardNumber, String password) {
        return loginService.login(creditCardNumber, password, dataService);
    }

    @Override
    public void createAccount() {
        String password = passwordGenerator.generatePassword();
        String cardNumber = creditCardNumberGenerator.generateCreditCardNumber(dataService.generateCAN());
        CreditCard newCard = new CreditCard(cardNumber, password);
        createAccountService.createAccount(newCard, dataService);
        System.out.println("Your card has been created");
        System.out.println("Your card number: " + cardNumber);
        System.out.println("Your card PIN: " + password);

    }
}
