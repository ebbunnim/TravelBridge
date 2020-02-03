package com.pjt1.demo.model.service;


import java.util.List;

import com.pjt1.demo.model.dto.Faq;


public interface FaqService {
	public Faq search(int faq_no);
	public List<Faq> searchAll();
	public void insert(Faq Faq);
	public void update(Faq Faq);
	public void delete(int faq_no);
}