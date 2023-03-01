package com.tyss.quiz.main;

import java.util.Scanner;
import com.tyss.quiz.service.IService;
import com.tyss.quiz.service.ServiceClass;

public class MainClass {

	public static void main(String[] args) {
		while(true) {
		System.out.println("Enter your choice==>");
		System.out.println("Press 1 for Login procedure");
		System.out.println("Press 2 for Registration if you are not a memeber");
		System.out.println("Press 3 to exit");
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		switch (n) {
		case 1:
			IService service= new ServiceClass();
			service.getLogin();
			break;
		case 2:
			IService serv= new ServiceClass();
			serv.getRegistration();
			break;
			
		case 3:
			System.exit(0);
			break;
			
		default:
			
			break;
		}
	}

}
}
