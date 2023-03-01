package com.tyss.gmailapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tyss.gmailapp.userinfo.UserInfo;

public class UserInfoImplJDBCDao implements IUserInfoDao {

	public static int count=0;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	Scanner sc=new Scanner(System.in);


	public void getMessage(int user_id) {
		try {
			System.out.println("Enter the message");
			String message=sc.nextLine();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=admin");
			String query = "insert into inbox values(?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, null);
			pstmt.setInt(2, user_id);
			pstmt.setString(3, message);

			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("Message inserted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//soumyajit.sarkar783@gmail.com
	public UserInfo compose(String email) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=admin");
			String query = "select user_id from account where email=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet resultSet1 = pstmt.executeQuery();
			if(resultSet1.next()) {
				getMessage(resultSet1.getInt(1));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public UserInfo showInbox(String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=admin");
			String query = "select * from inbox where user_id=(select user_id from account where email=?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, email);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("Message id " + resultSet.getInt(1));
				System.out.println("User id " + resultSet.getInt(2));
				System.out.println("Message " + resultSet.getString(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserInfo createAccount(String user_name, String password, String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=admin");
			String query = "insert into account values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, null);
			pstmt.setString(2, user_name);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("User data inserted successfully");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserInfo validate(String email, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=admin");
			String query="select user_name from account where email=? and password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				System.out.println("validated successfully");
				count=1;
			}
			else {
				System.out.println("Invalid name or password");
				count=-1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
