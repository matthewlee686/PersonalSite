package com.personalsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalsite.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username); 
}
