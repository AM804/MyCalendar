/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Refresh extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
                HttpSession session = request.getSession();
                String x=(String)session.getAttribute("username");
                List shared=LoginDao.MakeList(x);
                session.setAttribute("List",shared);
                response.sendRedirect("Calendar.jsp");
    }

    }
