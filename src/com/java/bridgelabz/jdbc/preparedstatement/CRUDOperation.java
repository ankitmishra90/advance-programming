package com.java.bridgelabz.jdbc.preparedstatement;
import java.util.*;
import java.sql.*;
public class CRUDOperation {
	static Scanner scanner=new Scanner(System.in);

	//create
	
	
	public void create() {
		/*int status =0;
		Connection con=null;
		con=MySqlConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("create table emp"+("eno int"+"ename varchar(20)"+"eid int"));
			ResultSet rs=ps.executeQuery(); 
			System.out.println("table is created:");
			con.close();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}*/
	}
	
	//insert
	
	public void insert() {
		int status=0;
		Connection con=null;
		con=MySqlConnection.getConnection();
		try {
			PreparedStatement statement=con.prepareStatement("insert into emp values(?,?,?)");

			do {

				System.out.println("Enter employee number");
				int eno=scanner.nextInt();
				statement.setInt(1,eno);
				System.out.println("Enter employee name");
				String ename=scanner.next(); 
				statement.setString(2,ename); 
				System.out.println("Enter employee id");
				int eid=scanner.nextInt();
				statement.setInt(3,eid);  
				status=statement.executeUpdate(); 
				System.out.println("data inserted:"+"\n"+"Enter yes to continue & no to exit");
				String s=scanner.next();
				if(s.startsWith("n")) {
					break;
				}

			}
			while(true);
			con.close();  

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//select

	public void select() {
		Connection con=null;
		con=MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement=con.prepareStatement("select * from emp");
			ResultSet rs=statement.executeQuery();  
            while(rs.next()){  
              int eno=rs.getInt("eno");
              String ename=rs.getString("ename");
              int eid=rs.getInt("eid");
              System.out.println(eno+"  "+ename+"  "+eid);
            }
            con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//update

	public void update() {
		Connection con=null;
		con=MySqlConnection.getConnection();
		int status=0;
		try {
			PreparedStatement statement=con.prepareStatement("update emp set ename=? where eno=?");
			System.out.println("Enter the name");
			String ename=scanner.next();
			statement.setString(1,ename);
			System.out.println("Enter eno");
			int eid=scanner.nextInt();
			statement.setInt(2, eid);
			status=statement.executeUpdate();
			if(status>0) {
				System.out.println(status+"row affected");
			}
			else {
				System.out.println("not updated");
			}
			
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//delete

	public void delete() {
		Connection con=null;
		con=MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement=con.prepareStatement("delete from emp where eno=?");
			
			System.out.println("enter eno");
			int eno=scanner.nextInt();
			statement.setInt(1,eno);
			statement.executeUpdate();
			System.out.println("data deleted successfully:");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
