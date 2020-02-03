package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.FaqDao;
import com.pjt1.demo.model.dto.Faq;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqDao repo;
	public Faq search(int faq_no) {
		try {
			return repo.search(faq_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Faq> searchAll() {
		try {
			System.out.println("??");
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Faq Faq) {
		try {
			repo.insert(Faq);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	public void update(Faq Faq) {
		try {
			repo.update(Faq);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void delete(int faq_no) {
		try {
			repo.delete(faq_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}