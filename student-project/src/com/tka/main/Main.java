package com.tka.main;

import com.tka.makestudent.MakeStudent;
import com.tka.student.Student;

public class Main {

	public static void main(String[] args) {
		
		MakeStudent mm = new MakeStudent();
		
		Student obj = mm.createStudentObject();
		
		String name = obj.getName();
		double marks = obj.getMarks();
		int rollNum = obj.getRollNum();
		
		System.out.println(name);
		System.out.println(marks);
		System.out.println(rollNum);

	}

}
