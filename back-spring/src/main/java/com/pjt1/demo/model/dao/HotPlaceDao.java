package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.HotPlace;

@Mapper
public interface HotPlaceDao {
	
	public HotPlace search(int no);
	public List<HotPlace> searchAll();
	public void insert(HotPlace HotPlace);
	public void update(HotPlace HotPlace);
	public void delete(int no);
}