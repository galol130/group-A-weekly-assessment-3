package com.ironhack.repository;

import com.ironhack.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT AVG(employeeCount) FROM Account")
    public Double findAvgEmployeeCount();

    @Query("SELECT MAX(employeeCount) FROM Account")
    public Integer findMaxEmployeeCount();

    @Query("SELECT MIN(employeeCount) FROM Account")
    public Integer findMinEmployeeCount();

    @Query(value = "SELECT AVG(oppos) FROM (SELECT COUNT(*) oppos FROM account a JOIN opportunity o ON o.account_id = a.id) AS tbl"
            , nativeQuery = true)
    public Double findAvgNumberOfOpportunities();

    @Query(value = "SELECT MAX(oppos) FROM (SELECT COUNT(*) oppos FROM account a JOIN opportunity o ON o.account_id = a.id) AS tbl"
            , nativeQuery = true)
    public Integer findMaxNumberOfOpportunities();

    @Query(value = "SELECT MIN(oppos) FROM (SELECT COUNT(*) oppos FROM account a JOIN opportunity o ON o.account_id = a.id) AS tbl"
            , nativeQuery = true)
    public Integer findMinNumberOfOpportunities();

}
