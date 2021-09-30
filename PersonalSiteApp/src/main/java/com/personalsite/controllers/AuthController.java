package com.personalsite.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personalsite.entities.User;
import com.personalsite.services.AuthService;
import com.personalsite.services.UserService;

// We do not use api pathway here! Because those pathways require authentication...

@RestController
@CrossOrigin("http://localhost:4250")
public class AuthController {

	@Autowired
	private AuthService authSrv;
	@Autowired
	private UserService userSvc;
	
	
	//Registers a new user 
	//For this Project, this section will not be available for public use
	@PostMapping("/register")
	public User register(@RequestBody User user, HttpServletResponse res) {

	    if (user == null) {
	        res.setStatus(400);
	    }

	    user = authSrv.register(user);

	    return user;
	}

	//Login Authentication
	@GetMapping("/authenticate")
	public Principal authenticate(HttpServletResponse res, Principal principal) {

	    return principal;
	}

	
}
