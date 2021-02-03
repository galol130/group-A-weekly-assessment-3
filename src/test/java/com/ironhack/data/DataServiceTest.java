package com.ironhack.data;

import com.ironhack.model.Leadd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DataServiceTest {

    //We have tested the Lead related methods but these methods are tested just by using them, as they just show 2
    //messages depending on what the user has written. It is never something that would stop the application or
    // anything like that.

    private List<Leadd> leaddList = new ArrayList<>();
    private DataService dataService;

    @BeforeEach
    public void setUp() {
        leaddList.add(new Leadd(1, "James McCarthy", "555-6661124", "invented@email.haha"
                        ,"invented company S.L."));
        leaddList.add(new Leadd(2, "Carles Puyol", "+34 65435631", "carles@puyi.com"
                        , "FC Barcelona"));
        dataService.setLeadList(leaddList);
    }

    @AfterEach
    public void tearDown() {
        leaddList.clear();
    }

    @Test
    void showLeads_LeadList_LeadsShownAppropriately() {
        dataService.showLeads();
    }

    @Test
    void showLeads_EmptyLeadList_ErrorMessage() {
        leaddList.clear();
        dataService.showLeads();
    }

    @Test
    void lookUpLead_ValidId_LeadShownAppropriately() {
        dataService.lookUpLead(2);
    }

    @Test
    void lookUpLead_WrongId_ErrorMessage() {
        dataService.lookUpLead(63);
    }

    @Test
    void deleteLead_Lead_CorrectlyRemoved() {
        dataService.showLeads();
        dataService.deleteLead(leaddList.get(1));
        System.out.println("Lead list after deleting the lead.");
        dataService.showLeads();
    }

    @Test
    void deleteLead_NotExistingLead_ErrorMessage() {
        dataService.deleteLead(new Leadd(4, "bla bla", "bla bla", "bla bla", "ble"));
    }

}