package com.pjt1.model.service;


import java.util.List;

import com.pjt1.model.dto.Faq;


public interface FaqService {
	public Faq search(int no);
	public List<Faq> searchAll();
	public void insert(Faq Faq);
	public void update(Faq Faq);
	public void delete(int no);
}