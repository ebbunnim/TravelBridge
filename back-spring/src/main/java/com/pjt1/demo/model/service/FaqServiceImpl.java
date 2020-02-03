package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.Faq;

import lombok.SneakyThrows;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqService repo;
	
	@Override 
	@SneakyThrows(Exception.class)
	public Faq search(int faq_no) {
		return repo.search(faq_no);
	}

	@Override
//	@SneakyThrows(Exception.class)
	public List<Faq> searchAll() {
		try {
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz");
		List<Faq> faqList = repo.searchAll();
		System.out.println("########");
		System.out.println(faqList);
		return faqList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@SneakyThrows(Exception.class)
	public void insert(Faq Faq) {
		repo.insert(Faq);
	}
	
	@Override
	@SneakyThrows(Exception.class)
	public void update(Faq Faq) {
		repo.update(Faq);
	}
	
	@Override
	@SneakyThrows(Exception.class)
	public void delete(int faq_no) {
		repo.delete(faq_no);
	}

}
