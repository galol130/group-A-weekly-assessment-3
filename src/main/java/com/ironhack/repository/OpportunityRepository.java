package com.ironhack.repository;


import com.ironhack.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    public List<Opportunity> findByAccountId (Integer id);

    @Query("SELECT AVG(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findAvgProductsOrdered();

    @Query("SELECT MAX(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findMaxProductsOrdered();

    @Query("SELECT MIN(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findMinProductsOrdered();


}
