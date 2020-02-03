package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.Post;


public interface PostService {
	public Post search(int no);
	public List<Post> searchAll();
	public void insert(Post Post);
	public void update(Post Post);
	public void delete(int no);
}