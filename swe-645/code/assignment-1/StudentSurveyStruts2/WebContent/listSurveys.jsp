<!--Shaeq Khan [skhan27]-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Surveys</title>
</head>

<style type="text/css">@import url(style.css);</style>
<%@ page import="skhan27.struts2.StudentService, skhan27.struts2.Student" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<body>
	
	<h4 align="center"><s:a href="index.jsp">Back to index</s:a></h4>
	<table border="1" id="surveys">  
    
    <tr>  
        <th>Name</th>        
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Date of survey</th>
        <th>Survey</th>
        <th>Raffle</th>
        <th>Comments</th>
    </tr>  
          
    <% 	Student[] students = StudentService.readSurveyData();
      		
      		for(int i = 0; i < students.length; i++) { %>
    <tr>  
          	<%  String firstname = students[i].getFirstname();
          		String lastname = students[i].getLastname();
          		String name = firstname + " " + lastname;
          		String address = students[i].getAddress();
          		String city = students[i].getState();
          		String zip = students[i].getZip();
          		String completeAddress = address + ", " + city + ", " + zip;
          		String phone = students[i].getPhone();
          		String email = students[i].getEmail();
          		String dateofsurvey = students[i].getDateofsurvey();
          		String survey = "";
          		String likes = students[i].getLikes();
          		String interest = students[i].getInterest();
          		String recommend = students[i].getRecommend();
          		survey = "Likes: " + likes + "\n. Interest: " + interest + "\n. Recommend: " + recommend;
          		String raffle = students[i].getRaffle();
          		String comments = students[i].getComments();
          	%>
          	
          <td><%= name%></td>  
          <td><%= completeAddress%></td>
          <td><%= phone%></td>
          <td><%= email%></td>
          <td><%= dateofsurvey%></td>
          <td><%= survey%></td>
          <td><%= raffle%></td>
          <td><%= comments%></td>     
       
    </tr>
     	<% } %>
  
	</table>  

</body>
</html>