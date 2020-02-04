package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.LikesDao;
import com.pjt1.demo.model.dto.Likes;

@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesDao repo;

	@Override
	public Likes search(int like_no) {
		try {
			return repo.search(like_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Likes> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Likes Likes) {
		try {
			repo.insert(Likes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Likes Likes) {
		try {
			repo.update(Likes);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int like_no) {
		try {
			repo.delete(like_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
