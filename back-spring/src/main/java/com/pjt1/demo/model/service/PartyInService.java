package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.PartyIn;


public interface PartyInService {
	public PartyIn search(int partyin_no);

	public List<PartyIn> searchAll();

	public void insert(PartyIn partyin);

	public void update(PartyIn partyin);

	public void delete(int partyin_no);
	
	public List<PartyIn> searchPartyList(int partyin_no);
}