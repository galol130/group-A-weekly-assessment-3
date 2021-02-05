package com.ironhack.repository;

import com.ironhack.model.Leadd;
import com.ironhack.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaddRepository extends JpaRepository<Leadd, Integer> {

	@Query("SELECT COUNT(l) FROM Leadd l JOIN SalesRep s ON l.salesRep = s.id GROUP BY s.id")
	public List<Object[]> findBySalesRep();
}
