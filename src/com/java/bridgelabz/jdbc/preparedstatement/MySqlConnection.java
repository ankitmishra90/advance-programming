package com.java.bridgelabz.jdbc.preparedstatement;
import java.sql.*;
public class MySqlConnection {
	private static final String url="jdbc:mysql://localhost:3306/dbEmp";
	private static final String user="root";
	private static final String password="admin";
	public static Connection getConnection() {
		Connection connection=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection=DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
