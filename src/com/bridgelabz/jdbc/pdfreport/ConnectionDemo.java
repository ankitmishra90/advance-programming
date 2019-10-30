package com.bridgelabz.jdbc.pdfreport;
import java.sql.*;


public class ConnectionDemo {

private static final String url="jdbc:mysql://localhost:3306/dbEmp";
private static final String user="root";
private static final String password="admin";
public static  Connection getConnection() {
Connection con=null;

try {
	DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
	con=DriverManager.getConnection(url, user, password);
}
	catch(SQLException e){
		e.printStackTrace();
}
return con;
}


}
