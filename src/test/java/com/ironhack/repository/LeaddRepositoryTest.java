package com.ironhack.repository;

import com.ironhack.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeaddRepositoryTest {

	@Autowired
	private LeaddRepository leaddRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private OpportunityRepository opportunityRepository;

	@Autowired
	private SalesRepRepository salesRepRepository;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
	}

	@Test
	void findBySalesRep() {
		//Integer result = leaddRepository.findBySalesRep();

	}
}
