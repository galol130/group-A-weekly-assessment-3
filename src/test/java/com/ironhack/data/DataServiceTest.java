package com.ironhack.data;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.*;
import com.ironhack.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class DataServiceTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private LeaddRepository leaddRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        SalesRep salesRep1 = new SalesRep("SalesRep1 Testing1");
        SalesRep salesRep2 = new SalesRep("SalesRep2 Testing2");
        salesRepRepository.saveAll(List.of(salesRep1,salesRep2));
        Leadd leadd1 = new Leadd("John Doe","12345678", "correo@email.com","Company1");
        Leadd leadd2 = new Leadd("Mike","98765432", "email@correo.com","Company2");
        Leadd leadd3 = new Leadd("David","66993388", "correo@email.com","Company3");
        leaddRepository.saveAll(List.of(leadd1,leadd2,leadd3));
        Contact contact1 = new Contact("Peter", "phoneNumber1", "email1", "Comp1");
        Contact contact2 = new Contact("Jerry", "phoneNumber2", "email2", "Comp2");
        Contact contact3 = new Contact("Austin", "phoneNumber3", "email3", "Comp3");
        contactRepository.saveAll(List.of(contact1,contact2,contact3));
        Account account1 = new Account(Industry.ECOMMERCE, 10, "City1", "Country1");
        Account account2 = new Account(Industry.MEDICAL, 20, "City2", "Country2");
        Account account3 = new Account(Industry.PRODUCE, 30, "City3", "Country3");
        accountRepository.saveAll(List.of(account1,account2,account3));
        Opportunity opp1 = new Opportunity(Product.BOX, 10, contact1, Status.OPEN, salesRep1, account1);
        Opportunity opp2 = new Opportunity(Product.FLATBED, 20, contact1, Status.OPEN, salesRep2, account1);
        Opportunity opp3 = new Opportunity(Product.HYBRID, 30, contact1, Status.OPEN, salesRep1, account2);
        Opportunity opp4 = new Opportunity(Product.BOX, 40, contact1, Status.OPEN, salesRep2, account3);
        opportunityRepository.saveAll(List.of(opp1,opp2,opp3,opp4));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
        contactRepository.deleteAll();
        leaddRepository.deleteAll();
        salesRepRepository.deleteAll();
    }

    @Test
    void showSalesRep_Ok() {
        List<SalesRep> salesRepList = salesRepRepository.findAll();
        assertTrue(salesRepList.size()>0);
    }

    @Test
    void showLeads() {
    }

    @Test
    void lookUpLead() {
    }

    @Test
    void changeOpportunityStatus() {
    }

    @Test
    void getOpportunityById() {
    }

    @Test
    void showAccounts() {
    }

    @Test
    void showOpportunities() {
    }

    @Test
    void getLeaddList() {
    }

    @Test
    void getLeadById() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void getOpportunityList() {
    }

    @Test
    void getContactList() {
    }

    @Test
    void getAccountList() {
    }

    @Test
    void setLeadList() {
    }

    @Test
    void setOpportunityList() {
    }

    @Test
    void setContactList() {
    }

    @Test
    void setAccountList() {
    }

    @Test
    void addLeadd() {
    }

    @Test
    void getSalesRep() {
    }

    @Test
    void addSalesRep() {
    }

    @Test
    void createContact() {
    }

    @Test
    void createOpportunity() {
    }

    @Test
    void createAccount() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteLead() {
    }
}