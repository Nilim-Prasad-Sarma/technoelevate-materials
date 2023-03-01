package com.tyss.gmailtask.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Compose {
	public static void composeMail(String e, String m) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/gmail?user=root&password=root";

			connection = DriverManager.getConnection(dburl);

			String query = "insert into inbox values(0,(select user_id from account where email=?),?)";

			statement = connection.prepareStatement(query);

			statement.setString(1, e);
			statement.setString(2, m);

			int res = statement.executeUpdate();

			if (res != 0) {
				System.out.println("message sent successfully");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		finally {
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
