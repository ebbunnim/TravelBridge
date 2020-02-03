package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.Comment;


public interface CommentService {
	
	public Comment search(int cmt_no);
	public List<Comment> searchAll();
	public void insert(Comment Comment);
	public void update(Comment Comment);
	public void delete(int cmt_no);
}