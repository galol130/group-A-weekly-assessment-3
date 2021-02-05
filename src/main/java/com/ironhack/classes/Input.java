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
            System.out.print(ConsoleColors.WHITE_BOLD);
            command = scanner.nextLine().toLowerCase().trim();
            commandSplit = command.split(" ");
//          Validates if the command is ok and doesn't require an [id]
            if (command.equals("new lead")
                    || command.equals("new salesrep")
                    || command.equals("show leads")
                    || command.equals("show accounts")
                    || command.equals("show opps")
                    || command.equals("show salesrep")
                    || command.equals("reporting")
                    || command.equals("stats")
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
                System.out.print(ConsoleColors.WHITE_BOLD);
            }
        }
    }

        public static String[] getValidReportCommand () {
            Scanner scanner = new Scanner(System.in);
            String command;
            String[] commandSplit;

            while (true) {
                System.out.println(ConsoleColors.YELLOW_BOLD + "\nType a command:");
                System.out.print(ConsoleColors.WHITE_BOLD);
                command = scanner.nextLine().toLowerCase().trim();
                commandSplit = command.split(" ");

                if(commandSplit[0].equalsIgnoreCase("menu"))
                    return commandSplit;
                if (commandSplit.length == 3) {
                    if (report(command))
                        return commandSplit;
                }else {
//              Command is not correct
                    System.out.println(ConsoleColors.RED_BOLD + "The command typed does not match any available one. Try again!");
                    System.out.print(ConsoleColors.WHITE_BOLD);
                }
            }
        }

        public static String[] getValidStatsCommand () {
            Scanner scanner = new Scanner(System.in);
            String command;
            String[] commandSplit;

            while (true) {
                System.out.println(ConsoleColors.YELLOW_BOLD + "\nType a command:");
                System.out.print(ConsoleColors.WHITE_BOLD);
                command = scanner.nextLine().toLowerCase().trim();
                commandSplit = command.split(" ");

                if(commandSplit[0].equalsIgnoreCase("menu"))
                    return commandSplit;
                if (commandSplit[0].equals("mean") || commandSplit[0].equals("median") ||
                        commandSplit[0].equals("max") || commandSplit[0].equals("min")) {
                    if (statistics(command))
                        return commandSplit;
                }else {
//              Command is not correct
                    System.out.println(ConsoleColors.RED_BOLD + "The command typed does not match any available one. Try again!");
                    System.out.print(ConsoleColors.WHITE_BOLD);
                }
            }
        }

        private static boolean statistics (String command){

            if (command.equalsIgnoreCase("mean employeecount")
                    || (command.equalsIgnoreCase("median employeecount"))
                    || (command.equalsIgnoreCase("max employeecount"))
                    || (command.equalsIgnoreCase("min employeecount"))
                    || (command.equalsIgnoreCase("mean quantity"))
                    || (command.equalsIgnoreCase("median quantity"))
                    || (command.equalsIgnoreCase("max quantity"))
                    || (command.equalsIgnoreCase("min quantity"))
                    || (command.equalsIgnoreCase("mean opps per account"))
                    || (command.equalsIgnoreCase("median opps per account"))
                    || (command.equalsIgnoreCase("max opps per account"))
                    || (command.equalsIgnoreCase("min opps per account"))) {
                return true;
            } else {
                System.out.println("Not a valid statistics request.");
                return false;
            }
        }

        //Validates if it's a valid report
        private static boolean report (String input){
            if (input.equalsIgnoreCase("lead by salesrep")
                || input.equalsIgnoreCase("opportunity by salesrep")
                || input.equalsIgnoreCase("closed-won by salesrep")
                || input.equalsIgnoreCase("closed-lost by salesrep")
                || input.equalsIgnoreCase("open by salesrep")
                || input.equalsIgnoreCase("opportunity by product")
                || input.equalsIgnoreCase("closed-won by product")
                || input.equalsIgnoreCase("closed-lost by product")
                || input.equalsIgnoreCase("open by product")
                || input.equalsIgnoreCase("opportunity by country")
                || input.equalsIgnoreCase("closed-won by country")
                || input.equalsIgnoreCase("closed-lost by country")
                || input.equalsIgnoreCase("open by country")
                || input.equalsIgnoreCase("opportunity by city")
                || input.equalsIgnoreCase("closed-won by city")
                || input.equalsIgnoreCase("closed-lost by city")
                || input.equalsIgnoreCase("open by city")
                || input.equalsIgnoreCase("opportunity by industry")
                || input.equalsIgnoreCase("closed-won by industry")
                || input.equalsIgnoreCase("closed-lost by industry")
                || input.equalsIgnoreCase("open by industry")) {
                return true;
            } else {
                System.out.println("Not a valid report.");
                return false;
            }
        }

        //    Validates if Id is a positive integer
        public static boolean validIdFormat (String stringId){
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
        public static String getStringUserInput (String prompt){
            Scanner scanner = new Scanner(System.in);
            String userString;

            while (true) {
                System.out.println(ConsoleColors.WHITE_BOLD + prompt);
                userString = scanner.nextLine();
                if (userString.trim().length() > 0) {
                    return userString.trim();
                } else {
                    System.out.println(ConsoleColors.RED_BOLD + "Not a valid input.");
                    System.out.println(ConsoleColors.WHITE_BOLD);
                }
            }
        }

//      This method verifies that the phone number is an actual number (it allows for a + sign at the beginning
        public static String getPhoneUserInput (String prompt){
            Scanner scanner = new Scanner(System.in);
            String userPhone;
            while (true) {
                boolean check = false;
                System.out.println(ConsoleColors.WHITE_BOLD + prompt);
                userPhone = scanner.nextLine();
                if (userPhone.charAt(0) == '+') {
                    userPhone = userPhone.replace("+", "");
                    String[] splitPhone = userPhone.split(" ");
                    for (String s : splitPhone) {
                        if (check) break;
                        for (int i = 0; i < s.length(); i++) {
                            if ((int) s.charAt(i) < 47 || (int) s.charAt(i) > 58) {
                                check = true;
                                break;
                            }
                        }
                    }
                    if (!check && userPhone.length() > 9 && userPhone.length() < 13) {
                        return userPhone.trim();
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "Not a valid phone.");
                        System.out.println(ConsoleColors.WHITE_BOLD);
                    }
                } else {
                    String[] splitPhone = userPhone.split(" ");
                    for (String s : splitPhone) {
                        if (check) break;
                        for (int i = 0; i < s.length(); i++) {
                            if ((int) s.charAt(i) < 47 || (int) s.charAt(i) > 58) {
                                check = true;
                                break;
                            }
                        }
                    }
                    if (!check && userPhone.length() > 8 && userPhone.length() < 12) {
                        return userPhone.trim();
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "Not a valid phone.");
                        System.out.println(ConsoleColors.WHITE_BOLD);
                    }
                }
            }
        }

//      This method verifies that the email entered has an @ and a dot after it.
        public static String getEmailUserInput (String prompt){
            Scanner scanner = new Scanner(System.in);
            String userEmail;

            while (true) {
                System.out.println(ConsoleColors.WHITE_BOLD + prompt);
                userEmail = scanner.nextLine();
                if (userEmail.contains("@")) {
                    String[] splitEmail = userEmail.split("@");
                    if (splitEmail.length == 2 && !splitEmail[0].isEmpty()) {
                        String[] splitDottedEmail = splitEmail[1].split("\\.");
                            if (splitDottedEmail.length == 2 && !splitDottedEmail[0].isEmpty()) {
                                return userEmail.trim();
                            }
                            else {
                                System.out.println(ConsoleColors.RED_BOLD + "Not a valid email.");
                                System.out.println(ConsoleColors.WHITE_BOLD);
                            }
                    }
                    else {
                        System.out.println(ConsoleColors.RED_BOLD + "Not a valid email.");
                        System.out.println(ConsoleColors.WHITE_BOLD);
                    }
                } else {
                    System.out.println(ConsoleColors.RED_BOLD + "Not a valid email.");
                    System.out.println(ConsoleColors.WHITE_BOLD);
                }
            }
        }

        //  The method takes the prompt (message) and the Enums as an array list
//  (To do this, use '(String[]) Arrays.stream(<EnumeratorName>.values()).toArray()' when calling the method)
        public static String getEnumUserInput (String prompt, String[]enumList){
            Scanner scanner = new Scanner(System.in);
            String userString;

            while (true) {
                System.out.println(ConsoleColors.WHITE_BOLD);
                System.out.println(prompt);
                for (String enumElement : enumList) {
                    System.out.println("\t" + enumElement);
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
        public static int getNumberUserInput (String prompt){
            Scanner scanner = new Scanner(System.in);
            String str = "";
            int result = 0;

            while (str.length() < 1) {
                System.out.println(prompt);
                str = scanner.nextLine();
                try {
                    result = Integer.parseInt(str);
                    if (result < 1) {
                        System.out.println(ConsoleColors.RED_BOLD + "Number must be positive and not null.");
                        System.out.println(ConsoleColors.WHITE_BOLD);
                        str = "";
                    }
                } catch (NumberFormatException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "You must type a number.");
                    System.out.println(ConsoleColors.WHITE_BOLD);
                    str = "";
                } catch (Exception e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Something was wrong.");
                    str = "";
                }
            }
            return result;
        }

        //      The method takes the prompt (message) and returns the user input (yes or no) as a String
        public static String getYesNoUserInput (String prompt){
            Scanner scanner = new Scanner(System.in);
            String userString;

            while (true) {
                System.out.println(prompt);
                userString = scanner.nextLine();
                if (userString.trim().equalsIgnoreCase("y") || userString.trim().equalsIgnoreCase("yes")) {
                    return "y";
                } else if (userString.trim().equalsIgnoreCase("n") || userString.trim().equalsIgnoreCase("no")) {
                    return "n";
                } else {
                    System.out.println(ConsoleColors.RED_BOLD + "Not a valid input.");
                    System.out.println(ConsoleColors.WHITE_BOLD);
                }
            }
        }

//  Gets and dismisses whatever the users type. It's intended to catch "Press 'Enter' to continue"
    public static void getEnterToContinue() {
        Scanner scanner = new Scanner(System.in);
        String userString = scanner.nextLine();
    }
}
