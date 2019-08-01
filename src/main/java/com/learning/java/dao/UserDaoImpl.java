package com.learning.java.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.learning.java.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	private Logger logger = Logger.getLogger(UserDaoImpl.class);
		
	@Override
	public void addUser(User user) {
		Session session = HibernateSessionBuilder.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		logger.info("Data saved in database");
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = HibernateSessionBuilder.getSession();
		List<User> usersList = session.createQuery("from User").list();
		return usersList;
	}

	@Override
	public void updateUser(User user) {
		Session session = HibernateSessionBuilder.getSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		logger.info("Data updated in database");
		session.close();
	}

	@Override
	public User getUserById(int id) {
		Session session = HibernateSessionBuilder.getSession();
		User u = (User)session.load(User.class, new Integer(id));
		u.setId(id);
		return u;
	}
}
