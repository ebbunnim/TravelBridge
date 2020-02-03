package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardService repo;
	
	@Override
	public Board search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Board Board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Board Board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
