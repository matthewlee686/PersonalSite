package com.personalsite.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalsite.entities.Comment;
import com.personalsite.services.CommentService;

@RestController
@CrossOrigin({"*", "http://localhost:4250"})
public class CommentController {
	
	@Autowired
	private CommentService commentSvc;
	
	@GetMapping("/comments")
	public List<Comment> showAll(HttpServletResponse res) {
		
		List<Comment> comments = commentSvc.index();
		
		if(comments == null) {
			res.setStatus(404);
		}
		return comments;
	}

}
