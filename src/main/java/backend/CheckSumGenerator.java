package backend;

import java.util.Arrays;

public class CheckSumGenerator implements ICheckSumGenerator {
    @Override
    public int generateCheckSum(String cardNumber) {
        int[] cardNums = new int[CardConfig.cardNumberLength-1];
        for (int i = 0; i < cardNums.length; i++) {
            int num = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            num = num % 2 ==0 ? 2*num : num;
            num = num > 9 ? num-9 : num;
            cardNums[i] = num;
        }

        int sum = Arrays.stream(cardNums).sum();
        if (sum % 10 ==0) return 0;
        return 10 - (sum % 10);
    }

    @Override
    public boolean validateCheckSum(String cardNumber) {
        return false;
    }
}
