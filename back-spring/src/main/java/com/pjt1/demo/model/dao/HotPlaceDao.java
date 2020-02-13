package com.pjt1.demo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.utils.MorePageBean;

@Mapper
public interface HotPlaceDao {
	
	public HotPlace search(int no);
	public List<HotPlace> searchAll();
	public void insert(HotPlace HotPlace);
	public void update(HotPlace HotPlace);
	public void delete(int no);
	
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
	public List<Map<String, Object>> findChildLike(int no);
	public void deleteChildLike(List<Integer> list);
}