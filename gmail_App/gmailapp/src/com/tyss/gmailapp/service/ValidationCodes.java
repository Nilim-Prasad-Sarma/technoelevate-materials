package com.tyss.gmailapp.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCodes {
	static Scanner sc = new Scanner(System.in);

	public static String emailValidation() {
		boolean counter;
		String email_id;
		String email;
		do {
			String regx ="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
			email_id= sc.nextLine();
			Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email_id);
			if (matcher.find()) {
				email=email_id;
				counter = true;
				return email;
			} else {
				System.err.println("Enter a valid Email id");
				counter = false;
				return emailValidation();
			}
		} while (!counter);
	}

	public static String nameValidation() {
		boolean counter;
		String user_name;
		String name;
		do {
			String regx = "^[a-zA-Z\\s]+$";
			name = sc.nextLine();
			Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(name);
			if (matcher.find()) {
				user_name= name;
				counter = true;
				return user_name;
			} else {
				System.err.println("Enter a valid User name");
				counter = false;
				return nameValidation();
			}
		} while (!counter);
	}
}
