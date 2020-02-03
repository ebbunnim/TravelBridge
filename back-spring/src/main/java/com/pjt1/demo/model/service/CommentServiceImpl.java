package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.CommentDao;
import com.pjt1.demo.model.dto.Comment;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao repo;

	public Comment search(int cmt_no) {
		try {
			return repo.search(cmt_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Comment> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(Comment Comment) {
		try {
			repo.insert(Comment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(Comment Comment) {
		try {
			repo.update(Comment);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int cmt_no) {
		try {
			repo.delete(cmt_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
