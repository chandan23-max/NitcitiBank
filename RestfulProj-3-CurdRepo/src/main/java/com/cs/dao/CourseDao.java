package com.cs.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.model.Course;

@Repository
@Transactional
public interface CourseDao extends JpaRepository<Course, Integer> {

}
