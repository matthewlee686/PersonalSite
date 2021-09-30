package com.personalsite.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personalsite.entities.Post;
import com.personalsite.entities.User;
import com.personalsite.services.PostService;
import com.personalsite.services.UserService;

@RestController
@CrossOrigin({"*", "http://localhost:4250"})
public class PostController {
	
	@Autowired 
	private PostService postSvc;
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("/posts")
	public List<Post> showAll(HttpServletResponse res) {
//		User user = userSvc.findByUsername(principal.getName());
		List<Post> posts = postSvc.index();
		
		if(posts == null) {
			res.setStatus(404);
		}
		
		return posts;
	}
	
	//For admin use only
	//There will only be one user in this App
	@PostMapping("/api/posts")
	public Post create(HttpServletResponse res, @RequestBody Post post, Principal principal) {
		User user = userSvc.findByUsername(principal.getName());
		return postSvc.create(post, user);
	}

}
