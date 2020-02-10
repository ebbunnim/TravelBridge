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
	//조건별로 필터링 하는건 합쳐도 되는데 클릭으로 들어가는 형태니까. 검색은 필요하면 메인기능 개발시에 하자.
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