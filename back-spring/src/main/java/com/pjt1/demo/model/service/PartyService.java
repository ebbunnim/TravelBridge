package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Board;
import com.pjt1.demo.model.dto.Party;


public interface PartyService {
	public Party search(int party_no);

	public List<Party> searchAll();

	public void insert(Party party);

	public void update(Party party);

	public void delete(int party_no);
}