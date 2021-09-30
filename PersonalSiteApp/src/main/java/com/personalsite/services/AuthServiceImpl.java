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
		User managedUser = userRepo.findByUsername(user.getUsername());
				
//		encrypt and set the password for the User.
		managedUser.setPassword(encoder.encode(managedUser.getPassword())); // Take the clear text password from the front end. Encode it. Replace it with encoded version.
		
//		set the enabled field of the object to true.
		managedUser.setActive(true);
		
//		set the role field of the object to "standard".
		managedUser.setRole("standard");
		
//		saveAndFlush the user using the UserRepo.
		userRepo.saveAndFlush(managedUser);
		
//		return the User object.
		return managedUser;
	}

}
