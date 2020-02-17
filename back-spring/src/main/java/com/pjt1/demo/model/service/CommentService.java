package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Comment;


public interface CommentService {
	
	public Comment search(int cmt_no);
	public List<Comment> searchAll();
	public void insertPostCmt(Comment Comment);
	public void insertPartyCmt(Comment Comment);
	public void update(Comment Comment);
	public void delete(int cmt_no);
}