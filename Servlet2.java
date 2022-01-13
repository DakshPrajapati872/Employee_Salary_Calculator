package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("This is generic servlet");
        pw.close();
        
    }
    

}
