
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.*" %>
<%@page import="java.lang.String"%>
<!DOCTYPE html>
<html>
<head>
	<title>MyCalendar</title>

	<meta name="description" content="Full view calendar component for twitter bootstrap with year, month, week, day views.">
	<meta name="keywords" content="jQuery,Bootstrap,Calendar,HTML,CSS,JavaScript,responsive,month,week,year,day">
	<meta name="author" content="Serhioromano">
	<meta charset="UTF-8">

	<link rel="stylesheet" href="components/bootstrap3/css/bootstrap.min.css">
	<link rel="stylesheet" href="components/bootstrap3/css/bootstrap-theme.min.css">
        
        <link rel="stylesheet" href="components/bootstrap3/css/elusive-webfonts.css">
	<link rel="stylesheet" href="css/calendar.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,600' rel='stylesheet'
type='text/css'>

	
</head>
<body>
    <div id="largeModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true" styles="display: none;" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Insert Event</h4>
                </div>
                <div class="modal-body">
                    <form class="form"   role="form" action="events.do" method="post">
                    
                    <input type="text" name="Title"  class="form-control" placeholder="Event Title" required="" autofocus="">
                    <label>Start</label>
                    <input type="text" name="start"  class="form-control" placeholder="yyyy-MM-dd" required="">
                    <label>End</label>
                    <input type="text" name="end" class="form-control" placeholder="yyyy-MM-dd" required="">
                    
                    
                                      

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    
    
    <div id="top-nav" class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-toggle"></span>
      </button>
      <a class="navbar-brand" href="#">MyCalendar</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
         <li class="dropdown">
              <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
            <i class="glyphicon">Shared</i>
            <span class="caret"></span></a>
            
            <%
             String z =(String) session.getAttribute("username");
             List styles = (List) session.getAttribute("List");
             Iterator it = styles.iterator();
             if (it.hasNext()){
                out.print("<ul id='g-account-menu' class='dropdown-menu' role='menu'>");
                out.print("<form method='POST' action='share.do'>");
                
             while(it.hasNext()) {
                String x=it.next().toString();
                out.print("<li><input class='btn btn-primary' type='submit' name='us' value="+ x + "></input></li>");
                
            }
             
             out.print("</form>");
             out.print("</ul>");
            }
            %>
          
         </li>
        <li>
            <%
             if (session.getAttribute("view_share")==null || (session.getAttribute("view_share") == "") ) {
                out.print("<a href='#' role='button' data-toggle='modal' data-target='#largeModal'> Add To  Calendar </a>");
             }
             else {
                 out.print("<a href='share.do' role='button' > Return to Your Calendar </a>");
             }
            %>
        </li>
        <li class="dropdown">
         
          <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
            <i class="glyphicon"></i>
            <%    if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
                        response.sendRedirect("index.jsp");
                  }
            else {
                     out.print(session.getAttribute("username"));
                
                 }
            %>
            <span class="caret"></span></a>
          <ul id="g-account-menu" class="dropdown-menu" role="menu">
           
            <li><a href="Logout"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div><!-- /container -->
</div>
<div class="container">
	
	<div class="page-header" style="margin-top: 60px;">
            <%
                String x1= (String)session.getAttribute("view_share");
                if(x1!=null) {
                out.print (x1);
                }
            %>
		<div class="pull-right form-inline">
			<div class="btn-group">
				<button class="btn btn-primary" data-calendar-nav="prev"><< Prev</button>
				<button class="btn btn-default" data-calendar-nav="today">Today</button>
				<button class="btn btn-primary" data-calendar-nav="next">Next >></button>
			</div>
			<div class="btn-group">
				<button class="btn btn-warning" data-calendar-view="year">Year</button>
				<button class="btn btn-warning active" data-calendar-view="month">Month</button>
				<button class="btn btn-warning" data-calendar-view="week">Week</button>
				<button class="btn btn-warning" data-calendar-view="day">Day</button>
			</div>
		</div>

		<h3></h3>
		
	</div>
            
	<div class="row">
            
		<div class="col-md-9">
			<div id="calendar"></div>
		</div>
		<div class="col-md-3">
			<div class="row">
                            <a href="Refresh" type="button" class="btn btn-primary">RefreshSharedList</a>
                            <br> </br>
                            <form role="form" action="events.do" method="post">
                                <%
                                 String y="done";
                                 String x=(String) session.getAttribute("shared");
                                 if(x!=null){
                                 if(x.equals(y)) {
				out.print("<input type='submit' class='btn btn-primary' value='UnShare Calendar' name='unshare' ></input>");
                                }
                                 else {
                                     out.print("<input type='submit' class='btn btn-primary' value='Share Calendar' name='share' ></input>");
                                 }
                                 }
                                 else {
                                     out.print("<input type='submit' class='btn btn-primary' value='Share Calendar' name='share' ></input>");
                                 }
                                 
                                 
                                %>
                            </form>    
			</div>

			<h4>Events</h4>
			<small>This list is populated with events dynamically</small>
			<ul id="eventlist" class="nav nav-list"></ul>
		</div>
	</div>

	<div class="clearfix"></div>
	<br><br>
	
	<noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>

	

	<script type="text/javascript" src="components/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="components/underscore/underscore-min.js"></script>
	<script type="text/javascript" src="components/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="components/jstimezonedetect/jstz.min.js"></script>
	<script type="text/javascript" src="js/language/bg-BG.js"></script>
	<script type="text/javascript" src="js/language/nl-NL.js"></script>
	<script type="text/javascript" src="js/language/fr-FR.js"></script>
	<script type="text/javascript" src="js/language/de-DE.js"></script>
	<script type="text/javascript" src="js/language/el-GR.js"></script>
	<script type="text/javascript" src="js/language/it-IT.js"></script>
	<script type="text/javascript" src="js/language/hu-HU.js"></script>
	<script type="text/javascript" src="js/language/pl-PL.js"></script>
	<script type="text/javascript" src="js/language/pt-BR.js"></script>
	<script type="text/javascript" src="js/language/ro-RO.js"></script>
	<script type="text/javascript" src="js/language/es-CO.js"></script>
	<script type="text/javascript" src="js/language/es-MX.js"></script>
	<script type="text/javascript" src="js/language/es-ES.js"></script>
	<script type="text/javascript" src="js/language/ru-RU.js"></script>
	<script type="text/javascript" src="js/language/sv-SE.js"></script>
	<script type="text/javascript" src="js/language/zh-TW.js"></script>
        <script type="text/javascript" src="js/language/cs-CZ.js"></script>
        <script type="text/javascript" src="js/language/ko-KR.js"></script>
	<script type="text/javascript" src="js/language/id-ID.js"></script>
	<script type="text/javascript" src="js/calendar.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
        <script src="components/bootsrap3/js/jquery.min.js" type="text/javascript"></script>
        <script src="components/bootsrap3/js/corgi.js" type="text/javascript"></script>
        <script src="components/bootsrap3/js/html5shiv.js"></script>

	<script type="text/javascript">
		var disqus_shortname = 'bootstrapcalendar'; // required: replace example with your forum shortname
		(function() {
			var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
			dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
			(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
		})();
	</script>
        <div class="modal fade" id="events-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3>Event</h3>
            </div>
            <div class="modal-body" id="bd1" style="height: 400px">
            </div>
            <div class="modal-footer">
                <% if (session.getAttribute("view_share")==null || (session.getAttribute("view_share") == "") ) {
                   out.print("<a href='Calendar.jsp' type='button' class='btn btn-primary' id='button1'>delete</a>");
                }
                %>
                <a href="#" data-dismiss="modal" class="btn">Close</a>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
