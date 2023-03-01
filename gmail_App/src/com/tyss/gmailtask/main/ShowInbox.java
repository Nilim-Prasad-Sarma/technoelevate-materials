package com.tyss.gmailtask.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowInbox {
	public static void inbox(String e) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/gmail?user=root&password=root";

			connection = DriverManager.getConnection(dburl);

			String query = "select message from inbox where user_id = (select user_id from account where email=?)";

			statement = connection.prepareStatement(query);
			statement.setString(1, e);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println("-----------------INBOX-------------");
				System.out.println(resultSet.getString("message"));
				System.out.println();
			}
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} finally {
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
