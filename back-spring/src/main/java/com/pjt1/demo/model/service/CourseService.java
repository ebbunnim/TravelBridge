package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Course;
import com.pjt1.demo.model.dto.Post;

public interface CourseService {

	public Course search(int cmt_no);

	public List<Course> searchAll();

	public void update(Course Course);

	public void delete(int cmt_no);

	public void insert(Course targetCourse);

	public Post searchPostByCourse(String course_spot);

	// public Post searchPostByCourse(List<String> courseList);
}