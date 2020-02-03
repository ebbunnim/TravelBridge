package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Comment;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentService repo;
	@Override
	public Comment search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Comment Comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Comment Comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
