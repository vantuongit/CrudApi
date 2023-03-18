package com.fpt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fpt.entities.UserEntity;

@SpringBootTest
class JavaSpringBootApplicationTests {

	@Test
	public void testGetUserByid() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userEntity = restTemplate.getForObject("http://localhost:8082/userapi/user/2", UserEntity.class);
		assertNotNull(userEntity);
		assertEquals("tuongvv", userEntity.getUserName());
	}
	
	@Test
	public void testCreateUser() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("tuongvv1");
		userEntity.setEmail("abc@gmail.com");
		userEntity.setAddress("abc");
		userEntity.setPhoneNumber(123456789);
		UserEntity newUserEntity = restTemplate.postForObject("http://localhost:8082/userapi/user/", userEntity , UserEntity.class);
		assertNotNull(newUserEntity);
		assertNotNull(newUserEntity.getId());
		assertEquals("tuongvv1", newUserEntity.getUserName());
	}
	
	@Test
	public void testUpdateUser() {
		RestTemplate restTemplate = new RestTemplate();
		UserEntity userEntity = restTemplate.getForObject("http://localhost:8082/userapi/user/2", UserEntity.class);
		userEntity.setEmail("tuongvv@gmail.com");
		restTemplate.put("http://localhost:8082/userapi/user/", userEntity);
	}

}
