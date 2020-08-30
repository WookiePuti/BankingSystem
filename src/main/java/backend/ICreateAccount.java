package backend;

import dao.IDataService;

public interface ICreateAccount {
    void createAccount(CreditCard newCreditCard, IDataService dataService);
}
