package backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;


import static org.mockito.Mockito.*;

import static org.junit.Assert.*;


public class PasswordGeneratorTest {

    @Test
    public void isPasswordGeneratedOk() {
        PasswordGenerator underTest = spy(new PasswordGenerator());
        doReturn(1111).when(underTest).generatePIN();
        String generatedPassword = underTest.generatePassword();
        assertEquals("1111", generatedPassword);
    }

    @Test
    public void isPasswordGeneratedWhenNot4Digits() {
        PasswordGenerator underTest = spy(new PasswordGenerator());
        doReturn(11).when(underTest).generatePIN();
        String generatedPassword = underTest.generatePassword();
        assertEquals("0011", generatedPassword);
    }



}