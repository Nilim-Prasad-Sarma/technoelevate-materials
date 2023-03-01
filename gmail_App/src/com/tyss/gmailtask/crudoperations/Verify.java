package com.tyss.gmailtask.crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Verify {
	public static void verifyid(String e, String p) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/gmail?user=root&password=root";

			connection = DriverManager.getConnection(dburl);

			String query = "select email from account where email=? and password=?";

			statement = connection.prepareStatement(query);
			statement.setString(1, e);
			statement.setString(2, p);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString("email") == e) {
					System.out.println("email id is valid");
				} else {
					System.out.println("invalid email id");
				}
			}

		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}

		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
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
