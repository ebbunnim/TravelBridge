package com.pjt1.demo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PerPageBean;

@Mapper
public interface HotPlaceDao {
	
	public HotPlace search(int no);
	public List<HotPlace> searchAll();
	public void insert(HotPlace HotPlace);
	public void update(HotPlace HotPlace);
	public void delete(int no);
	
	public int getCountHotPlaceAll();
	public List<Map<String, Object>> searchPageHotPlaceAll(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceAll(MorePageBean pageBean);
	public int getCountHotPlaceByCityName();
	public List<Map<String, Object>> searchPageHotPlaceByCityName(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByCityName(PerPageBean pageBean);
	public int getCountHotPlaceByTag();
	public List<Map<String, Object>> searchPageHotPlaceByTag(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByTag(PerPageBean pageBean);
	public int getCountHotPlaceByAddress();
	public List<Map<String, Object>> searchPageHotPlaceByAddress(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreHotPlaceByAddress(PerPageBean pageBean);
}