package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import com.pjt1.demo.model.dto.Festival;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PerPageBean;

public interface FestivalService {
	public Festival search(int fval_no);
	public List<Festival> searchAll();
	public void insert(Festival Festival);
	public void update(Festival Festival);
	public void delete(int fval_no);
	
	public int getCountFestivalAll();
	public List<Map<String, Object>> searchPageFestivalAll(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalAll(MorePageBean pageBean);
	public int getCountFestivalByCityName(String keyword);
	public List<Map<String, Object>> searchPageFestivalByCityName(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalByCityName(MorePageBean pageBean);
	public int getCountFestivalByTag(String keyword);
	public List<Map<String, Object>> searchPageFestivalByTag(PerPageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalByTag(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalByTheme(MorePageBean pageBean);
}
