package backend;

public class CreditCard {
    private final String cardNumber;
    private String passwordPIN;

    public CreditCard(String cardNumber, String passwordPIN) {
        this.cardNumber = cardNumber;
        this.passwordPIN = passwordPIN;
    }

    public boolean matchCredentials(String cardNumber, String password) {
        return cardNumber.equals(this.cardNumber) && password.equals(passwordPIN);
    }
}
