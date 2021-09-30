package com.personalsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalsite.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
//	List<Post> findAllByUser(); 
}
