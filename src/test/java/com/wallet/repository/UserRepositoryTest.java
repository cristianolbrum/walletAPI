package com.wallet.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired 
	UserRepository repository;
	public static final String EMAIL = "email@teste.com";
	@Before
	public void setUp() {
		User u = new User();
		u.setName("Set Up User");
		u.setPassword("Senha1234");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	
	
	@Test
	public void saveTest() {
		User u = new User();
		u.setName("Teste");
		u.setPassword("1234");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		assertNotNull(response);
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
