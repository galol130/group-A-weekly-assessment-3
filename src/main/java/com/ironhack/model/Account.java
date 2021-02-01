package com.ironhack.model;

import com.ironhack.classes.Helper;
import com.ironhack.classes.Input;
import com.ironhack.enums.Industry;
import com.ironhack.model.Contact;
import com.ironhack.model.Opportunity;
import com.ironhack.styles.ConsoleColors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
public class Account {

    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    public Account(List<Contact> contactList, List<Opportunity> opportunityList) {
        setId(Helper.setAccountId());
        setIndustry();
        setEmployeeCount();
        setCity();
        setCountry();
        setContactList(contactList);
        setOpportunityList(opportunityList);
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

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    @Override
    public String toString() {
        return  ConsoleColors.WHITE_BRIGHT + "\tID " + id +
                ConsoleColors.WHITE_BOLD +
                "  |  Industry: " + industry +
                ", EmployeeCount: " + employeeCount +
                ", City: " + city +
                ", Country: " + country +
                ", Number of Contacts: " + contactList.size() +
                ", Number of Opportunities: " + opportunityList.size();
    }
}
