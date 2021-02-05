package com.ironhack.model;

import com.ironhack.classes.Input;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.styles.ConsoleColors;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;
    @OneToOne
    private Contact decisionMaker;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private SalesRep salesRep;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Opportunity() {
    }

    public Opportunity(Contact decisionMaker, SalesRep salesRep, Account account) {
        setProduct();
        setQuantity();
        setDecisionMaker(decisionMaker);
        setStatus(Status.OPEN);
        setSalesRep(salesRep);
        setAccount(account);
    }

    // Constructor for testing purposes only
    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, SalesRep salesRep, Account account) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRep = salesRep;
        this.account = account;
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct() {
        String[] myEnums = Arrays.stream(Product.values()).map(Enum::name).toArray(String[]::new);
        String option  = Input.getEnumUserInput("Please, write the product:", myEnums);
        this.product = Product.valueOf(option);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        this.quantity = Input.getNumberUserInput("Please, write the quantity:");
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return  ConsoleColors.WHITE_BRIGHT + "\tID: " + id +
                ConsoleColors.WHITE_BOLD +
                ", Product: " + product.name() +
                ", Quantity: " + quantity +
                ", Decision Maker: " + decisionMaker.getName() +  ", from company: " + decisionMaker.getCompanyName() +
                " - Phone: " + decisionMaker.getPhoneNumber() + " - Email: " + decisionMaker.getEmail() + " || " +
                ConsoleColors.WHITE_BRIGHT + "STATUS: " + status.name() + ConsoleColors.WHITE_BOLD;
    }
}
