package com.cs.service;

import java.util.List;

import com.cs.model.Course;

public interface CourseService {
	
	public List<Course>getAllRecord();
	
	public Course getByCourseId(Integer courseId);
	public Course addNewRecord(Course course);
	public Course updateRecord(Course course);
	public void deleteRecord(Integer courseId);
	

	
}
