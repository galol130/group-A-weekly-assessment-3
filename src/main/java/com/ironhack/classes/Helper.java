package com.ironhack.classes;

public class Helper {
    private static Integer leadId = 0;
    private static Integer opportunityId = 0;
    private static Integer contactId = 0;
    private static Integer accountId = 0;

    public static Integer setLeadId() {
        return ++leadId;
    }

    public static Integer setOpportunityId() {
        return ++opportunityId;
    }

    public static Integer setContactId() {
        return ++contactId;
    }

    public static Integer setAccountId() {
        return ++accountId;
    }

    public static Integer getLeadId() {
        return leadId;
    }

    public static Integer getOpportunityId() {
        return opportunityId;
    }

    public static Integer getContactId() {
        return contactId;
    }

    public static Integer getAccountId() {
        return accountId;
    }
}
