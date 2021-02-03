package com.ironhack.data;

import com.ironhack.classes.*;
import com.ironhack.enums.Status;
import com.ironhack.model.*;
import com.ironhack.repository.*;
import com.ironhack.styles.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
//  Repositories will be used to persist and retrieve data
    @Autowired
    private LeaddRepository leaddRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private AccountRepository accountRepository;


//  showSalesRep() will show a list of all sales representatives' ID and name. It just shows them on the console.
    public void showSalesRep() {
        List<SalesRep> salesRepList = salesRepRepository.findAll();
        if (salesRepList.size() > 0) {
            System.out.println(ConsoleColors.WHITE_BRIGHT + "Sales Representatives:");
            for (SalesRep salesRep : salesRepList) {
                System.out.println(ConsoleColors.WHITE_BRIGHT + "\tID " + salesRep.getId() +
                        ConsoleColors.WHITE_BOLD + " --> Name: " + salesRep.getName());
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No sales representatives to show, the is list empty.");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }


//  showLeads() will show a list of all leads' ID, name and company. It just shows them on the console.
    public void showLeads() {
        List<Leadd> leaddList = leaddRepository.findAll();
        if (leaddList.size() > 0) {
            System.out.println(ConsoleColors.WHITE_BRIGHT + "Leads:");
            for (Leadd leadd : leaddList) {
                System.out.println(ConsoleColors.WHITE_BRIGHT + "\tID " + leadd.getId() +
                        ConsoleColors.WHITE_BOLD + " --> Name: " + leadd.getName() +
                        ", Company: " + leadd.getCompanyName());
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No leads to show, the list is empty.");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

//  lookUpLead will show all the details of a lead on the console. It just iterates through our list of leads and
//  print the information whenever there is a coincidence of IDs. If there is no coincidence, it will show an
//  error message.
    public void lookUpLead(int id) {
        List<Leadd> leaddList = leaddRepository.findAll();
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
    public void deleteLead(Leadd leadd) {
        List<Leadd> leaddList = leaddRepository.findAll();
        if (leaddList.contains(leadd)) {
            leaddList.remove(leadd);
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Sorry, the lead is not in the Lead List.");
        }
        System.out.println(ConsoleColors.WHITE_BOLD);
    }

//  Looks for the opportunity and changes it's status accordingly to the user input
    public void changeOpportunityStatus(int id) {
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
    public Opportunity getOpportunityById(int id) {
        List<Opportunity> opportunityList = opportunityRepository.findAll();
        Opportunity oppFound = null;
        for (Opportunity opp : opportunityList) {
            if (opp.getId() == id) {
                oppFound = opp;
            }
        }
        return oppFound;
    }

    public void showAccounts() {
        List<Account> accountList = accountRepository.findAll();
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

    public void showOpportunities() {
        List<Opportunity> opportunityList = opportunityRepository.findAll();
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

//  TODOS LOS SIGUIENTES MÉTODOS
//  DEBEN CAMBIARSE
//  O MORIR EN EL INTENTO

    /*public static List<SalesRep> getSalesRepList() {
        return salesRepRepository.findAll();
    }*/

    public List<Leadd> getLeaddList() {
        return leaddRepository.findAll();
    }

//  Finds a Lead by id
    public Leadd getLeadById(Integer id) {
        List<Leadd> leaddList = leaddRepository.findAll();
        Leadd foundLeadd = null;
        for (Leadd leadd : leaddList) {
            if (leadd.getId() == id) {
                foundLeadd = leadd;
            }
        }
        return foundLeadd;
    }

    //  Finds a Account by id
    public Account getAccountById(Integer id) {
        List<Account> accountList = accountRepository.findAll();
        Account foundAccount = null;
        for (Account account : accountList) {
            if (account.getId() == id) {
                foundAccount = account;
            }
        }
        return foundAccount;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityRepository.findAll();
    }

    public List<Contact> getContactList() {
        return contactRepository.findAll();
    }

    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    public void setLeadList(List<Leadd> leaddList) {
        leaddRepository.saveAll(leaddList);
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
       opportunityRepository.saveAll(opportunityList);
    }

    public void setContactList(List<Contact> contactList) {
        contactRepository.saveAll(contactList);
    }

    public void setAccountList(List<Account> accountList) {
        accountRepository.saveAll(accountList);
    }

    public void addLeadd(Leadd newLeadd) {
        leaddRepository.save(newLeadd);
    }

    public List<SalesRep> getSalesRep(){
        return salesRepRepository.findAll();
    }

}
