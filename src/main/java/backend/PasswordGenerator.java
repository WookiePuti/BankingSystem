package backend;

import java.util.Random;

public class PasswordGenerator implements IPasswordGenerator {

    public PasswordGenerator() {
    }

    @Override
    public String generatePassword() {
        Random random = new Random();
        StringBuilder generatedPassword = new StringBuilder("");
        generatedPassword.append(random.nextInt(9999));
        int passwordLength = 4;
        if (generatedPassword.length()< passwordLength) {
            generatedPassword.insert(0,"0".repeat(passwordLength -generatedPassword.length()));
        }
        return generatedPassword.toString();
    }
}
