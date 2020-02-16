package com.ahmad.utility.dto;

import java.io.Serializable;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer courseNo;
	
	private String courseName;
	
	private Double price;
	
	private Integer seats;
	
	private Integer duration;
	
	
	public Course() {
	}
	public Course(Integer courseNo, String courseName, Double price, Integer seats, Integer duration) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.price = price;
		this.seats = seats;
		this.duration = duration;
	}

	public Integer getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(Integer courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", price=" + price + ", seats=" + seats
				+ ", duration=" + duration + "]";
	}
	
	
}
