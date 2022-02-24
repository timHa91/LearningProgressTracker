package tracker;

import static tracker.Message.*;
import static tracker.CredentialChecker.*;
import static tracker.InputParser.*;

public class MenuPrinter {

    public static void printMainMenu(String userInput) {
        switch (userInput) {
            case "null":
                printMessage(Message.NO_INPUT);
                break;
            case "exit":
                printMessage(Message.EXIT_SUCCESS);
                System.exit(0);
                break;
            case "add students":
                printMessage(Message.ADD_STUDENT);
                printAddStudentsMenu();
                break;
            case "back":
                printMessage(Message.EXIT);
                break;
            default:
                printMessage(Message.UNKNOWN_INPUT);
                break;
        }
    }

    public static void printAddStudentsMenu() {
        int countAddedStudents = 0;

        while (true) {
            String userInput = parseInput();
            if (userInput.contains("back")) {
                break;
            }

            boolean valid = checkIfCredentialsCorrect(userInput);
            if (valid) {
                printMessage(Message.ADD_STUDENT_SUCCESS);
                countAddedStudents++;
            }
        }
        printFormatMessage(Message.ADD_STUDENT_SUCCESS_TOTAL, countAddedStudents);
    }
 }