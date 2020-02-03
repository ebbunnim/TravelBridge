package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import com.pjt1.model.dto.Festival;


@Service
public class FestivalServiceImpl implements FestivalService {
	
	@Autowired
	private FestivalService repo;
	
	@SneakyThrows(Exception.class)
	public Festival search(int fval_no) {
		return repo.search(fval_no);
	}

	@SneakyThrows(Exception.class)
	public List<Festival> searchAll() {
		return repo.searchAll();

	}

	@SneakyThrows(Exception.class)
	public void insert(Festival Festival) {
		repo.insert(Festival);

	}

	@SneakyThrows(Exception.class)
	public void update(Festival Festival) {
		repo.update(Festival);

	}

	@SneakyThrows(Exception.class)
	public void delete(int fval_no) {
		repo.delete(fval_no);
	}
}
