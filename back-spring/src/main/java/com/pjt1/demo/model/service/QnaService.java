package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Qna;

public interface QnaService {
	public Qna search(int qna_no);

	public List<Qna> searchAll();

	public void insert(Qna Qna);

	public void update(Qna Qna);

	public void delete(int qna_no);
	
	public List<Qna> searchForMember(int mem_no);
	
	public void answerTheQuestion(Qna Qna);
}