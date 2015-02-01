/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Giorgos_2
 */
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
        int x;
        String success;
        PrintWriter out = response.getWriter();
        String n1=request.getParameter("mail");  
        String n2=request.getParameter("pass");
        String n3=request.getParameter("name");
        String n4=request.getParameter("last_name");
        try{
        x=LoginDao.register(n1, n2, n3, n4);
        if (x>=1) {
            success="done";
            
             request.setAttribute("error",success);
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
            
        }
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.close();  
        
 }
}