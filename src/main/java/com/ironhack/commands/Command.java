package com.ironhack.commands;

import com.ironhack.classes.*;
import com.ironhack.data.Data;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.styles.ConsoleColors;

import java.util.Arrays;
import java.util.Scanner;

public class Command {

//	commandCaller method is used to parse the different methods available, it will call the adequate one depending on
//	user input.
	public static void commandCaller(String[] command) {

		switch (command[0]){
			case "new":
				try {
					Lead newLead = new Lead();
					Data.getLeadList().add(newLead);
					System.out.println(ConsoleColors.WHITE_BRIGHT  +
							"--> Lead created successfully with ID: " + newLead.getId() +
							"  (Total Leads available: " + Data.getLeadList().size() + ")");
				}catch (Exception e) {
					System.out.println(ConsoleColors.RED_BOLD + "Couldn't save the Lead. Try again!");
				}
				System.out.println(ConsoleColors.WHITE_BOLD);
				break;
			case "show":
				if(command[1].equals("leads"))
					Data.showLeads();
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
		Lead lead = Data.getLeadById(id);

		if(lead != null) {
			Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
			Data.getContactList().add(contact);
			Opportunity opp = new Opportunity(contact);
			Data.getOpportunityList().add(opp);
			Data.getAccountList().add(new Account(Data.getContactList(), Data.getOpportunityList()));
			System.out.println(ConsoleColors.WHITE_BRIGHT + "--> Lead ID " + lead.getId() + " converted successfully!");
			System.out.println(ConsoleColors.WHITE_BOLD);
			Data.deleteLead(lead);
		}else{
			System.out.println(ConsoleColors.RED_BOLD + "Error fetching the ID! Check the ID. If error persists, contact admin.");
			System.out.println(ConsoleColors.WHITE_BOLD);
		}
	}
}
