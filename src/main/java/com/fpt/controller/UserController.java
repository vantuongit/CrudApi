package com.fpt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fpt.entities.UserEntity;
import com.fpt.services.UserServiceImpl;

@RestController
public class UserController {
	
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/user/{id}")
	public Optional<UserEntity> getUserById(@PathVariable("id") int id) {
		return userServiceImpl.getUserById(id);
	}
	
	@GetMapping("/user/")
	public List<UserEntity> getAllUser(){
		return userServiceImpl.getAllUser();
	}
	
	@PostMapping("/user/")
	public UserEntity createUser(@RequestBody @Validated UserEntity userEntity) {
		return userServiceImpl.createUser(userEntity);
	}
	
	@PutMapping("/user/")
	public UserEntity updateUser(@RequestBody @Validated UserEntity userEntity) {
		return userServiceImpl.updateUser(userEntity);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		 userServiceImpl.deleteUser(id);
	}	
}
