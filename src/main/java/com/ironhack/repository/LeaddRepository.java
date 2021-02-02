package com.ironhack.repository;

import com.ironhack.model.Leadd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaddRepository extends JpaRepository<Leadd, Integer> {
}
