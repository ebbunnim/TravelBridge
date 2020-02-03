package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.Likes;


public interface LikesService {
	public Likes search(int no);
	public List<Likes> searchAll();
	public void insert(Likes Likes);
	public void update(Likes Likes);
	public void delete(int no);
}