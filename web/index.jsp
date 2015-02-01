<%@page import="java.lang.String"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="components/bootstrap2/css/bootstrap.min.css">
	<link rel="stylesheet" href="components/bootstrap2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="components/bootstrap2/css/corgi.css">
        <link rel="stylesheet" href="components/bootstrap2/css/elusive-webfonts.css">
	<link rel="stylesheet" href="css/calendar.css">
<script type="text/javascript" src="components/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="components/underscore/underscore-min.js"></script>
	<script type="text/javascript" src="components/bootstrap2/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="components/jstimezonedetect/jstz.min.js"></script>
        <script type="text/javascript" src="js/calendar.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
        <script src="components/bootsrap2/js/jquery.min.js" type="text/javascript"></script>
        <script src="components/bootsrap2/js/corgi.js" type="text/javascript"></script>
        <script src="components/bootsrap2/js/html5shiv.js"></script>
 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url('img.jpg'); background-repeat: no-repeat; background-size: 100% auto; 	background-attachment: fixed;">
        
        <div id="largeModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true" styles="display: none;" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Registration</h4>
                </div>
                <div class="modal-body">
                    <form class="form-signin"   role="form" action="Regi" method="post">
                    <label for="inputEmail" class="sr-only">Email</label>
                    <input type="text" name="mail"  class="form-control" placeholder="Email address" required="" autofocus="">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" name="pass"  class="form-control" placeholder="Password" required="">
                    <label for="First Name" class="sr-only">First Name</label>
                    <input type="text" name="name" class="form-control" placeholder="First Name" required="">
                    <label for="Last Name" class="sr-only">Last Name</label>
                    <input type="text" name="last_name" class="form-control" placeholder="Last Name" required="">
                                      

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
        
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href="#">MyCalendar</a>
                </div>
            </div>
        </div>
        <div class="container" style="margin-top: 50px;">
         <div class="center"> 
            <div class="row">
                <div class="span14">
                     
            <form class="form-signin"   role="form" action="Login" method="post" style="margin-left: 405px; margin-right: 405px">
        <h2 class="form-signin-heading" style="background-color: white">Please sign in</h2>
        <label for="inputEmail" class="sr-only"></label>
        <input type="text" name="mail"  class="form-control" placeholder="Email address" required="" autofocus="">
        <label for="inputPassword" class="sr-only"></label>
        <input type="password" name="pass"  class="form-control" placeholder="Password" required="">
        
        
        <button id="btn1" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <button class="btn btn-lg btn-primary btn-block" data-toggle="modal" data-target="#largeModal">Register</button>
         </form>
        
        
     
          
          
       
                    <%
                      String y = "Sorry username or password error"; 
                      String x = (String) request.getAttribute("error");
                      
                      if(y.equals(x)){
                      
                      out.print("<div class='alert alert-error' id='myAlert'>"+
                               " <a class='close' data-dismiss='alert' id='cl'>&times;</a>"
                               +"<strong>Error!</strong> Wrong username or Password"
                               + " </div>");
                    }
                      
                      
                      String a="done";
                    if (a.equals(x)) {
                        out.print("<div class='alert alert-success' id='myAlert'>"+
                               " <a class='close' data-dismiss='alert' id='cl'>&times;</a>"
                               +"<strong>Success!</strong> Registration Succesful...Please log in"
                               + " </div>");
                            }
                      String b="yes";
                      if (b.equals(x)) {
                       out.print("<div class='alert alert-success' id='myAlert'>"+
                               " <a class='close' data-dismiss='alert' id='cl'>&times;</a>"
                               +"<strong>Success!</strong> Logout Succesful"
                               + " </div>");
                      }
  
                       %>
                    
                   
      </div>
       </div>
       </div>
        </div>
        
        

        <script>
    $(document).ready(function(){
	$("#cl").click(function(){
		$("#myAlert").remove();
	});
});
</script>
 
    </body>
   
</html>
