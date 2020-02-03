package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostService repo;
	
	@Override
	public Post search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Post Post) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Post Post) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
