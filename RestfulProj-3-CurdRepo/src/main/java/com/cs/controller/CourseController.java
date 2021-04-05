package com.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cs.model.Course;
import com.cs.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	private CourseService ser;
	//get all record from the database
	
	@GetMapping("/course")
	public List getAllRecord() {
		List<Course> list=ser.getAllRecord();
		return  list;
	}
	
	//get specific record from the database
	@GetMapping("/course/{courseId}")
	@ExceptionHandler
	@ResponseStatus(reason = "Record Not Found")
	public Course getSpecfic(@PathVariable String courseId) {
     return ser.getByCourseId(Integer.parseInt(courseId));
	}
	
	@RequestMapping(path = "/course" ,method = RequestMethod.POST)
	@ResponseBody
   public Course addNewCourse(@RequestBody Course course) {
	   return ser.addNewRecord(course);
   }
	//update the record
	
	@PutMapping("/course")
	@ResponseStatus(reason = "Record not found ")
	public Course upDateRecord(@RequestBody Course course) {
		return ser.updateRecord(course);
	}
	
	//delete the record from the databse
	@DeleteMapping("/course/{courseId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteRecord(@PathVariable Integer courseId) {
	ser.deleteRecord(courseId);
	}
		
}
