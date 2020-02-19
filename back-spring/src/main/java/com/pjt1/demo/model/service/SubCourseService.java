package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.SubCourse;

public interface SubCourseService {

    public SubCourse search(int subcourse_no);

    public List<SubCourse> searchAll();

    public void insert(SubCourse SubCourse);

    public void update(SubCourse SubCourse);

    public void delete(int subcourse_no);
}