package com.personalsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalsite.entities.Post;
import com.personalsite.entities.User;
import com.personalsite.repositories.PostRepository;
import com.personalsite.repositories.UserRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Post> index() {
		return postRepo.findAll();
	}

	@Override
	public Post create(Post post, User user) {
		post.setUser(user);
		return postRepo.saveAndFlush(post);
	}

}
