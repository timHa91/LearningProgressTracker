package tracker;

import java.util.Scanner;

public class InputChecker {

    public static String parseInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input == null || input.isEmpty() || input.isBlank()) input = "null";

        return input;
    }
}
