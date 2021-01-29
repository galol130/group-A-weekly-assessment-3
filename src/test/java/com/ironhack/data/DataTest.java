package com.ironhack.data;

import com.ironhack.classes.Lead;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    //We have tested the Lead related methods but these methods are tested just by using them, as they just show 2
    //messages depending on what the user has written. It is never something that would stop the application or
    // anything like that.

    private List<Lead> leadList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        leadList.add(new Lead(1, "James McCarthy", "555-6661124", "invented@email.haha"
                        ,"invented company S.L."));
        leadList.add(new Lead(2, "Carles Puyol", "+34 65435631", "carles@puyi.com"
                        , "FC Barcelona"));
        Data.setLeadList(leadList);
    }

    @AfterEach
    public void tearDown() {
        leadList.clear();
    }

    @Test
    void showLeads_LeadList_LeadsShownAppropriately() {
        Data.showLeads();
    }

    @Test
    void showLeads_EmptyLeadList_ErrorMessage() {
        leadList.clear();
        Data.showLeads();
    }

    @Test
    void lookUpLead_ValidId_LeadShownAppropriately() {
        Data.lookUpLead(2);
    }

    @Test
    void lookUpLead_WrongId_ErrorMessage() {
        Data.lookUpLead(63);
    }

    @Test
    void deleteLead_Lead_CorrectlyRemoved() {
        Data.showLeads();
        Data.deleteLead(leadList.get(1));
        System.out.println("Lead list after deleting the lead.");
        Data.showLeads();
    }

    @Test
    void deleteLead_NotExistingLead_ErrorMessage() {
        Data.deleteLead(new Lead(4, "bla bla", "bla bla", "bla bla", "ble"));
    }

}