/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Giorgos
 */
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String error;    
    String x;
    Boolean y;
    String z="done";
    String n=request.getParameter("mail");  
    String p=request.getParameter("pass");  
    List shared = new ArrayList();
        try {
            if(LoginDao.validate(n, p)){
                
                HttpSession session = request.getSession();
                session.setAttribute("username",n.split("\\@")[0]);
                x=(String)session.getAttribute("username");
                shared=LoginDao.MakeList(x);
                y=LoginDao.CheckShare(x);
                if(y) {
                    session.setAttribute("shared",z);
                }
                session.setAttribute("List",shared);
                
                response.sendRedirect("Calendar.jsp");
                
                
                
                
            }
            else{
                error="Sorry username or password error";
                request.setAttribute("error",error);
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);  
            }   } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    out.close();  
    }  
}  
