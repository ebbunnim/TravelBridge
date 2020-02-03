package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

import com.pjt1.model.dto.Faq;
@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqService repo;

	@SneakyThrows(Exception.class)
	public Faq search(int faq_no) {
		return repo.search(faq_no);

	}

	@SneakyThrows(Exception.class)
	public List<Faq> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(Faq Faq) {
		repo.insert(Faq);

	}

	@SneakyThrows(Exception.class)
	public void update(Faq Faq) {
		repo.update(Faq);
	}

	@SneakyThrows(Exception.class)
	public void delete(int faq_no) {
		repo.delete(faq_no);

	}

}
