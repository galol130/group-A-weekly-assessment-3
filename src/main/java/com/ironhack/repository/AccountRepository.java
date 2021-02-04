package com.ironhack.repository;

import com.ironhack.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT AVG(employeeCount) FROM Account")
    public Integer findAvgEmployeeCount();

    @Query("SELECT MAX(employeeCount) FROM Account")
    public Integer findMaxEmployeeCount();

    @Query("SELECT MIN(employeeCount) FROM Account")
    public Integer findMinEmployeeCount();

}
