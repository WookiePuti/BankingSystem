package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    private CreditCard underTest;

    @Before
    public void setUp() {
    underTest = new CreditCard("1234567890123456", "1234");
    }

    @Test
    public void testMatchCredentialsTrue() {
        assertTrue(underTest.matchCredentials("1234567890123456", "1234" ));
    }

    @Test
    public void testMatchCredentialsBadCardNum() {
        assertFalse(underTest.matchCredentials("1234567890123450", "1234" ));
    }

    @Test
    public void testMatchCredentialsBadPassword() {
        assertFalse(underTest.matchCredentials("1234567890123456", "1111" ));
    }


}