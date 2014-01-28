package com.frontier.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDAO {

	public Long saveCourse(Course course) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;

		try {
			transaction = session.beginTransaction();
			courseId = (Long) session.save(course);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}
	
	
	public List<Course> getCourses() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Course> courseList = new ArrayList<Course>();

		try {
			transaction = session.beginTransaction();
			courseList = session.createQuery("from Course").list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseList;
		
	}

}
