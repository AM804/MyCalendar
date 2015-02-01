/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Giorgos
 */

public class listen implements ServletContextListener{
static int c= 1;
    public void contextInitialized(ServletContextEvent sce) {
       //System.out.println("lalala" + c++ );
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println( sdf.format(cal.getTime()) );
    }

    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
