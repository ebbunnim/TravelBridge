package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Comment;

@Mapper
public interface CommentDao {
	
	public Comment search(int no);
	public List<Comment> searchAll();
	public void insertPostCmt(Comment Comment);
	public void insertPartyCmt(Comment Comment);
	public void update(Comment Comment);
	public void delete(int no);
}