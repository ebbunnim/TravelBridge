package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.Board;


public interface BoardService {
	public Board search(int board_no);
	public List<Board> searchAll();
	public void insert(Board Board);
	public void update(Board Board);
	public void delete(int board_no);
}