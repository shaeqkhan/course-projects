<!--Shaeq Khan [skhan27]-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Survey</title>

<style type="text/css">@import url(style.css);</style>
<%@ taglib uri="/struts-tags" prefix="s" %>

</head>

<body>
		<s:div id="wrapper">
			
			<s:div id="header">
			<h3 align="center">SWE 645 Component Based Software Engineering</h3>
			<h4 align="center">Assignment 1</h4>
			<h4 align="center"><s:a href="index.jsp">Back to index</s:a></h4>
			</s:div>
			
			<s:div id="content">
			
			<s:form action="submitsurvey" method="POST" id="surveyTable">
				
				<s:div id="required">
				<p style="color:blue">			
				Personal Information (required)
				</p>				
				<s:textfield label="First Name" name="student.firstname" key="student.firstname"
							 maxlength="25" size="25" tooltip="Characters only, length = 25" /> 
				
				<s:textfield label="Last Name" name="student.lastname" key="student.lastname" 
							 maxlength="25" size="25" tooltip="Characters only, length = 25"/>
							  
				<s:textfield label="Address" name= "student.address" key="student.address" 
							 maxlength="75" size="25" tooltip="length = 75, eg. 4400 University Drive"/>
							  
				<s:textfield label="City" name="student.city" key="student.city" 
							 maxlength="15" size="25" tooltip="Characters only, length = 15, eg. Fairfax"/>
							  
				<s:textfield label="State" name="student.state" key="student.state" 
							 maxlength="2" size="25" tooltip="Characters only, length = 2, eg. VA, NY"/>
							  
				<s:textfield label="Zip" name="student.zip" key="student.zip"  
							 maxlength="5" size="25" tooltip="Digits only, length = 5, eg. 22030"/>
							  
				<s:textfield label="Phone" name="student.phone" key="student.phone" 
							 maxlength="10" size="25" tooltip="Digits only, Length = 10, eg. 1234567891"/>
				
				<s:textfield label="Email" name="student.email" key="student.email" 
							 maxlength="40" size="25" tooltip="Length = 40, eg. skhan27@gmu.edu"/>
				 
				<s:textfield label="Date of Survey" name="student.dateofsurvey" key="student.dateofsurvey" 
							 maxlength="10" size="25" tooltip="dd/mm/yyyy, eg. 18/05/2013"/> 
				
				</s:div> <!-- required -->
				
				
				<s:checkboxlist label="What did you like most about the campus?"
								labelposition="top" 
				 				key="student.likes"
				 				list="#{'Students':'Students','Location':'Location','Campus':'Campus', 
				 						'Atmosphere':'Atmosphere','Dorms':'Dorms','Sports':'Sports'}"
				 />
				
				 					 
				<s:radio label="How did you become interested in the university?"
						 labelposition="top" 
						 key="student.interest"  
						 list="{'Friends','Television','Internet','Other'}" 
				/>
				 
				 		 
				<s:select   label="How likely are you to recommend this university to other prospective students?"
        					key="student.recommend"
        					labelposition="top"
        					headerKey="-1"
        					headerValue="Select"            
        					list="#{'Very Likely':'Very Likely', 'Likely':'Likely', 'Unlikely':'Unlikely'}"                                                  
        		/>
        		
        		
				<s:textfield label="Enter numbers between 1 and 100 for raffle" key="student.raffle" 
							 maxlength="39" size="40" labelposition="top" 
							 tooltip="Enter numbers with comma in between and no spaces, eg. 10,20,30,40,50,60,70,80,90,100"/>		 
				
				 
				<s:textarea label="Comments" key="student.comments" rows="4" cols="50" labelposition="top"/>


			<s:submit value="Submit" labelposition="left"/>

			
			</s:form>
			
			</s:div><!-- content -->
			
		</s:div><!-- wrapper -->
			
</body>

</html>