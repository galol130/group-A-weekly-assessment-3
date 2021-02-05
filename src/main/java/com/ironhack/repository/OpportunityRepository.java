package com.ironhack.repository;


import com.ironhack.enums.Industry;
import com.ironhack.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

    @Query("SELECT COUNT(*) FROM Opportunity o JOIN SalesRep s ON o.salesRep = s.id GROUP BY s.id")
    public Integer findBySalesRep();

    @Query("SELECT COUNT(*) FROM Opportunity o GROUP BY o.product")
    public Integer findByProduct();

    @Query("SELECT COUNT(*) FROM Opportunity o JOIN Account a ON o.account = a.id GROUP BY a.country")
    public Integer findByCountry();

    @Query("SELECT COUNT(*) FROM Opportunity o JOIN Account a ON o.account = a.id GROUP BY a.city")
    public Integer findByCity();

    @Query("SELECT COUNT(*) FROM Opportunity o JOIN Account a ON o.account = a.id GROUP BY a.industry")
    public Integer findByIndustry();

    public List<Opportunity> findByAccountId (Integer id);

    @Query("SELECT AVG(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findAvgProductsOrdered();

    @Query("SELECT MAX(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findMaxProductsOrdered();

    @Query("SELECT MIN(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findMinProductsOrdered();


}
