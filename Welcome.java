package com.telusko;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out=response.getWriter();
		
		doprocess(request,response);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doprocess(request,response);
	
		
	}
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//doGet(request, response);
		int n=Integer.parseInt(request.getParameter("uid"));
		String p=request.getParameter("upass");
		
		
		//out.println("Hello");
		//User_Authentication obj=new User_Authentication();
		auth obj = new auth();
		
		
		if(obj.authentication(n,p)) {
			
			 HttpSession session = request.getSession();
			 session.setAttribute("id", n);
			response.sendRedirect("index1.html");
			 			
		}
		else {
			 
		       
		       response.setContentType("text/html;charset=UTF-8");

			    try (PrintWriter out = response.getWriter()) {
			        /* TODO output your page here. You may use following sample code. */
			        out.print("<!DOCTYPE html>");
			        out.print("<html>");
			        out.print("<head>");
			        out.print("<title>Employee Salary</title>");  
			        
			        out.print("</head>");
			        out.print("<body>");
			        out.print("<body style='background-color:powderblue;'>");
			        out.println("<h2> Login Failed </h2>  ");
			        out.println("<h2> Your Employee_ID or Password is incorrect</h2>");
			        out.print("</body>");
			        out.print("</html>");
		}
			    catch(Exception e) {
			    	System.out.println(e);
			    }
		
		
		
		
		
	}
	}
}
