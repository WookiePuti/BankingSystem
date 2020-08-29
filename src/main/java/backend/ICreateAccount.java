package backend;

import datasources.IDataService;

public interface ICreateAccount {
    void createAccount(CreditCard newCreditCard, IDataService dataService);
}
