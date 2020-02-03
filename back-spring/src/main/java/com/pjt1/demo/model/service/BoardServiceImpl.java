package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.Board;

import lombok.SneakyThrows;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardService repo;
	
	@SneakyThrows(Exception.class)
	public Board search(int board_no) {
		return repo.search(board_no);
	}

	@SneakyThrows(Exception.class)
	public List<Board> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(Board Board) {
		repo.insert(Board);
	}

	@SneakyThrows(Exception.class)
	public void update(Board Board) {
		repo.update(Board);
	}

	@SneakyThrows(Exception.class)
	public void delete(int board_no) {
		repo.delete(board_no);
	}

}
