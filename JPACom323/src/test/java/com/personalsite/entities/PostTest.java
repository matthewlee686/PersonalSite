package com.personalsite.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.personalsite.entities.Post;

class PostTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Post post; 

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
		post = em.find(Post.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		post = null; 
	}
	
	@Test
	@DisplayName("test Post entity: title field")
	void test() {
		assertNotNull(post);
		assertEquals("Test Post", post.getTitle());
	}
	
	@Test
	@DisplayName("test Post entity: post content field")
	void test2() {
		assertNotNull(post);
		assertEquals("This is some post content to test against to see if it shows up in the DB", post.getPostContent());
	}
	
	@Test
	@DisplayName("test Post to Comment mapping")
	void test3() {
		assertNotNull(post.getComments().size());
		assertTrue(post.getComments().size() > 0);
		assertEquals(1, post.getComments().size());
	}
	
	@Test
	@DisplayName("test Post to User mapping")
	void test4() {
		assertNotNull(post.getUser());
		assertEquals("matt", post.getUser().getUsername());
	}
}
