package com.tyss.quiz.service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.quiz.dao.IQuizDao;
import com.tyss.quiz.dao.JPAHibernateDao;
import com.tyss.quiz.dto.Users;

public class ServiceClass implements IService {
	Scanner sc = new Scanner(System.in);
	IQuizDao dao = new JPAHibernateDao();

	@Override
	public Users getRegistration() {
		Users u = new Users();
		System.out.println("Enter ur id");
		int id = sc.nextInt();
		System.out.println("Enter ur name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter ur password");
		String pass = sc.nextLine();
		return dao.register(id, name, pass);
	}

	@Override
	public Users getLogin() {
		Users u = new Users();
		System.out.println("Enter your name");
		String name = sc.nextLine();
		System.out.println("enter your password");
		String pass = sc.nextLine();
		return dao.login(name, pass);

	}

}
