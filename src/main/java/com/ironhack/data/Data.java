package com.ironhack.data;

import com.ironhack.classes.*;
import com.ironhack.enums.Status;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Leadd;
import com.ironhack.model.Opportunity;
import com.ironhack.styles.ConsoleColors;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<Leadd> leaddList = new ArrayList<>();
    private static List<Opportunity> opportunityList = new ArrayList<>();
    private static List<Contact> contactList = new ArrayList<>();
    private static List<Account> accountList = new ArrayList<>();

//  showLeads() will show a list of all leads' ID and name. It just shows them on the console. As explained in the
//  method createID() in the Lead class, IDs are also the position of each lead in the leadList.
    public static void showLeads() {
        if (leaddList.size() > 0) {
            System.out.println(ConsoleColors.WHITE_BRIGHT + "Leads:");
            for (Leadd leadd : leaddList) {
                System.out.println(ConsoleColors.WHITE_BRIGHT + "\tID " + leadd.getId() +
                        ConsoleColors.WHITE_BOLD + " --> Name: " + leadd.getName() +
                        ", Company: " + leadd.getCompanyName());
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No leads to show, list empty.");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

//  lookUpLead will show all the details of a lead on the console. It just iterates through our list of leads and
//  print the information whenever there is a coincidence of IDs. If there is no coincidence, it will show an
//  error message.
    public static void lookUpLead(int id) {
        boolean check = false;
        for (Leadd leadd : leaddList) {
            if (id == leadd.getId()) {
                check = true;
                System.out.println(ConsoleColors.WHITE_BRIGHT + leadd);
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
        }
        if (!check) {
            System.out.println(ConsoleColors.RED_BOLD + "Sorry, we can't find this ID in our database.");
            System.out.println(ConsoleColors.WHITE_BOLD);
        }
    }

////  Adds an opportunity to the list of opportunities
//    public static void addOpportunity(Opportunity opportunity) {
//        opportunityList.add(opportunity);
//    }

    //Removes the desired lead
    public static void deleteLead(Leadd leadd) {
        if (leaddList.contains(leadd)) {
            leaddList.remove(leadd);
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Sorry, the lead is not in the Lead List.");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

//  Looks for the opportunity and changes it's status accordingly to the user input
    public static void changeOpportunityStatus(int id) {
        Opportunity opp = getOpportunityById(id);
        if(opp != null){
            String option = "";
            while (!option.equals("won") && !option.equals("lost")){
                option = Input.getStringUserInput("Type "+
                        ConsoleColors.WHITE_BRIGHT+ "'won'" +
                        ConsoleColors.WHITE_BOLD + " or " +
                        ConsoleColors.WHITE_BRIGHT + "'lost'" +
                        ConsoleColors.WHITE_BOLD + "to close the Opportunity and change its status.").toLowerCase();
            }
            if(option.equals("won")){
                opp.setStatus(Status.CLOSED_WON);
                System.out.println(ConsoleColors.WHITE_BRIGHT + "--> Opportunity "+ id + "set as 'Closed-Won'.");
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
            if(option.equals("lost")){
                opp.setStatus(Status.CLOSED_LOST);
                System.out.println(ConsoleColors.WHITE_BRIGHT + "--> Opportunity " + id + " set as 'Closed-Lost'.");
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
        }else{
            System.out.println(ConsoleColors.RED_BOLD + "Sorry, we can't find this ID in our database.");
            System.out.println(ConsoleColors.WHITE_BOLD);
        }
    }

//  Looks for an opportunity by id
    public static Opportunity getOpportunityById(int id) {
        Opportunity oppFound = null;
        for (Opportunity opp : opportunityList) {
            if (opp.getId() == id) {
                oppFound = opp;
            }
        }
        return oppFound;
    }

    public static void showAccounts() {
        if (accountList.size() > 0) {
            System.out.println(ConsoleColors.WHITE_BRIGHT + "Accounts: ");
            for (Account account : accountList) {
                System.out.println(account.toString());
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No accounts created yet!");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

    public static void showOpportunities() {
        if (opportunityList.size() > 0) {
            System.out.println(ConsoleColors.WHITE_BRIGHT + "Opportunities:");
            for (Opportunity opportunity : opportunityList) {
                System.out.println(opportunity.toString());
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No Opportunities created yet!");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

    public static List<Leadd> getLeadList() {
        return leaddList;
    }

//  Finds a Lead by id
    public static Leadd getLeadById(Integer id) {
        Leadd foundLeadd = null;
        for (Leadd leadd : leaddList) {
            if (leadd.getId() == id) {
                foundLeadd = leadd;
            }
        }
        return foundLeadd;
    }

    //  Finds a Account by id
    public static Account getAccountById(Integer id) {
        Account foundAccount = null;
        for (Account account : accountList) {
            if (account.getId() == id) {
                foundAccount = account;
            }
        }
        return foundAccount;
    }

    public static List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public static List<Contact> getContactList() {
        return contactList;
    }

    public static List<Account> getAccountList() {
        return accountList;
    }

    public static void setLeadList(List<Leadd> leaddList) {
        Data.leaddList = leaddList;
    }

    public static void setOpportunityList(List<Opportunity> opportunityList) {
        Data.opportunityList = opportunityList;
    }

    public static void setContactList(List<Contact> contactList) {
        Data.contactList = contactList;
    }

    public static void setAccountList(List<Account> accountList) {
        Data.accountList = accountList;
    }
}
