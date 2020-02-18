package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Party;


@Mapper
public interface PartyDao {
	public Party search(int party_no);

	public List<Party> searchAll();

	public void insert(Party party);

	public void update(Party party);

	public void delete(int party_no);
}