package com.ironhack.commands;

import com.ironhack.classes.Input;
import com.ironhack.data.DataService;
import com.ironhack.model.*;
import com.ironhack.styles.ConsoleColors;
import com.ironhack.styles.Start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

@Service
public class CommandService {
    @Autowired
    private DataService dataService;

    //	commandCaller method is used to parse the different methods available, it will call the adequate one depending on
//	user input.
    public void commandCaller(String[] command) {

        switch (command[0]) {
            case "new":
                if (command[1].equals("lead")) {
                    List<SalesRep> salesRepList = dataService.getSalesRep();
                    if (salesRepList.size() > 0) {
                        try {
                            Leadd newLeadd = new Leadd();
                            newLeadd.setName();
                            newLeadd.setPhoneNumber();
                            newLeadd.setEmail();
                            newLeadd.setCompanyName();
                            newLeadd.setSalesRep(salesRepList);
                            dataService.addLeadd(newLeadd);
                            System.out.println(ConsoleColors.WHITE_BRIGHT +
                                    "--> Lead created successfully with ID: " + newLeadd.getId() +
                                    "  (Total Leads available: " + dataService.getLeaddList().size() + ")");
                        } catch (Exception e) {
                            System.out.println(ConsoleColors.RED_BOLD + "Couldn't save the Lead. Try again!");
                        }
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD
                                + "You must create a Sales Representative before creating a new lead.");
                        System.out.println(ConsoleColors.WHITE_BOLD);
                    }
                } else if (command[1].equals("salesrep")) {
                    try {
                        SalesRep salesRep = new SalesRep();
                        salesRep.setName();
                        dataService.addSalesRep(salesRep);
                        System.out.println(ConsoleColors.WHITE_BRIGHT +
                                "--> Sales representative created successfully with ID: " + salesRep.getId());
                    } catch (Exception e) {
                        System.out.println(ConsoleColors.RED_BOLD + "Couldn't save the SalesRep. Try again!");
                    }
                }
                System.out.println(ConsoleColors.WHITE_BOLD);
                break;
            case "show":
                if (command[1].equals("leads"))
                    dataService.showLeads();
                else if (command[1].equals("salesrep"))
                    dataService.showSalesRep();
                else if (command[1].equals("accounts"))
                    dataService.showAccounts();
                else if (command[1].equals("opps"))
                    dataService.showOpportunities();
                break;
            case "lookup":
                dataService.lookUpLead(Integer.parseInt(command[2]));
                break;
            case "convert":
                convert(Integer.parseInt(command[1]));
                break;
            case "change":
                dataService.changeOpportunityStatus(Integer.parseInt(command[2]));
                break;
            case "exit":
                System.out.println(ConsoleColors.YELLOW_BOLD + "Thank you for using E.M.O.F. CRM!");
                System.out.println(ConsoleColors.WHITE_BOLD);
                System.exit(0);
                break;
            case "reporting":
                while (true) {
                    Start.printSubMenuReport();
                    String[] reportCommand = Input.getValidReportCommand();
                    if (reportCommand[0].equalsIgnoreCase("menu")) {
                        break;
                    } else {
                        reportCommand(reportCommand);
                    }
                }
                break;
            case "stats":
                while (true) {
                    Start.printSubMenuStats();
                    String[] statsCommand = Input.getValidStatsCommand();
                    if (statsCommand[0].equalsIgnoreCase("menu")) {
                        break;
                    } else {
                        statisticsCommand(statsCommand);
                    }
                }
                break;
            default:
                break;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW_BOLD + "\n-> PRESS 'ENTER' TO CONTINUE <-");
        sc.nextLine();
    }

    //	This method calls for the appropriate query in each case.
    private void statisticsCommand(String[] command) {
        String input = "";

        for (String string : command)
            input = input.concat(string) + " ";
        input = input.trim();

        if (input.equals("mean employeecount")) {

        } else if (input.equals("median employeecount")) {

        } else if (input.equals("max employeecount")) {

        } else if (input.equals("min employeecount")) {

        } else if (input.equals("mean quantity")) {

        } else if (input.equals("median quantity")) {

        } else if (input.equals("max quantity")) {

        } else if (input.equals("min quantity")) {

        } else if (input.equals("mean opps per account")) {

        } else if (input.equals("median opps per account")) {

        } else if (input.equals("max opps per account")) {

        } else if (input.equals("min opps per account")) {

        } else {
            System.out.println("You shouldn't be reading this. Something unexpected happened. Please try again.");
        }
    }

    //	reportCommand method calls for the appropriate query in each case.
    private void reportCommand(String[] command) {
        String input = "";

        for (String string : command)
            input = input.concat(string) + " ";
        input = input.trim();

        if (input.equals("report lead by salesrep")) {

        } else if (input.equals("report opportunity by salesrep")) {

        } else if (input.equals("report closed-won by salesrep")) {

        } else if (input.equals("report closed-lost by salesrep")) {

        } else if (input.equals("report open by salesrep")) {

        } else if (input.equals("report opportunity by product")) {

        } else if (input.equals("report closed-won by product")) {

        } else if (input.equals("report closed-lost by product")) {

        } else if (input.equals("report open by product")) {

        } else if (input.equals("report opportunity by country")) {

        } else if (input.equals("report closed-won by country")) {

        } else if (input.equals("report closed-lost by country")) {

        } else if (input.equals("report open by country")) {

        } else if (input.equals("report opportunity by city")) {

        } else if (input.equals("report closed-won by city")) {

        } else if (input.equals("report closed-lost by city")) {

        } else if (input.equals("report open by city")) {

        } else if (input.equals("report opportunity by industry")) {

        } else if (input.equals("report closed-won by industry")) {

        } else if (input.equals("report open by industry")) {

        } else {
            System.out.println("You shouldn't be reading this. Something unexpected happened. Please try again.");
        }
    }

    //		First it gets the Lead using the id. Then it creates contact using information in lead and add it to the list.

    public void convert(Integer id) {
        Optional<Leadd> leaddFetch = dataService.getLeadById(id);
        List<Account> accountList = dataService.getAccountList();
        Account account;
        Contact contact;
        Opportunity opp;
        SalesRep salesRep;

        if (leaddFetch.isPresent()) {
            Leadd leadd = leaddFetch.get();
            salesRep = leadd.getSalesRep();
            contact = new Contact(leadd.getName(), leadd.getPhoneNumber(), leadd.getEmail(), leadd.getCompanyName());

            if (accountList.size() < 1) {
                account = new Account(contact);
            } else if (Input.getYesNoUserInput("Would you like to create a new Account?(Y/N)").equals("y")) {
                account = new Account(contact);
            } else {
                while (true) {
                    for (Account acc : accountList) {
                        System.out.println(ConsoleColors.WHITE_BRIGHT + "ID: " + acc.getId() + " | "
                                + ConsoleColors.WHITE_BOLD +
                                "Industry: " + acc.getIndustry() +
                                ", City: " + acc.getCity() +
                                ", Country: " + acc.getCountry());
                    }
                    Integer input = Input.getNumberUserInput("Type an Account ID to associate the Contact and Opportunity");
                    Optional<Account> accountFetch = dataService.getAccountById(input);
                    if (accountFetch.isPresent()) {
                        account = accountFetch.get();
                        break;
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "There is not any account with that ID.");
                        System.out.print(ConsoleColors.WHITE_BOLD);
                    }
                }
            }
            dataService.createAccount(account);
            contact.setAccount(account);
            dataService.createContact(contact);

            opp = new Opportunity(contact, salesRep, account);
            dataService.createOpportunity(opp);

            System.out.println(ConsoleColors.WHITE_BRIGHT + "--> Lead ID " + leadd.getId() + " converted successfully!");
            System.out.print(ConsoleColors.WHITE_BOLD);
            dataService.deleteLead(leadd);
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Error fetching the ID! Check the ID. If error persists, contact admin.");
            System.out.println(ConsoleColors.WHITE_BOLD);
        }
    }
}
