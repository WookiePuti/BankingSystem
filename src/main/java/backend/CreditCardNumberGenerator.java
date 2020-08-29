package backend;

public class CreditCardNumberGenerator implements ICreditCardGenerator {
    private ICheckSumGenerator checkSumGenerator;

    public CreditCardNumberGenerator(ICheckSumGenerator checkSumGenerator) {
        this.checkSumGenerator = checkSumGenerator;
    }

    @Override
    public String generateCreditCardNumber(String canNumber) {
        StringBuilder generatedNumber = new StringBuilder();
        generatedNumber.append(CardConfig.MII);
        generatedNumber.append(CardConfig.IIN);
        generatedNumber.append(canNumber);
        generatedNumber.append(checkSumGenerator.generateCheckSum(generatedNumber.toString()));
        return generatedNumber.toString();
    }
}
