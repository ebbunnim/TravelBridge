package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Blame;

@Mapper
public interface BlameDao {
	public Blame search(int blame_no);

	public List<Blame> searchAll();

	public void insert(Blame Blame);

	public void update(Blame Blame);

	public void delete(int blame_no);
}