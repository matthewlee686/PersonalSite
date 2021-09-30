package com.personalsite.services;

import java.util.List;

import com.personalsite.entities.Post;
import com.personalsite.entities.User;

public interface PostService {
	List<Post> index(); 
	Post create(Post post, User user);
}
