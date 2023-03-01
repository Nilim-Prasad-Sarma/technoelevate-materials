package com.tyss.gmailapp.main;

import java.util.Scanner;

import com.tyss.gmailapp.dao.UserInfoImplJDBCDao;
import com.tyss.gmailapp.service.IUserInfoService;
import com.tyss.gmailapp.service.UserInfoServiceImpl;
import com.tyss.gmailapp.service.ValidationCodes;

public class MainClass {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter the number");
			System.out.println("Press 1 to login");
			System.out.println("Press 2 to register");
			System.out.println("Press any number other than 1&2 for exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				IUserInfoService userInfoServiceImpl1 = new UserInfoServiceImpl();
				System.out.println("Enter the email id");
				String email=ValidationCodes.emailValidation();
				userInfoServiceImpl1.validate(email);
				if(UserInfoImplJDBCDao.count>0) {
					System.out.println("Press A for the compose");
					System.out.println("Press B for the register");
					String key = sc.next();
					switch (key) {
					case "A": {
						IUserInfoService userInfoServiceImpl2 = new UserInfoServiceImpl();
						userInfoServiceImpl2.compose(email);
						break;
					}
					case "B": {
						IUserInfoService userInfoServiceImpl3 = new UserInfoServiceImpl();
						userInfoServiceImpl3.showInbox(email);
						break;
					}
					default: {
						System.out.println("not possible");
						break;
					}
					}
				}
				else {
					System.out.println("Wrong and Not Possible");
				}
				break;
			}
			case 2: {
				IUserInfoService userInfoService = new UserInfoServiceImpl();
				userInfoService.createAccount();
				break;
			}
			default: {
				System.out.println("Bye");
				System.exit(0);
			}
			}
			System.out.println("--------------");
		}
	}
}
