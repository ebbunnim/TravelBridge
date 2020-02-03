package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.Festival;

public interface FestivalDao {
	public Festival search(int no);
	public List<Festival> searchAll();
	public void insert(Festival Festival);
	public void update(Festival Festival);
	public void delete(int no);
}
