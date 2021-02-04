package com.ironhack.commands;

import com.ironhack.classes.Input;
import com.ironhack.data.DataService;
import com.ironhack.model.*;
import com.ironhack.styles.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
            default:
                break;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW_BOLD + "\nPress 'Enter' to continue");
        sc.nextLine();
    }

    //		First it gets the Lead using the id. Then it creates contact using information in lead and add it to the list.
//		Then it creates opportunity with contact information. The other fields are asked by the class.
// 		Then it creates an account and adds it to the list. Finally, the lead is deleted.
    public void convert(Integer id) {
        Optional<Leadd> leaddFetch = dataService.getLeadById(id);
        List<Account> accountList = dataService.getAccountList();

        if (leaddFetch.isPresent()) {
            Leadd leadd = leaddFetch.get();
            Contact contact = new Contact(leadd.getName(), leadd.getPhoneNumber(), leadd.getEmail(), leadd.getCompanyName());
            dataService.createContact(contact);
            Opportunity opp = new Opportunity(contact);
            dataService.createOpportunity(opp);
            if (accountList.size() < 1) {
                Account account = new Account(contact, opp);
                dataService.createAccount(account);
            } else if (Input.getYesNoUserInput("Would you like to create a new Account?(Y/N)").equals("y")) {
                Account account = new Account(contact, opp);
                dataService.createAccount(account);
            } else {
                while (true) {
                    for (Account acc:accountList) {
                        System.out.println(ConsoleColors.WHITE_BRIGHT+ acc.getId() +
                                        " | Industry: " + ConsoleColors.WHITE_BOLD + acc.getIndustry() +
                                        " | City: " + ConsoleColors.WHITE_BOLD + acc.getCity() +
                                        " | Country: " + ConsoleColors.WHITE_BOLD + acc.getCountry());
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Type an Account ID to associate the Contact and Opportunity");
                    String input = scanner.nextLine().trim();
                    if (Input.validIdFormat(input)) {
                        Optional<Account> account = dataService.getAccountById(Integer.parseInt(input));
                        if (account.isPresent()) {
                            account.get().addContact(contact);
                            account.get().addOpportunity(opp);
                            dataService.updateAccount(account.get());
                            break;
                        }
                        System.out.println("There is not any account with that ID.");
                    }
                }
            }
            System.out.println(ConsoleColors.WHITE_BRIGHT + "--> Lead ID " + leadd.getId() + " converted successfully!");
            System.out.println(ConsoleColors.WHITE_BOLD);
            dataService.deleteLead(leadd);
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Error fetching the ID! Check the ID. If error persists, contact admin.");
            System.out.println(ConsoleColors.WHITE_BOLD);
        }
    }
}
