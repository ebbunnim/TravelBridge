package com.pjt1.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Blame;

import lombok.SneakyThrows;

@Service
public class BlameServiceImpl implements BlameService {

	@Autowired
	private BlameService repo;

	@SneakyThrows(Exception.class)
	public Blame search(int blame_no) {
		return repo.search(blame_no);
	}

	@SneakyThrows(Exception.class)
	public List<Blame> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(Blame Blame) {
		repo.insert(Blame);
	}

	@SneakyThrows(Exception.class)
	public void update(Blame Blame) {
		repo.update(Blame);
	}

	@SneakyThrows(Exception.class)
	public void delete(int blame_no) {
		repo.delete(blame_no);
	}

}
