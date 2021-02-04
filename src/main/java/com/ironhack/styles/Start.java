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

    public static void printMenuV1() {
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

    public static void printMenuV2() {
        System.out.println("Welcome, please type one of the following commands:\n" +
                ConsoleColors.BLUE + "Sales Representatives\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tNew salesRep" + ConsoleColors.WHITE_BOLD + " to enter a new sales representative.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tShow salesRep" + ConsoleColors.WHITE_BOLD + " to view all current leads.\n" +
                ConsoleColors.BLUE + "Leads\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tNew lead" + ConsoleColors.WHITE_BOLD + " to enter a new lead record.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tShow leads" + ConsoleColors.WHITE_BOLD + " to view all current leads.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tLookup lead [and type the desired id]" + ConsoleColors.WHITE_BOLD + " to search for a specific lead.\n" +
                ConsoleColors.BLUE + "Opportunities\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tConvert [and type the desired id]" + ConsoleColors.WHITE_BOLD + " to convert a lead into an opportunity.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tShow opps" + ConsoleColors.WHITE_BOLD + " to view all current opportunities.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tChange status [and type the desired id]" + ConsoleColors.WHITE_BOLD + " to change an opportunity status.\n" +
                ConsoleColors.BLUE + "Accounts\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tShow accounts" + ConsoleColors.WHITE_BOLD + " to view all current accounts.\n" +
                ConsoleColors.BLUE + "Reporting & Statistics\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tReporting" + ConsoleColors.WHITE_BOLD + " to view all available reports.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tStats" + ConsoleColors.WHITE_BOLD + " to view all available statistics.\n" +
                ConsoleColors.WHITE_BRIGHT + "Exit" + ConsoleColors.WHITE_BOLD + " to quit the system."
        );
    }


    public static void printSubMenuReport() {
        System.out.println(ConsoleColors.WHITE_BRIGHT + "\nPlease type one of the following commands (case insensitive):\n" +
                ConsoleColors.BLUE + "By SalesRep\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tLead by SalesRep" + ConsoleColors.WHITE_BOLD + " to display a count of Leads by SalesRep.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tOpportunity by SalesRep" + ConsoleColors.WHITE_BOLD + " to display a count of all Opportunities by SalesRep.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-WON by SalesRep" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_WON Opportunities by SalesRep.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-LOST by SalesRep" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_LOST Opportunities by SalesRep.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tOPEN by SalesRep" + ConsoleColors.WHITE_BOLD + " to display a count of all OPEN Opportunities by SalesRep.\n" +

                ConsoleColors.BLUE + "By Product\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tOpportunity by product" + ConsoleColors.WHITE_BOLD + " to display a count of all Opportunities by product.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-WON by product" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_WON Opportunities.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-LOST by product" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_LOST Opportunities.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tOPEN by product" + ConsoleColors.WHITE_BOLD + " to display a count of all OPEN Opportunities by product.\n" +

                ConsoleColors.BLUE + "By Country\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tOpportunity by Country" + ConsoleColors.WHITE_BOLD + " to display a count of all Opportunities by country.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-WON by Country" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_WON Opportunities by country.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-LOST by Country" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_LOST Opportunities by country.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tOPEN by Country" + ConsoleColors.WHITE_BOLD + " to display a count of all OPEN Opportunities by country.\n" +

                ConsoleColors.BLUE + "By City\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tOpportunity by City" + ConsoleColors.WHITE_BOLD + " to display a count of all Opportunities by city.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-WON by City" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_WON Opportunities by city.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-LOST by City" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_LOST Opportunities by city.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tOPEN by City" + ConsoleColors.WHITE_BOLD + " to display a count of all OPEN Opportunities by city.\n" +

                ConsoleColors.BLUE + "By Industry\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tOpportunity by Industry" + ConsoleColors.WHITE_BOLD + " to display a count of all Opportunities by industry.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-WON by Industry" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_WON Opportunities by industry.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tCLOSED-LOST by Industry" + ConsoleColors.WHITE_BOLD + " to display a count of all CLOSED_LOST Opportunities by industry.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tOPEN by Industry" + ConsoleColors.WHITE_BOLD + " to display a count of all OPEN Opportunities by industry.\n" +

                ConsoleColors.WHITE_BRIGHT + "Menu" + ConsoleColors.WHITE_BOLD + " to go back to the main menu."
        );
    }

    public static void printSubMenuStats() {
        System.out.println(ConsoleColors.WHITE_BRIGHT + "\nPlease type one of the following commands (case insensitive):\n" +
                ConsoleColors.BLUE + "Employee Count\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tMean EmployeeCount" + ConsoleColors.WHITE_BOLD + " to display the mean employeeCount.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMedian EmployeeCount" + ConsoleColors.WHITE_BOLD + " to display the median employeeCount.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMax EmployeeCount" + ConsoleColors.WHITE_BOLD + " to display the maximum employeeCount.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMin EmployeeCount" + ConsoleColors.WHITE_BOLD + " to display the minimum employeeCount.\n" +

                ConsoleColors.BLUE + "Quantity\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tMean Quantity" + ConsoleColors.WHITE_BOLD + " to display the mean quantity of products order.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMedian Quantity" + ConsoleColors.WHITE_BOLD + " to display the median quantity of products order.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMax Quantity" + ConsoleColors.WHITE_BOLD + " to display the maximum quantity of products order.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMin Quantity" + ConsoleColors.WHITE_BOLD + " to display the minimum quantity of products order.\n" +

                ConsoleColors.BLUE + "Opportunity\n" + ConsoleColors.WHITE_BOLD +
                ConsoleColors.WHITE_BRIGHT + "\tMean Opps per Account" + ConsoleColors.WHITE_BOLD + " to display the mean number of Opportunities associated with an Account.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMedian Opps per Account" + ConsoleColors.WHITE_BOLD + " to display the median number of Opportunities associated with an Account.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMax Opps per Account" + ConsoleColors.WHITE_BOLD + " to display the maximum number of Opportunities associated with an Account.\n" +
                ConsoleColors.WHITE_BRIGHT + "\tMin Opps per Account" + ConsoleColors.WHITE_BOLD + " to display the minimum number of Opportunities associated with an Account.\n" +

                ConsoleColors.WHITE_BRIGHT + "Menu" + ConsoleColors.WHITE_BOLD + " to go back to the main menu."
        );
    }
}
