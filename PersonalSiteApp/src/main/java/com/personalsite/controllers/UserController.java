package com.personalsite.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalsite.entities.User;
import com.personalsite.services.UserService;

@RestController
@CrossOrigin({"*", "http://localhost:4250"})
public class UserController {
	
	@Autowired 
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> showAllUsers(HttpServletResponse res) {
		return userSvc.index();
	}
	
	@GetMapping("api/users")
	public User getLoggedInUser(HttpServletResponse res, Principal principal) {
		
		User user = userSvc.findByUsername(principal.getName());
		
		return user;
	}

}
