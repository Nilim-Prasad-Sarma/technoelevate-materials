package com.tyss.quiz.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.tyss.quiz.dto.Users;


public class JPAHibernateDao implements IQuizDao {
	static EntityManagerFactory entfact = null;
	static EntityManager entman = null;
	static EntityTransaction enttrans = null;
	

	@Override
	public Users register(int userid, String name, String password) {
		entfact = Persistence.createEntityManagerFactory("mapping");
		entman = entfact.createEntityManager();
		enttrans = entman.getTransaction();
		enttrans.begin();
		Users us = new Users();
		us.setUserId(userid);
		us.setUsername(name);
		us.setPassword(password);
		entman.persist(us);
		System.out.println("Data Inserted");
		enttrans.commit();
		return null;
	}

	@Override
	public Users login(String name, String password) {
		entfact = Persistence.createEntityManagerFactory("mapping");
		entman = entfact.createEntityManager();
		enttrans = entman.getTransaction();
		enttrans.begin();
		String data="from Users where username=:username and password=:password";
		Query query=entman.createQuery(data);
		query.setParameter("username",name);
		query.setParameter("password", password);
		//to get multiple records we need to use query.getResultList()
		//and to get the single record we need to use query.getSingleRecord();
		Users user=(Users) query.getSingleResult();
		if(user!=null) {
			System.out.println("Login Successfully");
		}
		else {
			System.out.println("Incorrect Password");
		}
		enttrans.commit();
		return null;
	}

}


