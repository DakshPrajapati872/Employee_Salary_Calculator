package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 implements Servlet {
	ServletConfig config;
    @Override
    
public void init(ServletConfig config) throws ServletException {
    this.config=config;
    System.out.println("creating servlet");
}

@Override
public ServletConfig getServletConfig() {
    return config;
}

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    //System.out.println("servicing");
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();
    pw.println("hello Servlet Interface bye");
    pw.close();
}

@Override
public String getServletInfo() {
    return "hi";
}

@Override
public void destroy() {
    System.out.println("destrying");
}

}

