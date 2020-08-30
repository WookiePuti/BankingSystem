package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckSumGeneratorTest {
    private CheckSumGenerator underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new CheckSumGenerator();
    }

    //desired checksum thanks to an online calculator
    @Test
    public void generateCheckSum() {
        String dogits = "123456789012345";
        assertEquals(2, underTest.generateCheckSum(dogits));
    }
}