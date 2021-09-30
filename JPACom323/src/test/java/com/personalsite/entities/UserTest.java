package com.personalsite.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPACom323");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null; 
	}
	
	@Test
	@DisplayName("test User entity: username field")
	void test() {
		assertNotNull(user);
		assertEquals("matt", user.getUsername());
	}
	
	@Test
	@DisplayName("test User to Post mapping")
	void test2() {
		assertNotNull(user.getPosts());
		assertTrue(user.getPosts().size() > 0);
		assertEquals(3, user.getPosts().size());
	}
	
//	@Test
//	@DisplayName("test User entity: password field") 
//	void test3() {
//		assertNotNull(user);
//		assertEquals("YouWillNeverGuessIt1990*", user.getPassword());
//	}
//	

}
