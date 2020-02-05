package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Course;


public interface CourseService {
	
	public Course search(int cmt_no);
	public List<Course> searchAll();
	public void insert(Course Course);
	public void update(Course Course);
	public void delete(int cmt_no);
}