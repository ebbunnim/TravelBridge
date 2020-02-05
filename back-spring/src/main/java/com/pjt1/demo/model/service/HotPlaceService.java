package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.HotPlace;


public interface HotPlaceService {
	
	public HotPlace search(int hp_no);
	public List<HotPlace> searchAll();
	public void insert(HotPlace HotPlace);
	public void update(HotPlace HotPlace);
	public void delete(int hp_no);
}