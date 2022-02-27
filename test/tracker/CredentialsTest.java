package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CredentialsTest {


    @Test
    void checkWrongEmail() {
        boolean isValid = CredentialChecker.checkIfCredentialsCorrect("John Doe email");
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void checkWrongFirstName() {
        boolean isValid = CredentialChecker.checkIfCredentialsCorrect("J. Doe name@domain.com");
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void checkWrongLastName() {
        boolean isValid = CredentialChecker.checkIfCredentialsCorrect("John D. name@domain.com");
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void checkIncorrectCredentials() {
        boolean isValid = CredentialChecker.checkIfCredentialsCorrect("help");
        Assertions.assertEquals(false, isValid);
    }
}
