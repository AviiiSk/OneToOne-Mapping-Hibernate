package com.mapping.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMap {

	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		// creating question 
		
		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("What is JAVA ?");
		
		// creating Answer
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("JAVA is programming language");
		q1.setAnswer(answer1);
		
		

		
		// creating question 
		
		Question q2 = new Question();
		q2.setQuestionId(102);
		q2.setQuestion("What is Collection Framework ?");
		
		// creating Answer
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(343);
		answer2.setAnswer("API to work with JAVA.");
		q2.setAnswer(answer2);
		
	
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		
		s.save(q1);
		s.save(q2);
		s.save(answer1);
		s.save(answer2);
		
		
		tx.commit();
		s.close();
		factory.close();
		
		
		
	}

}
