package backend;

public class Account {
    private CreditCard creditCard;
    private int balance;

    public Account(CreditCard creditCard) {
        this.creditCard = creditCard;
        balance = 0;
    }

    public Account(String cardNumber, String password) {
        this.creditCard = new CreditCard(cardNumber, password);
    }

    public boolean matchCredentials(String cardNumber, String password) {
        return creditCard.matchCredentials(cardNumber, password);
    }

    public String getCardNumber() {
        return creditCard.getCardNumber();
    }

    public String getPassword() {
        return creditCard.getPasswordPIN();
    }

    public int getBalance() {
        return balance;
    }
}
