package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reportgeneration
 */
@WebServlet("/Reportgeneration")
public class Reportgeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportgeneration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String month1=request.getParameter("month");
		 String []month = month1.split("-");
		//System.out.println(month[1]);
		
		int days = 0;
		float da,earnedSalary;
		Scanner sc=new Scanner(System.in);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","MySQL123@#");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");
			
			switch(month[1]) {
			case "01":
				days=31;
				break;
			case "02":
				days=28;
				break;
			case "03":
				days=31;
				break;
			case "04":
				days=30;
				break;
			case "05":
				days=31;
				break;
				
			case "06":
				days=30;
				break;
			case "07":
				days=31;
				break;
			case "08":
				days=31;
				break;
			case "09":
				days=30;
				break;
			case "10":
				days=31;
				break;
			case "11":
				days=30;
				break;
			case "12":
				days=31;
				break;
			default :
				System.out.println("Wrong Choice Enter Again ....!");
			
				
				
			}
			response.setContentType("text/html;charset=UTF-8");

			    try (PrintWriter out = response.getWriter()) {
			        /* TODO output your page here. You may use following sample code. */
			        out.print("<!DOCTYPE html>");
			        out.print("<html>");
			        out.print("<head>");
			        out.print("<title>Report Generator</title>");  
			        out.print("<style>");
			     out.print("   table, th, td { border: 4px solid black; }");
			        out.print("</style>");
			        out.print("</head>");
			        out.print("<body>");
			        out.print("<body style='background-color:powderblue;'>");
			        out.print("<h2>Genearted Report</h2>");
			       
			        out.print("<table>");
			        
			        out.print("<thread>");
			        out.print("<tr>");
			        out.print("<th>Employee ID </th>");
			        out.print("<th>Employee Name </th>");
			        out.print("<th>Earned Category </th>");
			        out.print("<th>Shifts</th>");
			        out.print("<th>Basic Salary </th>");
			        out.print("<th>Earned Salary </th>");
			        out.print("</tr>");
			        out.print("<thread>");
			        
			       
			
			
			while(rs.next()) {
				int salary=rs.getInt(6);
				if(rs.getString(4).equals("staff")) {
					salary=salary/30;
					salary=days*salary;
					da=(20*salary)/100;
					earnedSalary=salary+da;
				}
				else if(rs.getString(4).equals("engineer")) {
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
				
				
				
			
				out.print("<tbody>");
		        out.print("<tr>");
		        out.print("<td>"+rs.getInt(1)+"</td>");
		        out.print("<td>"+rs.getString(2)+"</td>");
		        out.print("<td>"+rs.getString(4)+"</td>");
		        out.print("<td>"+rs.getString(5)+"</td>");
		        out.print("<td>"+rs.getInt(6)+"</td>");
		        out.print("<td>"+earnedSalary+"</td>");
		        out.print("</tr>");
		        out.print("</tbody>");
				
			
			}
			
			 out.print("</table>");
			 out.print("</body>");
		        out.print("</html>");
			con.close();
		}
			   
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	}


