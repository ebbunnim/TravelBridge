package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Blame;

@Service
public class BlameServiceImpl implements BlameService {

	@Autowired
	private BlameService repo;
	@Override
	public Blame search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blame> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Blame Blame) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Blame Blame) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
