package com.ironhack.classes;

import com.ironhack.styles.ConsoleColors;
import java.util.Scanner;

public class Input {

//  Validates a command typed by a user, returning the command as an array of strings only if it's a valid one.
    public static String[] getValidCommand() {
        Scanner scanner = new Scanner(System.in);
        String command;
        String[] commandSplit;

        while (true) {
            System.out.println(ConsoleColors.YELLOW_BOLD + "\nType a command:");
            System.out.println(ConsoleColors.WHITE_BOLD);
            command = scanner.nextLine().toLowerCase().trim();
            commandSplit = command.split(" ");
//          Validates if the command is ok and doesn't require an [id]
            if (command.equals("new lead")
                    || command.equals("new salesrep")
                    || command.equals("show leads")
                    || command.equals("show accounts")
                    || command.equals("show opps")
                    || command.equals("exit")) {
                return commandSplit;
            } else if (commandSplit.length == 2
                    && commandSplit[0].equals("convert")) {
//              Here must validate id is a number
                if (validIdFormat(commandSplit[1]))
                    return commandSplit;
            } else if (commandSplit.length == 3
                    && commandSplit[0].concat(commandSplit[1]).equals("lookuplead")) {
//              Here must validate id is a number;
                if (validIdFormat(commandSplit[2]))
                    return commandSplit;
            } else if (commandSplit.length == 3 &&
                    commandSplit[0].concat(commandSplit[1]).equals("changestatus")) {
//              Here must validate id is a number;
                if (validIdFormat(commandSplit[2]))
                    return commandSplit;
            } else {
//              Command is not correct
                System.out.println(ConsoleColors.RED_BOLD + "The command typed does not match any available one. Try again!");
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
        }
    }

//    Validates if Id is a positive integer
    public static boolean validIdFormat(String stringId) {
        try {
            int numId = Integer.parseInt(stringId);
            if (numId <= 0) {
                System.out.println(ConsoleColors.RED_BOLD + "Number must be positive.");
                System.out.println(ConsoleColors.WHITE_BOLD);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD + "Error: An integer was expected as an Id");
        }
        return false;
    }

//      The method takes the prompt (message) and returns the user input as a String
    public static String getStringUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userString;

        while (true) {
            System.out.println(prompt);
            userString = scanner.nextLine();
            if (userString.trim().length() > 0) {
                return userString.trim();
            }
            else {
                System.out.println(ConsoleColors.RED_BOLD + "Not a valid input.");
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
        }
    }

//  The method takes the prompt (message) and the Enums as an array list
//  (To do this, use '(String[]) Arrays.stream(<EnumeratorName>.values()).toArray()' when calling the method)
    public static String getEnumUserInput(String prompt, String[] enumList) {
        Scanner scanner = new Scanner(System.in);
        String userString;

        while (true) {
            System.out.println(ConsoleColors.WHITE_BOLD);
            System.out.println(prompt);
            for (String enumElement : enumList) {
                System.out.println("\t"+enumElement);
            }
            userString = scanner.nextLine().trim().toUpperCase();
            for (String enumElement : enumList) {
                if (userString.equals(enumElement)) {
                    return enumElement;
                }
            }
            System.out.println(ConsoleColors.RED_BOLD + "Not a valid input. Try again.");
            System.out.println(ConsoleColors.WHITE_BOLD);
        }
    }

//      The method takes the prompt (message) and returns the user input as an int or catches a exception if it isn't
    public static int getNumberUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String	str = "";
        int		result = 0;

        while (str.length() < 1) {
            System.out.println(prompt);
            str = scanner.nextLine();
            try {
                result = Integer.parseInt(str);
                if (result < 0) {
                    System.out.println(ConsoleColors.RED_BOLD + "Number must be positive.");
                    System.out.println(ConsoleColors.WHITE_BOLD);
                    str = "";
                }
            }
            catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED_BOLD + "You must type a number.");
                System.out.println(ConsoleColors.WHITE_BOLD);
                str = "";
            }
            catch (Exception e) {
                System.out.println(ConsoleColors.RED_BOLD + "Something was wrong.");
                str = "";
            }
        }
        return result;
    }

    //      The method takes the prompt (message) and returns the user input (yes or no) as a String
    public static String getYesNoUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userString;

        while (true) {
            System.out.println(prompt);
            userString = scanner.nextLine();
            if (userString.trim().toLowerCase().equals("y") || userString.trim().toLowerCase().equals("yes")) {
                return "y";
            }
            else if (userString.trim().toLowerCase().equals("n") || userString.trim().toLowerCase().equals("no")) {
                return "n";
            }
            else {
                System.out.println(ConsoleColors.RED_BOLD + "Not a valid input.");
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
        }
    }
}
