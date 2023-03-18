package com.fpt;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fpt.entities.UserEntity;
import com.fpt.repositories.UserRepository;




@WebMvcTest
class UserRestControllerMvcTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void testFindAll() throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setUserName("Tuongvv");
		userEntity.setEmail("abc@gmail.com");
		userEntity.setAddress("abc");
		userEntity.setPhoneNumber(123456789);
		List<UserEntity> userEntitys = Arrays.asList(userEntity);
		when(userRepository.findAll()).thenReturn(userEntitys);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(get("/userapi/user/").contextPath("/userapi")).andExpect(status().isOk())
		  .andExpect((ResultMatcher) content().json(objectWriter.writeValueAsString(userEntitys)));
	}
	
	
	private UserEntity buildUser() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setUserName("tuongvv10");
		userEntity.setEmail("tuongvv10@gmail.com");
		userEntity.setAddress("abcde");
		userEntity.setPhoneNumber(123456789);
		return userEntity;
	}
	
	@Test
	public void testCreateUser() throws JsonProcessingException, Exception {
		UserEntity userEntity = buildUser();
		when(userRepository.save(any())).thenReturn(userEntity);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(post("/userapi/user/").contextPath("/userapi").contentType(MediaType.APPLICATION_JSON)
					.content(objectWriter.writeValueAsString(userEntity))).andExpect(status().isOk()).andExpect(null);
	}
	

}
