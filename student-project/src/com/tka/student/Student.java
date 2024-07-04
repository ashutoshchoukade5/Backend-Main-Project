package com.tka.student;

public class Student {
	
	private String name ;
	private double marks ;
	private int rollNum ;
	
	public Student() {
		
	}
	
	public Student(String name , double marks , int rollNum) {
		this.name = name ;
		this.marks = marks ;
		this.rollNum = rollNum ;
	}
	
	public String getName() {
		return this.name ;
	}
	
	public void setName(String name) {
		this.name = name ;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	
}
