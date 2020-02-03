package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Board;


public interface BoardService {
	public Board search(int board_no);
	public List<Board> searchAll();
	public void insert(Board Board);
	public void update(Board Board);
	public void delete(int board_no);
}