package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Course;

@Mapper
public interface CourseDao {

    public Course search(int no);

    public List<Course> searchAll();

    public void insert(Course Course);

    public void update(Course Course);

    public void delete(int no);
}