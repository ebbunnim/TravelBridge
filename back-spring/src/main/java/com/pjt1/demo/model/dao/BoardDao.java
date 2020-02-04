package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Board;

@Mapper
public interface BoardDao {
	public Board search(int board_no);

	public List<Board> searchAll();

	public void insert(Board Board);

	public void update(Board Board);

	public void delete(int board_no);
}