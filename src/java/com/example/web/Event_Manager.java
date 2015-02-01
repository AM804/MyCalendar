
package com.example.web;
import static java.lang.System.out;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import javax.servlet.http.HttpSession;


public class Event_Manager {
    
    public static int UnShare(String n){
        int i=0;
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
            pst = conn.prepareStatement("delete from shared where user=?"); 
            
            pst.setString(1,n);  
           
              
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
    
    
    
    
    
    public static int Share(String n){
        int i=0;
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
            pst = conn.prepareStatement("insert into shared (shared,user) values(?,?)"); 
            pst.setString(1,"YES");
            pst.setString(2,n);  
           
              
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
    
    
    
    
    public static int Insert(String n1, String n2, String n3, String n4) throws ParseException{
      
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
        Random rand = new Random();
        int  n = rand.nextInt(999) + 100;
        String id =String.valueOf(n);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date d = sdf.parse(n2);
        Date d1=sdf.parse(n3);
        Long x1=d.getTime();
        Long x2=d1.getTime();
        String x=Long.toString(x1);
        String y=Long.toString(x2);
        
 
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("insert into events (user,owner,start,end,class,id,Title)values(?,?,?,?,?,?,?)"); 
            pst.setString(1,n4);
            pst.setString(2,n4);  
            pst.setString(3,x);
            pst.setString(4,y);
            pst.setString(5,"event-success");
            pst.setString(6,id);
            pst.setString(7,n1);
              
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
    
    
    
    public static int Delete(String n1){
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
            
            pst = conn.prepareStatement("delete from events where id =?");
            
            pst.setString(1,n1);
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
