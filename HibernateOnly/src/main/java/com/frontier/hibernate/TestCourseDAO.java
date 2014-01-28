package com.frontier.hibernate;

import java.util.List;

public class TestCourseDAO {
	
	public static void main (String [] args) {
		CourseDAO courseDAO =  new CourseDAO();
		
		
		// 1 - save a course to database
		System.out.println("Saving Math Course");
		
		Course course = new Course();
		course.setCreditHours(3);
		course.setTitle("Math");
		course.setDescription("Problem Solving");
		
		long id  = courseDAO.saveCourse(course);
		
		System.out.println("Saved Math course and the ID is " +id);
		
		
		// 2 - get all listed courses 
		
		List<Course> courseList = courseDAO.getCourses();
		for (Course currentCourse : courseList) {
			System.out.println("Course ID " +currentCourse.getId());
			System.out.println("Course Title " +currentCourse.getTitle());
			System.out.println("Course Description " +currentCourse.getDescription());
			System.out.println("Course Credits " +currentCourse.getCreditHours());
			System.out.println("-------------------------------------------------");
		}
	}

}
