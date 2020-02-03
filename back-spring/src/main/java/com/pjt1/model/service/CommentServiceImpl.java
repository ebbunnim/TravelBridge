package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Comment;

import lombok.SneakyThrows;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentService repo;
	@SneakyThrows(Exception.class)
	public Comment search(int cmt_no) {
		return repo.search(cmt_no);
	}

	@SneakyThrows(Exception.class)
	public List<Comment> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(Comment Comment) {
		repo.insert(Comment);
	}

	@SneakyThrows(Exception.class)
	public void update(Comment Comment) {
		repo.update(Comment);
	}

	@SneakyThrows(Exception.class)
	public void delete(int cmt_no) {
		repo.delete(cmt_no);
	}

}
