package com.tyss.gmailapp.service;

import java.util.Scanner;

import com.tyss.gmailapp.dao.IUserInfoDao;
import com.tyss.gmailapp.dao.UserInfoImplJDBCDao;
import com.tyss.gmailapp.userinfo.UserInfo;

public class UserInfoServiceImpl implements IUserInfoService {

	IUserInfoDao userDao = new UserInfoImplJDBCDao();
	Scanner sc = new Scanner(System.in);

	@Override
	public UserInfo compose(String email) {
		// Here we need to enter the email id and message
		return userDao.compose(email);
	}

	@Override
	public UserInfo showInbox(String email) {
		return userDao.showInbox(email);
	}

	@Override
	public UserInfo createAccount() {
		
		System.out.println("Enter the user_name");
		String user_name = ValidationCodes.nameValidation();;
		System.out.println("Enter the email id");
		String email = ValidationCodes.emailValidation();
		System.out.println("Create a password");
		String password = sc.next();
		return userDao.createAccount(user_name, password, email);
	}

	@Override
	public UserInfo validate(String email) {
		System.out.println("Enter the password");
		String password = sc.next();
		return userDao.validate(email, password);
	}
}
