package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.BoardDao;
import com.pjt1.demo.model.dto.Board;

 
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao repo;
	
	public Board search(int board_no) {
		try {
			return repo.search(board_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Board> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(Board Board) {
		try {
			repo.insert(Board);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(Board Board) {
		try {
			repo.update(Board);
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	public void delete(int board_no) {
		try {
			repo.delete(board_no);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

}
