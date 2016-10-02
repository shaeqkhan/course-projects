<!--Shaeq Khan [skhan27]-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Congratulations!</title>

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="skhan27.struts2.WinningResult" %>

</head>


<body>	
			
	<div id="wrapper">
		
		<div id="header" align="center">
			<h3>SWE 645 Component Based Software Engineering</h3>
			<h4>Assignment 1</h4>
			<h4 align="center"><s:a href="index.jsp">Back to index</s:a></h4>
			<h4 align="center"><s:a href="survey.jsp">Back to Survey</s:a></h4>
		</div><!-- header -->		
		
		<div id="content" align="center">			
			<P>
				Congratulations! You have won two movie tickets in the raffle... 
			</P>
			
			<P>
				Thank you, <s:property value="student.firstname"/> <s:property value="student.lastname"/>
				for filling out this survey!
			</P>
			
			<s:set scope="request" var="raffle" value="student.raffle"/>
					
			<P>
				Average for raffle numbers: <%= WinningResult.getMean() %> <BR>
				Standard Deviation for raffle numbers: <%= WinningResult.getSD() %>
			</P>				
			
			
		</div><!-- content -->
	
	</div><!-- wrapper -->
	
</body>

</html>