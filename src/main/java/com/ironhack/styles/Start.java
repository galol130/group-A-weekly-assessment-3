package com.ironhack.styles;

public class Start {
    // The following method prints a welcome screen and sets console colors.
    public static void printStart() {
        int titleLength = 29;
        System.out.println(ConsoleColors.BLUE);
        for (int i = 0; i < titleLength; i++) {
            System.out.print("==");
        }
        System.out.println("\n|\tE.M.O.F.  CUSTOMER RELATIONSHIP MANAGEMENT SYSTEM \t |");
        for (int i = 0; i < titleLength; i++) {
            System.out.print("==");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

    public static void printMenuV1(){
        System.out.println("\nWelcome, please write one of the following:\n" +
                ConsoleColors.BLUE + "Leads\n" + ConsoleColors.WHITE_BOLD +
                "\tWrite: 'New lead' to enter a new lead record.\n" +
                "\tWrite: 'Show leads' to view all current leads.\n" +
                "\tWrite: 'Lookup lead + [id]' to search for a specific lead.\n" +
                ConsoleColors.BLUE + "Opportunities\n" + ConsoleColors.WHITE_BOLD +
                "\tWrite: 'Convert + [id]' to convert a lead into an opportunity.\n" +
                "\tWrite: 'Change status' to change an opportunity status.\n" +
                ConsoleColors.BLUE + "Accounts\n" + ConsoleColors.WHITE_BOLD +
                "\tWrite: 'Show accounts' to view all current accounts.\n" +
                "\n" +
                "\tWrite: 'Quit system' to exit.\n");
    }

    public static void printMenuV2(){
        System.out.println("Welcome, please type one of the following commands:\n" +
                ConsoleColors.BLUE + "Leads\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tNew lead"+ ConsoleColors.WHITE_BOLD +" to enter a new lead record.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tShow leads"+ ConsoleColors.WHITE_BOLD +" to view all current leads.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tLookup lead [and type the desired id]"+ ConsoleColors.WHITE_BOLD +" to search for a specific lead.\n" +
                ConsoleColors.BLUE + "Opportunities\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tConvert [and type the desired id]"+ ConsoleColors.WHITE_BOLD +" to convert a lead into an opportunity.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tShow opps"+ ConsoleColors.WHITE_BOLD +" to view all current opportunities.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tChange status [and type the desired id]"+ ConsoleColors.WHITE_BOLD +" to change an opportunity status.\n" +
                ConsoleColors.BLUE + "Accounts\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tShow accounts"+ ConsoleColors.WHITE_BOLD +" to view all current accounts.\n" +
                ConsoleColors.WHITE_BRIGHT + "Exit"+ ConsoleColors.WHITE_BOLD +" to quit the system.");
    }

}
