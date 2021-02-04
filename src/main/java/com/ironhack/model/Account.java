package com.ironhack.model;

import com.ironhack.classes.Input;
import com.ironhack.enums.Industry;
import com.ironhack.styles.ConsoleColors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Contact> contactList;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Opportunity> opportunityList;

    public Account() {
    }

    public Account(Contact contact, Opportunity opportunity) {
        setIndustry();
        setEmployeeCount();
        setCity();
        setCountry();
        setContactList(contact);
        setOpportunityList(opportunity);
    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }

    public void addOpportunity(Opportunity opportunity) {
        this.opportunityList.add(opportunity);
    }

//  Getters and setters
    public Integer getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIndustry() {
        String[] myEnums = Arrays.stream(Industry.values()).map(Enum::name).toArray(String[]::new);
        String option = Input.getEnumUserInput("Please, write the industry:", myEnums);
        this.industry = Industry.valueOf(option);
    }

    public void setEmployeeCount() {
        this.employeeCount = Input.getNumberUserInput("Please, write the number of employees:");
    }

    public void setCity() {
        this.city = Input.getStringUserInput("Please, write the city of the Company:");
    }

    public void setCountry() {
        this.country = Input.getStringUserInput("Please, write the country of the Company:");
    }

    public void setContactList(Contact contact) {
        this.contactList = new ArrayList<>();
        this.contactList.add(contact);
    }

    public void setOpportunityList(Opportunity opportunity) {
        this.opportunityList = new ArrayList<>();
        this.opportunityList.add(opportunity);
    }

    @Override
    public String toString() {
        return  ConsoleColors.WHITE_BRIGHT + "\tID " + id +
                ConsoleColors.WHITE_BOLD +
                "  |  Industry: " + industry +
                ", EmployeeCount: " + employeeCount +
                ", City: " + city +
                ", Country: " + country;
//                ", Number of Contacts: " + this.getContactList().size();
//                ", Number of Opportunities: " + this.getOpportunityList().size();
    }
}
