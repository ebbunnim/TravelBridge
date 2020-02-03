package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Qna;

@Mapper
public interface QnaDao {
	public Qna search(int no);
	public List<Qna> searchAll();
	public void insert(Qna Qna);
	public void update(Qna Qna);
	public void delete(int no);
}