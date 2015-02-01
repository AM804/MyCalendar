 
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
import static java.time.Clock.system;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Giorgos_2
 */
public class events extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException { 
    
    
     
        response.setContentType("application/json"); 
	JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
	obj.put("id", 293);
	obj.put("title", "Event 1");
        obj.put("url", "http://example.com");
        obj.put("class", "Short day event");
        obj.put("start", "1362938400000");
        obj.put("end", "1363197686300");
        
        obj1.put("success", 1);
        JSONArray list = new JSONArray();
        list.add(obj);
        obj1.put("result",list);
        PrintWriter out = response.getWriter();
        out.print(obj1);
        out.flush();
	//JSONArray list = new JSONArray();
	//list.add("msg 1");
	//list.add("msg 2");
	//list.add("msg 3");
 
	//obj.put("messages", list);
        //System.out.println(obj);
	
 
    }
}

