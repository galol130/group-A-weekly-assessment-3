package com.ironhack.commands;

import com.ironhack.classes.Input;
import com.ironhack.data.Data;
import com.ironhack.model.*;
import com.ironhack.repository.*;
import com.ironhack.styles.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Command {
//	Repositories will be used to persist and retrieve data
	@Autowired
	private LeaddRepository leadRepository;

	@Autowired
	private SalesRepRepository salesRepRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private OpportunityRepository opportunityRepository;

	@Autowired
	private AccountRepository accountRepository;

//	commandCaller method is used to parse the different methods available, it will call the adequate one depending on
//	user input.
	public static void commandCaller(String[] command) {

		switch (command[0]){
			case "new":
				if (command[1].equals("lead")) {
					try {
						Leadd newLeadd = new Leadd();
						//leaddRepository.save(newLeadd);
						System.out.println(ConsoleColors.WHITE_BRIGHT  +
								"--> Lead created successfully with ID: " + newLeadd.getId() +
								"  (Total Leads available: " + Data.getLeaddList().size() + ")");
					}catch (Exception e) {
						System.out.println(ConsoleColors.RED_BOLD + "Couldn't save the Lead. Try again!");
					}
				} else if (command[1].equals("salesrep")) {
					try {
						// IMPLEMENTATION OF THE METHOD TO CREATE A NEW SALESREP
						SalesRep newSalesRep = new SalesRep();
					} catch (Exception e) {
						System.out.println(ConsoleColors.RED_BOLD + "Couldn't save the SalesRep. Try again!");
					}
				}
				System.out.println(ConsoleColors.WHITE_BOLD);
				break;
			case "show":
				if(command[1].equals("leads"))
					Data.showLeads();
				else if(command[1].equals("salesrep"))
					Data.showSalesRep();
				else if(command[1].equals("accounts"))
					Data.showAccounts();
				else if(command[1].equals("opps"))
					Data.showOpportunities();
				break;
			case "lookup":
				Data.lookUpLead(Integer.parseInt(command[2]));
				break;
			case "convert":
				convert(Integer.parseInt(command[1]));
				break;
			case "change":
				Data.changeOpportunityStatus(Integer.parseInt(command[2]));
				break;
			case "exit":
				System.out.println(ConsoleColors.YELLOW_BOLD + "Thank you for using E.M.O.F. CRM!");
				System.out.println(ConsoleColors.WHITE_BOLD);
				System.exit(1);
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
	public static void convert(Integer id){
		Leadd leadd = Data.getLeadById(id);

		if(leadd != null) {
			Contact contact = new Contact(leadd.getName(), leadd.getPhoneNumber(), leadd.getEmail(), leadd.getCompanyName());
			Data.getContactList().add(contact);
			Opportunity opp = new Opportunity(contact);
			Data.getOpportunityList().add(opp);
			if (Input.getYesNoUserInput("Would you like to create a new Account?(Y/N)").equals("y"))
				Data.getAccountList().add(new Account(contact, opp));
			else {
				while (true) {
					Scanner scanner = new Scanner(System.in);
					System.out.println("Write an Account id to associate the Contact and Opportunity");
					String input = scanner.nextLine().trim();
					if (Input.validIdFormat(input)) {
						Account account = Data.getAccountById(Integer.parseInt(input));
						if (account != null) {
							account.addContact(contact);
							account.addOpportunity(opp);
							break;
						}
						System.out.println("There is not any account with that id.");
					}
				}
			}
			System.out.println(ConsoleColors.WHITE_BRIGHT + "--> Lead ID " + leadd.getId() + " converted successfully!");
			System.out.println(ConsoleColors.WHITE_BOLD);
			Data.deleteLead(leadd);
		}else{
			System.out.println(ConsoleColors.RED_BOLD + "Error fetching the ID! Check the ID. If error persists, contact admin.");
			System.out.println(ConsoleColors.WHITE_BOLD);
		}
	}
}
