package com.cs;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cs.dao.CourseDao;
import com.cs.model.Course;
import com.cs.service.CourceServiceImmpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RestfulProj3CurdRepoApplicationTests {

	@Autowired
	private CourceServiceImmpl service;

	@MockBean
	private CourseDao dao;

	@Test
	public void getUserTest() {
		when(dao.findAll()).thenReturn(Stream.of(new Course(121, "Employee Management", "Manage the Employee", 1233.0),

				new Course(124, "RestApi", "Any Application", 6783.0)).collect(Collectors.toList()));
		assertEquals(2, service.getAllRecord().size());
	}

	@Test
	public void getUserById() {
	Course c= new Course(121, "Employee Management", "Manage the Employee", 1233.0);
	when(dao.getOne(c.getCourseId())).thenReturn(c);
	assertEquals(c, service.getByCourseId(c.getCourseId()));
	
	
	}

	@Test
	public void addUser() {
		Course course = new Course(121, "Employee Management", "Good", 332.0);
		when(dao.save(course)).thenReturn(course);
		assertEquals(course, service.addNewRecord(course));

	}

	@Test
	public void deleteCourse() {
		Course course = new Course(121, "Employee Management", "Manage the Employee", 1233.0);
		service.deleteRecord(course.getCourseId());
        verify(dao).getOne(course.getCourseId());
	

	}

}
