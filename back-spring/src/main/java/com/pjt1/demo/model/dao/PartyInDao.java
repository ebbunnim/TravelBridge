package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.PartyIn;


@Mapper
public interface PartyInDao {
	public PartyIn search(int partyin_no);

	public List<PartyIn> searchAll();

	public void insert(PartyIn partyin);

	public void update(PartyIn partyin);

	public void delete(int partyin_no);
	
	public List<PartyIn> searchPartyList(int partyin_no);
}