package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddStudentTest {

    @Test
    void addStudent() {
        boolean isValid = DataStore.addStudentToDataStore("John Doe johnd@yahoo.com");
        Assertions.assertEquals(true, isValid);
    }

    @Test
    void checkUniqueEmail() {
        DataStore.addStudentToDataStore("John Doe johnd@yahoo.com");
        boolean isValid = DataStore.addStudentToDataStore("John Doe johnd@yahoo.com");
        Assertions.assertEquals(false, isValid);
    }
}
