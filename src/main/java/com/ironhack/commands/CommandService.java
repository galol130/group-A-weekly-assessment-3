package com.ironhack.commands;

import com.ironhack.classes.Input;
import com.ironhack.data.DataService;
import com.ironhack.model.*;
import com.ironhack.repository.*;
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

    @Autowired
    private LeaddRepository leaddRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private AccountRepository accountRepository;

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
                    Scanner sc = new Scanner(System.in);
                    System.out.println(ConsoleColors.YELLOW_BOLD + "\n-> PRESS 'ENTER' TO CONTINUE <-");
                    sc.nextLine();
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
                    Scanner sc = new Scanner(System.in);
                    System.out.println(ConsoleColors.YELLOW_BOLD + "\n-> PRESS 'ENTER' TO CONTINUE <-");
                    sc.nextLine();
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
        Integer result = 0;

        for (String string : command)
            input = input.concat(string) + " ";
        input = input.trim();

        if (input.equals("mean employeecount")) {
            result = accountRepository.findAvgEmployeeCount();
        } else if (input.equals("median employeecount")) {

        } else if (input.equals("max employeecount")) {
            result = accountRepository.findMaxEmployeeCount();
        } else if (input.equals("min employeecount")) {
            result = accountRepository.findMinEmployeeCount();
        } else if (input.equals("mean quantity")) {
            result = opportunityRepository.findAvgProductsOrdered();
        } else if (input.equals("median quantity")) {

        } else if (input.equals("max quantity")) {
            result = opportunityRepository.findMaxProductsOrdered();
        } else if (input.equals("min quantity")) {
            result = opportunityRepository.findMinProductsOrdered();
        } else if (input.equals("mean opps per account")) {
            result = accountRepository.findAvgNumberOfOpportunities();
        } else if (input.equals("median opps per account")) {

        } else if (input.equals("max opps per account")) {
            result = accountRepository.findMaxNumberOfOpportunities();
        } else if (input.equals("min opps per account")) {
            result = accountRepository.findMinNumberOfOpportunities();
        } else {
            System.out.println("You shouldn't be reading this. Something unexpected happened. Please try again.");
        }
        System.out.println(ConsoleColors.WHITE_BRIGHT + "--> The result is: " + result);
        System.out.print(ConsoleColors.WHITE_BOLD);
    }

    //	reportCommand method calls for the appropriate query in each case.
    private void reportCommand(String[] command) {
        String input = "";
        List<Object[]> result = null;

        for (String string : command)
            input = input.concat(string) + " ";
        input = input.trim();

        if (input.equals("lead by salesrep")) {
            result = leaddRepository.findBySalesRep();
        } else if (input.equals("opportunity by salesrep")) {
            result = opportunityRepository.findBySalesRep();
        } else if (input.equals("closed-won by salesrep")) {

        } else if (input.equals("closed-lost by salesrep")) {

        } else if (input.equals("open by salesrep")) {

        } else if (input.equals("opportunity by product")) {
            result = opportunityRepository.findByProduct();
        } else if (input.equals("closed-won by product")) {

        } else if (input.equals("closed-lost by product")) {

        } else if (input.equals("open by product")) {

        } else if (input.equals("opportunity by country")) {
            result = opportunityRepository.findByCountry();
        } else if (input.equals("closed-won by country")) {

        } else if (input.equals("closed-lost by country")) {

        } else if (input.equals("open by country")) {

        } else if (input.equals("opportunity by city")) {
            result = opportunityRepository.findByCity();
        } else if (input.equals("closed-won by city")) {

        } else if (input.equals("closed-lost by city")) {

        } else if (input.equals("open by city")) {

        } else if (input.equals("opportunity by industry")) {
            result = opportunityRepository.findByIndustry();
        } else if (input.equals("closed-won by industry")) {

        } else if (input.equals("open by industry")) {

        } else {
            System.out.println("You shouldn't be reading this. Something unexpected happened. Please try again.");
        }

        if(result != null){
            System.out.println(ConsoleColors.WHITE_BRIGHT + "\n");
            for (Object[] objects : result) {
                for (int i = 0; i < objects.length; i++) {
                    System.out.print(objects[i] + " ");
                }
                System.out.println("");
            }
        }else
            System.out.println(ConsoleColors.RED_BOLD + "We don't have enough data to get this report ready!");
        System.out.print(ConsoleColors.WHITE_BOLD);
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
