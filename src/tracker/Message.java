package tracker;

public class Message {

    public static final String EXIT_SUCCESS = "Bye!";
    public static final String EXIT = "Enter 'exit' to exit the program.";
    public static final String NO_INPUT = "No input.";
    public static final String UNKNOWN_INPUT = "Error: unknown command!";
    public static final String APP_TITLE = "Learning Progress Tracker";
    public static final String ADD_STUDENT = "Enter student credentials or 'back' to return";
    public static final String ADD_STUDENT_SUCCESS = "The student has been added.";
    public static final String ADD_STUDENT_SUCCESS_TOTAL = "Total %d students have been added.%n";
    public static final String ADD_STUDENT_ERROR_CREDENTIALS = "Incorrect credentials.";
    public static final String ADD_STUDENT_ERROR_EMAIL = "Incorrect email.";
    public static final String ADD_STUDENT_ERROR_FIRST_NAME = "Incorrect first name.";
    public static final String ADD_STUDENT_ERROR_LAST_NAME = "Incorrect last name.";

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
    public static void printFormatMessage(String msg, int number) {System.out.printf(msg, number);}
}
