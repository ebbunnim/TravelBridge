package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PerPageBean;


public interface HotPlaceService {
	
	public HotPlace search(int hp_no);
	public List<HotPlace> searchAll();
	public void insert(HotPlace HotPlace);
	public void update(HotPlace HotPlace);
	public void delete(int hp_no);
	public int getCountHotPlaceAll();
	public List<Map<String, Object>> searchPageHotPlaceAll(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceAll(MorePageBean pageBean);
	public int getCountHotPlaceByCityName(String keyword);
	public List<Map<String, Object>> searchPageHotPlaceByCityName(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByCityName(MorePageBean pageBean);
	public int getCountHotPlaceByTag(String keyword);
	public List<Map<String, Object>> searchPageHotPlaceByTag(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByTag(MorePageBean pageBean);
	public int getCountHotPlaceByAddress(String keyword);
	public List<Map<String, Object>> searchPageHotPlaceByAddress(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByAddress(MorePageBean pageBean);
}