package com.ironhack.classes;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.styles.ConsoleColors;

import java.util.Arrays;

public class Opportunity {
    private Integer id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(Contact decisionMaker) {
        setId(Helper.setOpportunityId());
        setProduct();
        setQuantity();
        setDecisionMaker(decisionMaker);
        setStatus(Status.OPEN);
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
