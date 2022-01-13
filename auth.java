package com.telusko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import employee.SalaryCalculation;

//import java.sql.*;

public class auth {
	public boolean authentication(int Emp_id,String password) {
		boolean status=false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","MySQL123@#");
			PreparedStatement pstmt=con.prepareStatement("Select * from employee where EmpId=? and Emp_password=?");
			pstmt.setInt(1, Emp_id);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			status=rs.next();
	
			
			

}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return status;
	}

}
