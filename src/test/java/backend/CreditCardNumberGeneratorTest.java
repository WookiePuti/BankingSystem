package backend;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

public class CreditCardNumberGeneratorTest {
    private CheckSumGenerator mockedCheckSum;

    @Before
    public void setUp() {
        mockedCheckSum = mock(CheckSumGenerator.class);
        when(mockedCheckSum.generateCheckSum(anyString())).thenReturn(1);

    }

    @Test
    public void generateCreditCardNumber() {
        CreditCardNumberGenerator creditCardNumberGenerator = new CreditCardNumberGenerator(mockedCheckSum);
        String can = "1".repeat(CardConfig.CANLength);
        String expected = CardConfig.MII + CardConfig.IIN + can + "1";
        assertEquals(creditCardNumberGenerator.generateCreditCardNumber(can), expected);
        verify(mockedCheckSum, times(1)).generateCheckSum(anyString());
    }
}