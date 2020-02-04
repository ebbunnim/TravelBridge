package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Post;

public interface PostService {
	public Post search(int post_no);

	public List<Post> searchAll();

	public void insert(Post Post);

	public void update(Post Post);

	public void delete(int post_no);
}