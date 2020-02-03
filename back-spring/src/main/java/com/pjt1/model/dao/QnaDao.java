package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.Qna;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaDao {
	public Qna search(int no);
	public List<Qna> searchAll();
	public void insert(Qna Qna);
	public void update(Qna Qna);
	public void delete(int no);
}