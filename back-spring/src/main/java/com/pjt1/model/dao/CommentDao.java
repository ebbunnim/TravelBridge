package com.pjt1.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.model.dto.Comment;

@Mapper
public interface CommentDao {
	
	public Comment search(int no);
	public List<Comment> searchAll();
	public void insert(Comment Comment);
	public void update(Comment Comment);
	public void delete(int no);
}