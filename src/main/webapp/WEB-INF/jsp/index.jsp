<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<!-- <script src="js/app-ajax.js" type="text/javascript"></script> -->
<title>Performance App</title>
</head>
<body>
<h1>Performance Application</h1>
	<form id ="perf" method ="post" action ="random">
		<input type="text" name="parameter" id="para" placeholder="Enter number " />

		<button type="submit"name="submit" id="sub">Submit</button>
		
		
		<p >Total time taken in seconds:<span id="res"> 00</span></p>
	</form>
	<script>
	<% Date date =new Date();%>

	$(document).ready(function() {
	    $('#perf').submit(
	        function(event) {
	        	const d=new Date();
	        	const ms1=d.getMilliseconds();
	        	const s1=d.getSeconds();
	        	const m1=d.getMinutes();
	        	const s11=<%= System.currentTimeMillis()%>
	        	const ms11=<%= System.currentTimeMillis()%>
	        	console.log(s11);
	        	$('#h1').text(<%= date.getHours()%>)
	        	$('#m1').text(<%= date.getMinutes()%>)
	        	$('#s1').text(s1)
	        	$('#ms1').text(ms1)
	        	
	                 
	            $.ajax({
	                url : $("#perf").attr("action"),
	                data : {
						parameter : $('#para').val()
					},
	                type : "POST",
	 
	                success : function(response) {
	                	const d1=new Date();
	    	        	const s2=d1.getSeconds();
	    	        	const ms2=d1.getMilliseconds();
	    	         	const m2=d.getMinutes();
	    	        	const s22=<%= System.currentTimeMillis()%>
	    	        	console.log(s22)
	                	<% Date date1 =new Date();%>
	                 	$('#h2').text(<%= date1.getHours()%>)
	    	        	$('#m2').text(m2)
	    	        	$('#s2').text(s2)
	    	        	$('#ms2').text(ms2)
	    	            const secRes= (response)/1000;
	                 	console.log(secRes)
	                 	const msRes=response
	                 	const rs=secRes+"s"+msRes+"ms";
	                    $('#res').text(rs);
	                },
	                error : function(xhr, status, error) {
	                    //alert(xhr.responseText);
	                    $('#res').text(xhr.responseText);
	                }
	            });
	            return false;
	        });
	    });

		
	</script>
</body>
</html>