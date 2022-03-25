package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired 
	UserRepository repository;
	
	@Test
	public void saveTest() {
		User u = new User();
		u.setName("Teste");
		u.setPassword("1234");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		assertNotNull(response);
	}
}
