package com.tyss.quiz.dao;

import com.tyss.quiz.dto.Users;

public interface IQuizDao {
	public Users register(int userid,String name,String password);
	public Users login(String name,String password);
}
