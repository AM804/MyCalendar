/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao { 
    
    
    public static boolean validate(String name, String pass) throws SQLException {          
        boolean status = false;  
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "test";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "301989rd";
 
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
            pst = conn  
                    .prepareStatement("select * from login where user=? and pass=?");  
            pst.setString(1,name);
            pst.setString(2,pass);
  
            rs = pst.executeQuery();  
            status = rs.next();  
  
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
        return status;  
    }
    public static  Boolean CheckShare  (String x) {
        boolean status = false;  
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "test";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "301989rd";
 
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
            pst = conn  
                    .prepareStatement("select * from shared where user=?");  
            pst.setString(1,x);
            
  
            rs = pst.executeQuery();  
            status = rs.next();  
  
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
        return status; 
       
        
    }
    
    public static List MakeList (String x) {
        List types = new ArrayList();
        boolean status = false;  
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        String t;
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "test";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "301989rd";
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
            pst = conn  
                    .prepareStatement("select user from shared ");  
            //pst.setString(1,n);
            
  
            rs = pst.executeQuery();  
            while (rs.next()) {
                t = rs.getString(1);
                if (!t.equals(x)) {
                types.add(t);
                }
                
                
        }  
  
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
        
        
        return types;
    } 
    
   
        public static int register(String mail, String pass, String name, String last_name) throws SQLException {          
        boolean status = false;  
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        int i =0;
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "test";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "301989rd";
 
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("insert into login (user,pass,name,last_name)values(?,?,?,?)"); 
            pst.setString(1,mail);  
            pst.setString(2,pass);  
            pst.setString(3,name);
            pst.setString(4,last_name);
              
           i=pst.executeUpdate();  
            
  
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
            
        }  
        return i;  
    }
}

