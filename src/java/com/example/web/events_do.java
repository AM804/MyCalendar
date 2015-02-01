
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Giorgos_2
 */
public class events_do extends HttpServlet {
    
       public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
           int x;
        String success;
        PrintWriter out = response.getWriter();
        
        if ((request.getParameter("share") != null)|| (request.getParameter("unshare")!=null)) {
            if (request.getParameter("share") != null) {
            HttpSession session = request.getSession();
            String n4=(String)session.getAttribute("username");
            x=Event_Manager.Share(n4);
            if (x>=1) {
                success="done";
                session.setAttribute("shared",success);
                RequestDispatcher rd=request.getRequestDispatcher("Calendar.jsp");
                rd.forward(request,response);
                
            }
            
            out.close(); 
            }
            
            else {
                
                
            HttpSession session = request.getSession();
            String n4=(String)session.getAttribute("username");
            x=Event_Manager.UnShare(n4);
            if (x>=1) {
                success="undone";
                session.setAttribute("shared",success);
                RequestDispatcher rd=request.getRequestDispatcher("Calendar.jsp");
                rd.forward(request,response);
                
            }
            
            out.close(); 
                
            }
        }
        
      
        
        else {
        
        if (request.getParameter("orderId")==null) {
        String n1=request.getParameter("Title");  
        String n2=request.getParameter("start");
        String n3=request.getParameter("end");
        HttpSession session = request.getSession();
        String n4=(String)session.getAttribute("username");
        try{
        x=Event_Manager.Insert(n1, n2, n3, n4);
        if (x>=1) {
            success="done";
            
            request.setAttribute("error",success);
            RequestDispatcher rd=request.getRequestDispatcher("Calendar.jsp");
            rd.forward(request,response);
            
        }
        }  catch (java.text.ParseException ex) {
               Logger.getLogger(events_do.class.getName()).log(Level.SEVERE, null, ex);
           }
        out.close();  
        
        }
        else {
            
            String n5=request.getParameter("orderId");
            
            
            x=Event_Manager.Delete(n5);
            if (x==0) {
                success="done";
                
                request.setAttribute("error",success);
               response.sendRedirect("Calendar.jsp");
                
                
            }
            out.close();
        }
           
           
        }   
       }
       
    
        public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
            
        boolean status = false;  
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        String username;
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "test";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "301989rd";
        HttpSession session = request.getSession();
        String x= (String)session.getAttribute("view_share");
        if(x!=null) {
            username=x;
        }
        else {
        username=(String)session.getAttribute("username");
        }
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONArray list = new JSONArray();
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);
            
            
            pst = conn  
                    .prepareStatement("select owner,start,end,class,id,Title from events where user=?");
            
            pst.setString(1,username);
            
  
            rs = pst.executeQuery(); 
            
            
        /*obj.put("id", 293);
	obj.put("title", "Event 1");
        obj.put("url", "http://example.com");
        obj.put("class", "Short day event");
        obj.put("start", "1362938400000");
        obj.put("end", "1363197686300");
        
        obj1.put("success", 1);
        
        list.add(obj.clone());
        
        obj.put("id", 293);
	obj.put("title", "Event 2");
        obj.put("url", "http://example.com");
        obj.put("class", "Short day event");
        obj.put("start", "1362938400000");
        obj.put("end", "1363197686300");
        
        list.add(obj.clone());
        obj1.put("result",list);
        */
        
            obj1.put("success", 1);
               while(rs.next()){
                
                str1=rs.getString(1);
                str2=rs.getString(2);
                str3=rs.getString(3);
                str4=rs.getString(4);
                str5=rs.getString(5);
                str6=rs.getString(6);
                obj.put("id", str5);
	        obj.put("title", str6);
                obj.put("url", "");
                obj.put("class", str4);
                obj.put("start", str2);
                obj.put("end", str3);
                obj.put("owner", str1);
                list.add(obj.clone());
                
                
               }
              obj1.put("result",list);
                
                
                
            
            response.setContentType("application/json");
            
            PrintWriter out = response.getWriter();
            out.print(obj1);
            out.flush();
            
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }
        }  
         
    }
            
        }


