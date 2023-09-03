package com.hiber.onetoonebaeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		//Creating question
		
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");
		

		Question q2=new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection framework?");
		
		Answer answer1=new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("Java is a programming lnaguage");
		q1.setAnswer(answer1);
		answer1.setQuestion(q1);
		Answer answer2=new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("API to work with group of objects");
		q2.setAnswer(answer2);
		answer2.setQuestion(q2);
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		// Save
		session.save(q1);
		session.save(q2);
		session.save(answer1);
		session.save(answer2);
//		Question question = session.get(Question.class, 242);
//		System.out.println(question);
		transaction.commit();
		
		
		session.close();
		
		
	}
}
