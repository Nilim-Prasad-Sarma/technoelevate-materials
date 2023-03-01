package com.tyss.gmailtask.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Validate {
	private static final String QUERY = "select count(*) from account where email=? and password=?";

	public static void validate() {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		String email = null, password = null;
		try {
			// read inputs
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter email : ");
				email = sc.nextLine(); // gives scott
				System.out.println("Enter password : ");
				password = sc.nextLine(); // gives tiger
			}
			// register jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			// get connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail", "root", "root");

			// preapere the query
			if (con != null)
				ps = con.prepareStatement(QUERY);
			// set parm values
			if (ps != null) {
				ps.setString(1, email);
				ps.setString(2, password);
			}
			// send and Execute the query
			if (ps != null)
				rs = ps.executeQuery();

			if (rs != null) {
				if (rs.next())
					count = rs.getInt(1);

			}

			if (count == 0)
				System.out.println("Invalid Credentials ! ");
			else
				System.out.println("Valid Crediantials !");
			System.out.println();

			System.out.println("Enter a to compose mail");
			System.out.println("Enter b to show inbox");
			char choice2 = sc.next().charAt(0);
			if (choice2 == 'a') {
				System.out.println("enter the recievers mail id");
				String rid = sc.next();
				System.out.println("enter the message");
				String m1 = sc.next();
				String m2 = sc.nextLine();
				String msg = m1 + m2;

				Compose.composeMail(rid, msg);

			} else if (choice2 == 'b') {
				ShowInbox.inbox(email);
			}

//			compose();
		} // try

		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close all connections
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();

			} catch (SQLException se) {
				se.printStackTrace();

			}
			try {
				if (sc != null)
					sc.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally

	}// main
}
