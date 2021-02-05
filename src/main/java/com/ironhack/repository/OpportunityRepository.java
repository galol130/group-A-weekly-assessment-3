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


    @Query("SELECT s.name, COUNT(*) FROM Opportunity o JOIN SalesRep s ON o.salesRep = s.id GROUP BY s.id")
    public List<Object[]> findBySalesRep();

    @Query("SELECT o.product, COUNT(*) FROM Opportunity o GROUP BY o.product")
    public List<Object[]> findByProduct();

    @Query("SELECT a.country, COUNT(*) FROM Opportunity o JOIN Account a ON o.account = a.id GROUP BY a.country")
    public List<Object[]> findByCountry();

    @Query("SELECT a.city, COUNT(*) FROM Opportunity o JOIN Account a ON o.account = a.id GROUP BY a.city")
    public List<Object[]> findByCity();

    @Query("SELECT a.industry, COUNT(*) FROM Opportunity o JOIN Account a ON o.account = a.id GROUP BY a.industry")
    public List<Object[]> findByIndustry();

    public List<Opportunity> findByAccountId (Integer id);

    @Query("SELECT s.name, COUNT(o) FROM Opportunity o JOIN SalesRep s ON o.salesRep = s.id WHERE o.status = com.ironhack.enums.Status.OPEN GROUP BY s.id")
    public List<Object[]> findOpenBySalesRep();

    @Query("SELECT o.product, COUNT(o) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.OPEN GROUP BY o.product")
    public List<Object[]> findOpenByProduct();

    @Query("SELECT a.country, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.OPEN GROUP BY a.country")
    public List<Object[]> findOpenByCountry();

    @Query("SELECT a.city, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.OPEN GROUP BY a.city")
    public List<Object[]> findOpenByCity();

    @Query("SELECT a.industry, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.OPEN GROUP BY a.industry")
    public List<Object[]> findOpenByIndustry();

    @Query("SELECT s.name, COUNT(o) FROM Opportunity o JOIN SalesRep s ON o.salesRep = s.id WHERE o.status = com.ironhack.enums.Status.CLOSED_WON GROUP BY s.id")
    public List<Object[]> findClosedWonBySalesRep();

    @Query("SELECT o.product, COUNT(o) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON GROUP BY o.product")
    public List<Object[]> findClosedWonByProduct();

    @Query("SELECT a.country, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.CLOSED_WON GROUP BY a.country")
    public List<Object[]> findClosedWonByCountry();

    @Query("SELECT a.city, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.CLOSED_WON GROUP BY a.city")
    public List<Object[]> findClosedWonByCity();

    @Query("SELECT a.industry, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.CLOSED_WON GROUP BY a.industry")
    public List<Object[]> findClosedWonByIndustry();

    @Query("SELECT s.name, COUNT(o) FROM Opportunity o JOIN SalesRep s ON o.salesRep = s.id WHERE o.status = com.ironhack.enums.Status.CLOSED_LOST GROUP BY s.id")
    public List<Object[]> findClosedLostBySalesRep();

    @Query("SELECT o.product, COUNT(o) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_LOST GROUP BY o.product")
    public List<Object[]> findClosedLostByProduct();

    @Query("SELECT a.country, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.CLOSED_LOST GROUP BY a.country")
    public List<Object[]> findClosedLostByCountry();

    @Query("SELECT a.city, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.CLOSED_LOST GROUP BY a.city")
    public List<Object[]> findClosedLostByCity();

    @Query("SELECT a.industry, COUNT(o) FROM Opportunity o JOIN Account a ON o.account = a.id WHERE o.status = com.ironhack.enums.Status.CLOSED_LOST GROUP BY a.industry")
    public List<Object[]> findClosedLostByIndustry();

    @Query("SELECT AVG(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findAvgProductsOrdered();

    @Query("SELECT MAX(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findMaxProductsOrdered();

    @Query("SELECT MIN(quantity) FROM Opportunity o WHERE o.status = com.ironhack.enums.Status.CLOSED_WON")
    public Integer findMinProductsOrdered();


}
