package backend;

public class Account {
    private CreditCard creditCard;
    private int balance;

    public Account(CreditCard creditCard) {
        this.creditCard = creditCard;
        balance = 0;
    }

    public boolean matchCredentials(String cardNumber, String password) {
        return creditCard.matchCredentials(cardNumber, password);
    }

    public int getBalance() {
        return balance;
    }
}
