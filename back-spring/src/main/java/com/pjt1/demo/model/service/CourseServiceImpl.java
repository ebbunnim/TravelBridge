package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.CourseDao;
import com.pjt1.demo.model.dto.Course;
import com.pjt1.demo.model.dto.Post;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao repo;

	public Course search(int course_no) {
		try {
			return repo.search(course_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Course> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void insert(Course targetCourse) {
		try {
			repo.insert(targetCourse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Course Course) {
		try {
			repo.update(Course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int course_no) {
		try {
			repo.delete(course_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Post searchPostByCourse(String course_spot) {
		try {
			return repo.searchPostByCourse(course_spot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
