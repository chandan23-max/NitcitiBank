package com.cs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonDeserialize
public class Course  implements Serializable{
	@Id
	private Integer courseId;
	@Column(length = 55)
	private  String courseName;
	@Column(length = 55)
	private String description;
	private Double courseFee;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}
	public Course(Integer courseId, String courseName, String description, Double courseFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseFee = courseFee;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", courseFee=" + courseFee + "]";
	}

}
