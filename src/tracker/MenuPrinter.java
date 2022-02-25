package tracker;

import static tracker.Message.*;
import static tracker.CredentialChecker.*;
import static tracker.InputChecker.*;
import static tracker.LearningProgressChecker.*;

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
                addStudentsMenu();
                break;
            case "back":
                printMessage(Message.EXIT);
                break;
            case "list":
                DataStore.printListOfStudents();
                break;
            case "add points":
                printMessage(Message.ADD_POINTS);
                addPointsMenu();
                break;
            case "find":
                printMessage(Message.FIND);
                findMenu();
                break;
            default:
                printMessage(Message.UNKNOWN_INPUT);
                break;
        }
    }

    public static void addStudentsMenu() {
        int countAddedStudents = 0;

        while (true) {
            String userInput = parseInput();
            if (userInput.contains("back")) {
                break;
            }

            boolean valid = checkIfCredentialsCorrect(userInput);
            if (valid) {
                if (DataStore.addStudentToDataStore(userInput)) {
                    printMessage(Message.ADD_STUDENT_SUCCESS);
                    countAddedStudents++;
                } else printMessage(Message.EMAIL_TAKEN);
            }
        }
        printFormatMessageWithInt(Message.ADD_STUDENT_SUCCESS_TOTAL, countAddedStudents);
    }

    public static void addPointsMenu() {
        while (true) {
            String userInput = parseInput();
            if (userInput.contains("back")) {
                break;
            }
            boolean valid = checkLearningProgressInput(userInput);
            if (valid) {
                String[] inputParts = userInput.split("\\s+");
                String id = inputParts[0];
                DataStore.getStudentFromId(id).addLearningProgress(inputParts[1], inputParts[2], inputParts[3] ,inputParts[4]);
                printMessage(ADD_POINTS_SUCCESS);
            }
        }
    }

    public static void findMenu() {
        while (true) {
            String userInput = parseInput();
            if (userInput.contains("back")) {
                break;
            }
            if(DataStore.checkIfIdExists(userInput)) {
                DataStore.getStudentFromId(userInput).printPoints(userInput);
            }
            else printFormatMessageWithString(STUDENT_NOT_FOUND_WITH_ID, userInput);
        }
    }
}