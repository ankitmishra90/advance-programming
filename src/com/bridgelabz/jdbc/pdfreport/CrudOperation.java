package com.bridgelabz.jdbc.pdfreport;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.bridgelabz.jdbc.preparedstatement.MySqlConnection;

public class CrudOperation {
	static Scanner sc = new Scanner(System.in);

	public void insert() {
		int status = 0;
		Connection con = null;
		con = MySqlConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");

			do {
				System.out.println("Enter The empno");
				int eno = sc.nextInt();
				ps.setInt(1, eno);
				System.out.println("Enter The empname");
				String ename = sc.next();
				ps.setString(2, ename);
				System.out.println("Enter The eid");
				int eid = sc.nextInt();
				ps.setInt(3, eid);
				status = ps.executeUpdate();
				System.out.println("data inserted:" + "\n" + "Enter yes to continue & no to exit");
				String s = sc.next();
				if (s.startsWith("n")) {
					break;
				}

			} while (true);
			con.close();

		} catch (SQLException e) {
			
		}
	}

//select

	public void select() {
		int status = 0;
		Connection con = null;
		con = MySqlConnection.getConnection();

		List<Emp> list = new LinkedList<Emp>();
		Emp em = null;

		try {
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int eno = rs.getInt("eno");
				String ename = rs.getString("ename");
				int eid = rs.getInt("eid");
				System.out.println(eno + "  " + ename + "  " + eid);
				em = new Emp();
				em.setEid(eid);
				em.setEno(eno);
				em.setName(ename);
				list.add(em);

			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}
           pdfSave(list);
		
	}

	public void update() {
		int status = 0;
		Connection con = null;
		con = MySqlConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update emp set ename=? where eid=?");
			System.out.println("Enter The eno");
			int eno = sc.nextInt();
			ps.setInt(1, eno);
			System.out.println("Enter the Name");
			String ename = sc.next();
			ps.setString(2, ename);
			System.out.println("Enter The eid");
			int eid = sc.nextInt();
			ps.setInt(3, eid);
			status = ps.executeUpdate();
			if (status > 0) {
				System.out.println(status + "row effected");
			} else {
				System.out.println("not updated");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
	}

	public void delete() {
		int status = 0;
		Connection con = null;
		con = MySqlConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from emp where eno=?");
			System.out.println("Enter the number");
			int eno = sc.nextInt();
			ps.setInt(1, eno);
			status = ps.executeUpdate();
			System.out.println("Data is deleted successfully:");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
	}

public void pdfSave(List<Emp> list) {
	
	Document report = new Document();
	try {
	PdfWriter.getInstance(report,
	new FileOutputStream("EmpDetails.pdf"));
	
	report.open();
	
	PdfPTable my_report_table = new PdfPTable(3);
	
	for (Emp e : list) {
		System.out.println("PDf");
     System.out.println(e.getEid()+" "+e.getEno()+" "+e.getName());
	my_report_table.addCell(new PdfPCell(new Phrase(Integer.toString(e.getEid()))));
	my_report_table.addCell(new PdfPCell(new Phrase(Integer.toString(e.getEno()))));
	my_report_table.addCell(new PdfPCell(new Phrase((e.getName()))));
	
	}
	report.add(my_report_table);
	report.close();
	System.out.println("Created PDF");
	
}catch (Exception e) {
	// TODO: handle exception
}

}
}
