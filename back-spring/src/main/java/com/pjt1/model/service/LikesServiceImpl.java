package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Likes;

@Service
public class LikesServiceImpl implements LikesService {

	@Autowired 
	private LikesService repo;
	
	@Override
	public Likes search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Likes> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Likes Likes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Likes Likes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
