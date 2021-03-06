package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Likes;

public interface LikesService {
	public Likes search(int like_no);
	
	public Likes searchPost(int mem_no,int post_no);

	public List<Likes> searchAll();

	public void insert(Likes Likes);

	public void update(Likes Likes);

	public void delete(int like_no);
	
	public void deletePost(int like_no);
}