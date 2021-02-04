package com.ironhack.model;

import com.ironhack.classes.Input;
import com.ironhack.styles.ConsoleColors;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Entity
public class Leadd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Leadd() {
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
        this.email = Input.getEmailUserInput("Please, write the email:");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName() {
        this.companyName = Input.getStringUserInput("Please, write the company name:");
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }


    public void setSalesRep(List<SalesRep> salesRepList) {
        boolean check = false;
        while (!check) {
            for (SalesRep rep : salesRepList) {
                System.out.println(ConsoleColors.YELLOW_BOLD + "\tSales rep: ID- " + rep.getId() + " | Name: " + rep.getName());
            }
            Integer salesRepId = Input.getNumberUserInput("Please, write the sales representative id:");
            for (SalesRep rep : salesRepList) {
                if (rep.getId().equals(salesRepId)) {
                    this.salesRep = rep;
                    check = true;
                }
            }
            if (!check) {
                System.out.println(ConsoleColors.RED_BOLD
                        + "The id typed does not belong to any sales representative. Try again!");
                System.out.println(ConsoleColors.WHITE_BOLD);
            }
        }
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
