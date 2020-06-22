package com.spring.eventsplanner.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.eventsplanner.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Long theId) {
		
		entityManager.joinTransaction();
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("delete from User where id =: uId");
		theQuery.setParameter("uId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public User findById(Long id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("from User where id=:uId", User.class);
		theQuery.setParameter("uId", id);
		User theUser = theQuery.getSingleResult();

		return theUser;
	}

}
