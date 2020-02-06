package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Course;
import com.pjt1.demo.model.dto.Post;

@Mapper
public interface CourseDao {

	public Course search(int no);

	public List<Course> searchAll();

	public void update(Course course);

	public void delete(int no);

	public void insert(Course targetCourse);

	public Post searchPostByCourse(String course_spot);

}
