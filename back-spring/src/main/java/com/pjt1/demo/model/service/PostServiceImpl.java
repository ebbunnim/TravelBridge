package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.PostDao;
import com.pjt1.demo.model.dto.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao repo;

	@Override
	public Post search(int post_no) {
		try {
			return repo.search(post_no);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return null;
	}

	@Override
	public List<Post> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return null;
	}

	@Override
	public void insert(Post Post) {
		try {
			repo.insert(Post);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Post Post) {
		try {
			repo.update(Post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int post_no) {
		try {
			repo.delete(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
