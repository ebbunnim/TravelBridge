package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.SubCourse;

@Mapper
public interface SubCourseDao {

    public SubCourse search(int no);

    public List<SubCourse> searchAll();

    public void insert(SubCourse SubCourse);

    public void update(SubCourse SubCourse);

    public void delete(int no);
}