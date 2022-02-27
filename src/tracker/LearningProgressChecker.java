package tracker;

import static tracker.Message.*;

public class LearningProgressChecker {

    public static boolean checkLearningProgressInput(String input) {
        String[] inputParts = input.split("\\s+");
        // Check correct number of input
        if(inputParts.length != 5) {
            printMessage(Message.ADD_POINTS_INVALID_FORMAT);
            return false;
        }
        // Check if ID exists
        if(!DataStore.checkIfIdExists(inputParts[0])){
            printFormatMessageWithString(STUDENT_NOT_FOUND_WITH_ID, inputParts[0]);
            System.out.println("");
            return false;
        }

        // Check if every number has valid format
        for(int i = 1; i < inputParts.length; i++) {
            int points;
            try {
                points = Integer.parseInt(inputParts[i]);
            }
            catch (NumberFormatException e) {
                points = -1;
            }
            if(points < 0) {
                printMessage(Message.ADD_POINTS_INVALID_FORMAT);
                return false;
            }
        }
        return true;
    }
}
