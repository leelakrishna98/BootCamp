package com.capg.otms.entity;

import javax.persistence.Entity; 
import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;


@Entity
public class TestBean {

	@Id
	private int id;
	
//	@NotEmpty(message="Title should not be null and It accepts String")
//	@Pattern (regexp=  "[a-z A-Z]*$" )
	private String testTitle;
	
//	@NotEmpty(message="Test Duration should not be null and It accepts String")
//	@Pattern(regexp="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	private String testDuration;
	private double testTotalMarks;
	private double testMarksScored;
	
//	@NotEmpty(message="Start Time should not be null and It accepts String")
//	@Pattern(regexp="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	private String startTime ;
	
//	@NotEmpty(message="End time should not be null and It accepts String")
//	@Pattern(regexp="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	private String endTime ;
	
	
	
	
	public TestBean() {
		super();
	}
	public TestBean(int id, String testTitle, String testDuration, double testTotalMarks, double testMarksScored,
			String startTime, String endTime) {
		super();
		this.id = id;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public String getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(String testDuration) {
		this.testDuration = testDuration;
	}
	public double getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public double getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	

}
