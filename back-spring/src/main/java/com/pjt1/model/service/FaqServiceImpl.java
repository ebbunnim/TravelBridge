package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Faq;
@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqService repo;
	@Override
	public Faq search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faq> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Faq Faq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Faq Faq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}
