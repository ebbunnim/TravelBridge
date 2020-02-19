package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.SubCourseDao;
import com.pjt1.demo.model.dto.SubCourse;

@Service
public class SubCourseServiceImpl implements SubCourseService {

    @Autowired
    private SubCourseDao repo;

    public SubCourse search(int subcourse_no) {
        try {
            return repo.search(subcourse_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<SubCourse> searchAll() {
        try {
            return repo.searchAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void insert(SubCourse SubCourse) {
        try {
            repo.insert(SubCourse);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(SubCourse SubCourse) {
        try {
            repo.update(SubCourse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int subcourse_no) {
        try {
            repo.delete(subcourse_no);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
