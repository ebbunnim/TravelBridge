package com.pjt1.demo.model.dao;

import java.util.List;

import com.pjt1.demo.model.dto.Festival;

public interface FestivalDao {
	public Festival search(int fval_no);
	public List<Festival> searchAll();
	public void insert(Festival Festival);
	public void update(Festival Festival);
	public void delete(int fval_no);
}
