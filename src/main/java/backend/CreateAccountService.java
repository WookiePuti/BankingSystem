package backend;

import dao.IDataService;

public class CreateAccountService implements ICreateAccount {

    @Override
    public void createAccount(CreditCard newCreditCard, IDataService dataService) {
        Account newAccount = new Account(newCreditCard);
        dataService.addAccount(newAccount);
    }
}
