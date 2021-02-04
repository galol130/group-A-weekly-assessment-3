package com.ironhack.model;

import com.ironhack.classes.Input;

import javax.persistence.*;
import java.util.List;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//  Each SalesRep has an X number of Leads which are, supposedly, not assigned to another sales representative.
    @OneToMany(mappedBy = "salesRep")
    private List<Leadd> leadds;

//  Each SalesRep has an X number of Opportunities.
    @OneToMany(mappedBy = "salesRep")
    private List<Opportunity> opportunities;


    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

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
        this.name = Input.getStringUserInput("Please, write the sales representative's name:");
    }

}
