package com.fpt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fpt.entities.UserEntity;
import com.fpt.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Optional<UserEntity> getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	
	@Override
	public List<UserEntity> getAllUser(){
		return userRepository.findAll();
		
	}

	@Override
	public UserEntity createUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		UserEntity existUser = userRepository.findById(userEntity.getId()).orElse(null);
		existUser.setUserName(userEntity.getUserName());
		existUser.setEmail(userEntity.getEmail());
		existUser.setAddress(userEntity.getAddress());
		existUser.setPhoneNumber(userEntity.getPhoneNumber());
		return userRepository.save(existUser);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
