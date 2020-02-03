package com.pjt1.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.model.dto.Faq;

@Mapper
public interface FaqDao {
	public Faq search(int no);
	public List<Faq> searchAll();
	public void insert(Faq Faq);
	public void update(Faq Faq);
	public void delete(int no);
}