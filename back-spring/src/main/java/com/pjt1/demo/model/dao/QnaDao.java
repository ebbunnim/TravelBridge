package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Qna;

@Mapper
public interface QnaDao {
	public Qna search(int qna_no);

	public List<Qna> searchAll();

	public void insert(Qna Qna);

	public void update(Qna Qna);

	public void delete(int qna_no);
	
	public List<Qna> searchForMember(int mem_no);
	
	public void answerTheQuestion(Qna Qna);
}