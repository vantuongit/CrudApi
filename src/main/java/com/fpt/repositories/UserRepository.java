package com.fpt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}