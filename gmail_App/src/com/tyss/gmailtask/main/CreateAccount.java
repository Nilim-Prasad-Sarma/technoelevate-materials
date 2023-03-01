package com.tyss.gmailtask.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
	public static void createAcc(String un, String p, String e) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/gmail?user=root&password=root";

			connection = DriverManager.getConnection(dburl);

			String query = "insert into account values(0,?,?,?)";

			statement = connection.prepareStatement(query);
			statement.setString(1, un);
			statement.setString(2, p);
			statement.setString(3, e);

			int res = statement.executeUpdate();

			if (res != 0) {
				System.out.println("account created successfully");
			}

		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
