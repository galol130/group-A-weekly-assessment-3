package com.ironhack.model;

import javax.persistence.*;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//  Each SalesRep has an X number of Leads which are, supposedly, not assigned to another sales representative.
    @OneToMany(mappedBy = "salesRep")
    private Lead lead;

//  Each SalesRep has an X number of Opportunities.
    @OneToMany(mappedBy = "salesRep")
    private Opportunity opportunity;

    public SalesRep() {
    }

    public SalesRep(Integer id, String name) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }
}
