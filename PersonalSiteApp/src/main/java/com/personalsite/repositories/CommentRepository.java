package com.personalsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalsite.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
