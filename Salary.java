package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Salary
 */
@WebServlet("/Salary")
public class Salary extends HttpServlet {
	private static final long serialVersionUID = 1L;
      // int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//PrintWriter out=response.getWriter();
		int days=Integer.parseInt(request.getParameter("days"));
		//int id=Integer.parseInt(request.getParameter("id"));
		//out.print(id);
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("id");
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","MySQL123@#");
		PreparedStatement pstmt=con.prepareStatement("Select * from employee where EmpId=?");
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		
		int basicsalary=rs.getInt(6);
		String emp_category=rs.getString(4);
		float earnedSalary,salary;
		float da;
		

			salary=basicsalary;
			
			if(emp_category.equals("staff")) {
				salary=salary/30;
				salary=days*salary;
				da=(20*salary)/100;
				earnedSalary=salary+da;
			}
			else if(emp_category.equals("engineer")) {
				salary=salary/30;
				salary=days*salary;
				da=(15*salary)/100;
				earnedSalary=salary+da;
			}
			else
			{
				salary=salary/30;
				salary=days*salary;
				da=(10*salary)/100;
				earnedSalary=salary+da;
			}
			 response.setContentType("text/html;charset=UTF-8");

			    try (PrintWriter out = response.getWriter()) {
			        /* TODO output your page here. You may use following sample code. */
			        out.print("<!DOCTYPE html>");
			        out.print("<html>");
			        out.print("<head>");
			        out.print("<title>Employee Salary</title>");  
			        out.print("<style>");
			     out.print("   table, th, td { border: 4px solid black; }");
			        out.print("</style>");
			      
			        out.print("</head>");
			        out.print("<body>");
			        out.print("<body style='background-color:powderblue;'>");
			        out.print("<h2>Salary After Calculation</h2>");
			        out.print("<br>");
			        out.print("<table>");
			        
			        out.print("<thead>");
			        out.print("<tr>");
			        out.print("<th>Employee ID </th>");
			        out.print("<th>Employee Name </th>");
			        out.print("<th>Earned Category </th>");
			        out.print("<th>Shifts</th>");
			        out.print("<th>Basic Salary </th>");
			        out.print("<th>Earned Salary </th>");
			        out.print("</tr>");
			        out.print("</thead>");
			        out.print("<tbody>");
			        out.print("<tr>");
			        out.print("<td>"+id+"</td>");
			        out.print("<td>"+rs.getString(2)+"</td>");
			        out.print("<td>"+rs.getString(4)+"</td>");
			        out.print("<td>"+rs.getString(5)+"</td>");
			        out.print("<td>"+rs.getInt(6)+"</td>");
			        out.print("<td>"+earnedSalary+"</td>");
			        out.print("</tr>");
			        
			        out.print("</tbody>");
			        out.print("</table>");
			        
			       /* out.print("<h3> Employee ID = </h3>"+"<p>"+id+"</p>");
			        out.print("<h3> Earned Name = </h3>"+"<h2>"+rs.getString(2)+"</h2>");
			        out.print("<h3> Earned Category = </h3>"+"<h2>"+rs.getString(4)+"</h2>");
			        out.print("<h3> Shifts = </h3>"+"<h2>"+rs.getString(5)+"</h2>");
			        out.print("<h3> Basic Salary = </h3>"+"<h2>"+rs.getInt(6)+"</h2>");
			        out.print("<h3> Earned Salary = </h3>"+"<h2>"+earnedSalary+"</h2>");*/
			       
                    out.print("<br>");
                   
			        out.print("</body>");
			        out.print("</html>");
			    }
			
			//out.println(earnedSalary);
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
			
		
		
	}

	private int goBack() {
		// TODO Auto-generated method stub
		return 0;
	}



}
