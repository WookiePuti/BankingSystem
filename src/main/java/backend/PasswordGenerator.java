package backend;

import java.util.Random;

public class PasswordGenerator implements IPasswordGenerator {

    public PasswordGenerator() {
    }

    @Override
    public String generatePassword() {
        StringBuilder generatedPassword = new StringBuilder("");
        generatedPassword.append(generatePIN());
        int passwordLength = 4;
        if (generatedPassword.length()< passwordLength) {
            generatedPassword.insert(0,"0".repeat(passwordLength -generatedPassword.length()));
        }
        return generatedPassword.toString();
    }

    public int generatePIN() {
        Random random = new Random();
        return random.nextInt(9999);
    }
}
