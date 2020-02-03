package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Festival;

@Service
public class FestivalServiceImpl implements FestivalService {
	
	@Autowired
	private FestivalService repo;
	
	@Override
	public Festival search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Festival> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Festival Festival) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Festival Festival) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
