package com.pjt1.demo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Festival;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PageMaker;

@Mapper
public interface FestivalDao {
	public Festival search(int fval_no);

	public List<Festival> searchAll();

	public void insert(Festival Festival);

	public void update(Festival Festival);

	public void delete(int fval_no);
	

	public int getCountFestivalAll();
	public int getCountFestivalByCityName(String keyword);
	public int getCountFestivalByTag(String keyword);
	public List<Map<String, Object>> searchMoreFestivalAll(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalByCityName(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalByTag(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreFestivalByTheme(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreFestival(MorePageBean pageBean);
	public List<Festival> searchPageFestivalAll(PageMaker pageBean);
	public List<Festival> searchPageFestivalByCityName(PageMaker pageBean);
	public List<Festival> searchPageFestivalByTag(PageMaker pageBean);
	public List<Festival> searchPageFestivalByTheme(PageMaker pageBean);
	public List<Festival> searchPageFestival(PageMaker pageBean);
	public List<Map<String, Object>> findChildLike(int no);
	public void deleteChildLike(List<Integer> list);
}
