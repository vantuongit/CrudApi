package com.fpt.services;

import java.util.List;
import java.util.Optional;

import com.fpt.entities.UserEntity;

public interface UserService {

		public Optional<UserEntity> getUserById(int id);
		public List<UserEntity> getAllUser();
		public UserEntity createUser(UserEntity userEntity);
		public UserEntity updateUser(UserEntity userEntity);
		public void deleteUser(int id);
		
		
}
