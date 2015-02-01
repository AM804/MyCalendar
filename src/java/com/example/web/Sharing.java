
package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giorgos
 */
public class Sharing extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
        
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String error;    
      
    HttpSession session = request.getSession();
    session.setAttribute("view_share",null);
    response.sendRedirect("Calendar.jsp");
        
        
    
    }
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String error;    
    String n=request.getParameter("us");  
    HttpSession session = request.getSession();
    session.setAttribute("view_share",n);
    response.sendRedirect("Calendar.jsp");
    System.out.println(n);
    
    }
}
