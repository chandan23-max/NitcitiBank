package com.cs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.CourseDao;
import com.cs.model.Course;
@Service
public class CourceServiceImmpl implements CourseService {

	@Autowired
	private CourseDao dao;
	
	@Override
	public List<Course> getAllRecord() {
		
		System.out.println("Data from the db: "+dao.findAll());
		return dao.findAll();
		
	}
	@Override
	public Course getByCourseId(Integer courseId) {
		return dao.getOne(courseId);
	}

	@Override
	public Course addNewRecord(Course course) {
		dao.save(course);
		return  course;
	}

	@Override
	public Course updateRecord(Course course) {
		dao.save(course);
		return course;
	}

	@Override
	public void deleteRecord(Integer courseId) {
		Course c=dao.getOne(courseId);
		dao.delete(c);
	}

	
	
	
	
}



