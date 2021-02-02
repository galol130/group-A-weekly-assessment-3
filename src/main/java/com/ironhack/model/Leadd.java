package com.ironhack.model;

import com.ironhack.classes.Helper;
import com.ironhack.classes.Input;
import javax.persistence.*;

@Entity
public class Leadd {
    @Id
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    private SalesRep salesRep;


    public Leadd() {
        setId(Helper.setLeadId());
        setName();
        setPhoneNumber();
        setEmail();
        setCompanyName();
    }

    //This constructor is only created for the sake of the tests. Has no use in the project besides that.
    public Leadd(Integer id, String name, String phoneNumber, String email, String companyName) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    //  Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = Input.getStringUserInput("Please, write the name:");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        this.phoneNumber = Input.getStringUserInput("Please, write the phone number:");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = Input.getStringUserInput("Please, write the email:");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName() {
        this.companyName = Input.getStringUserInput("Please, write the company name:");
    }

    @Override
    public String toString() {
        return "\tID: " + id +
                " --- Name: " + name +
                " --- Phone Number: " + phoneNumber +
                " --- Email: " + email +
                " --- Company Name: " + companyName;
    }
}
