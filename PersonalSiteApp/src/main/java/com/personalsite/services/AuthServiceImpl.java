package com.personalsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personalsite.entities.User;
import com.personalsite.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User register(User user) {
		
		//Find User by Username
//		User user = userRepo.findByUsername(user.getUsername());
				
//		encrypt and set the password for the User.
		user.setPassword(encoder.encode(user.getPassword())); // Take the clear text password from the front end. Encode it. Replace it with encoded version.
		
//		set the enabled field of the object to true.
		user.setActive(true);
		
//		set the role field of the object to "standard".
		user.setRole("standard");
		
//		saveAndFlush the user using the UserRepo.
		userRepo.saveAndFlush(user);
		
//		return the User object.
		return user;
	}

}
