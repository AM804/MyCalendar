
package com.example.web;



import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Test extends HttpServlet {

  @Override
  public void doPost( HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {

    String c = request.getParameter("orderId").toString();

    // Now use our Coffee Model above 

    

    request.setAttribute("styles",c);
    PrintWriter out = response.getWriter();
    out.print(c);
    
  }
}
