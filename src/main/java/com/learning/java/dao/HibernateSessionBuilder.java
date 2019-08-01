package com.learning.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionBuilder {

	private static HibernateSessionBuilder instance = new HibernateSessionBuilder();
	private SessionFactory sessionFactory;
	
	public static HibernateSessionBuilder getInstance() {
		return instance;
	}
	
	private HibernateSessionBuilder() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		sessionFactory = configuration.buildSessionFactory();
	}
	
	
	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();
		return session;
	}
}
