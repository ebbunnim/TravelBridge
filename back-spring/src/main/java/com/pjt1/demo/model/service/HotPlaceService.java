package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PageMaker;


public interface HotPlaceService {
	
	public HotPlace search(int hp_no);
	public List<HotPlace> searchAll();
	public void insert(HotPlace HotPlace);
	public void update(HotPlace HotPlace);
	public void delete(int hp_no);
	public int getCountHotPlaceAll();
	public int getCountHotPlaceByCityName(String keyword);
	public int getCountHotPlaceByTag(String keyword);
	public int getCountHotPlaceByAddress(String keyword);
	public List<Map<String, Object>> searchMoreHotPlaceAll(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByCityName(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByTag(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByAddress(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByTheme(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlace(MorePageBean pageBean);
	public List<HotPlace> searchPageHotPlaceAll(PageMaker page);
	public List<HotPlace> searchPageHotPlaceByCityName(PageMaker page);
	public List<HotPlace> searchPageHotPlaceByTag(PageMaker page);
	public List<HotPlace> searchPageHotPlaceByAddress(PageMaker page);
	public List<HotPlace> searchPageHotPlaceByTheme(PageMaker page);
	public List<HotPlace> searchPageHotPlace(PageMaker page);
	public List<Map<String, Object>> findChildLike(int no);
	public void deleteChildLike(List<Integer> list);
}