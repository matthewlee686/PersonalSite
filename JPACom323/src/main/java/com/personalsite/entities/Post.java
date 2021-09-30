package com.personalsite.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@CreationTimestamp
	@Column(name="post_date")
	private LocalDateTime postDate; 
	
	@Column(name="post_content")
	private String postContent;
	
	@OneToMany(mappedBy="post")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user; 
	
	//no-arg constructor
	public Post() {}

	
	//methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}


	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}


	public String getPostContent() {
		return postContent;
	}


	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", postDate=" + postDate + ", postContent=" + postContent
				+ ", comments=" + comments + ", user=" + user + "]";
	}

}
