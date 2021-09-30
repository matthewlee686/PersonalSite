package com.personalsite.services;

import java.util.List;

import com.personalsite.entities.User;

public interface UserService {
	List<User> index(); 
	User findByUsername(String username);
}
