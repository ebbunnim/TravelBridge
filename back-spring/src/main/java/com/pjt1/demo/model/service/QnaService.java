package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Qna;


public interface QnaService {
	public Qna search(int no);
	public List<Qna> searchAll();
	public void insert(Qna Qna);
	public void update(Qna Qna);
	public void delete(int no);
}