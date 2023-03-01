package com.tyss.gmailtask.main;

import java.util.Scanner;

public class RunApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to login");
		System.out.println("Press 2 to register");

		int choice1 = scanner.nextInt();

		if (choice1 == 1) {
			Validate.validate();

		} else if (choice1 == 2) {
			System.out.println("enter username");
			String username = scanner.next();
			System.out.println("enter your password");
			String pass = scanner.next();
			System.out.println("enter your email_id");
			String ceid = scanner.next();

			CreateAccount.createAcc(username, pass, ceid);
		}
		scanner.close();
	}
}
