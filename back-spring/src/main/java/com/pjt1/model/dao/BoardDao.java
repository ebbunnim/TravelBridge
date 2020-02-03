package com.pjt1.model.dao;

import com.pjt1.model.dto.Board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	public Board search(int no);
	public List<Board> searchAll();
	public void insert(Board Board);
	public void update(Board Board);
	public void delete(int no);
}