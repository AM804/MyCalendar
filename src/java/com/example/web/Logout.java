
package com.example.web;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        session.setAttribute("userid", null);
        session.invalidate();
        request.setAttribute("error","yes");
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request,response); 
        out.close(); 
    }  
    
}
