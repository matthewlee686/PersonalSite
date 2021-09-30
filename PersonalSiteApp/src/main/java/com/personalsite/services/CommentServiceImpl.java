package com.personalsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalsite.entities.Comment;
import com.personalsite.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public List<Comment> index() {
		return commentRepo.findAll();
	}

}
