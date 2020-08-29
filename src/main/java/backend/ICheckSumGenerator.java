package backend;

public interface ICheckSumGenerator {
    int generateCheckSum(String cardNumber);
    public boolean validateCheckSum(String cardNumber);
}
