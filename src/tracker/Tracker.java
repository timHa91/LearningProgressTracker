package tracker;


import static tracker.Message.printMessage;
import static tracker.InputParser.*;
import static tracker.MenuPrinter.*;


public class Tracker {

    public void startTracker() {
        printMessage(Message.APP_TITLE);
        processInput();
    }

    private void processInput() {
        while (true) {
            String input = parseInput();
            printMainMenu(input);
        }
    }
}
