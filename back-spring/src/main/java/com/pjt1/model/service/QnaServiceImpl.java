package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Qna;
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaService repo;
	
	@Override
	public Qna search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qna> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Qna Qna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Qna Qna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
