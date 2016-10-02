<?php
	require_once "../includes/functions.php";
	$user = initialize_Variables();
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Aramco OGCS</title>
        
        <style type="text/css" media="screen">@import "jqtouch/jqtouch.css";</style>
        <style type="text/css" media="screen">@import "themes/apple/theme.css";</style>
        <style type="text/css" media="screen">
            .logo{
                background-color:#fff;
                width:100%;
                text-align:center;
            }
            .heading_holder{
                background-image: url("themes/apple/img/heading_bg.jpg");
                background-repeat: repeat-x;
            }
        	#status{
				visibility:hidden;
			}
			.assignID{
				visibility:hidden;
			}
        
        </style>
        <script src="jqtouch/jquery-1.4.2.js" type="text/javascript" charset="utf-8"></script>
        <script src="jqtouch/jqtouch.js" type="application/x-javascript" charset="utf-8"></script>
        
        <!-- JavaScript goes here -->
        <script type="text/javascript">
		
			// Determine if iPhone, Android or Desktop OS and setup the right click-event ("tap" vs "click").
			var userAgent = navigator.userAgent.toLowerCase();
			var isiPhone = (userAgent.indexOf('iphone') != -1 || userAgent.indexOf('ipod') != -1 || userAgent.indexOf('ipad') != -1 ) ? true : false;
			clickEvent = isiPhone ? 'tap' : 'click';
			
            // Fire up JQTouch
            var jQT = new $.jQTouch({
	            icon: 'ogcs.png',
            	addGlossToIcon: false,
        	    startupScreen: '/ogcs_startup.png',
    	        statusBar: 'white',
	            preloadImages: [
        	        'themes/apple/img/back_button.png',
    	            'themes/apple/img/back_button_clicked.png',
	                'themes/apple/img/button_clicked.png',
                	'themes/apple/img/grayButton.png',
            	    'themes/apple/img/whiteButton.png',
        	        'themes/apple/img/loading.gif'
    	            ]
	        });

			function init(){
				$("#loginButton").bind(clickEvent, function(e){
					login();
				});
				$("#logoutButton").bind(clickEvent, function(e){
					logout();
				});
				
			}
			
			
			function login(){
				var user = document.getElementById("username_input").value;
				var pass = document.getElementById("password_input").value;
				
				if(user=="" || pass==""){
					alert("Missing details, please enter your username (or email) and your password.");
					return;
				}
				// Show a loading message
				document.getElementById("status").style.visibility = 'visible';
				
				// Post username and password to login
				var user = document.getElementById("username_input").value;
				var pass = document.getElementById("password_input").value;
				
				var results_Holder = document.getElementById("results_Holder");
				
				$.post("login.php", { username: user, password: pass },
				function(data) {
					if(data=="ERROR"){
						alert("Authentication Failed! Make sure you are connected to the internet and provided valid credentials.");
					}
					else{
						
						setTimeout( function() { results_Holder.innerHTML = data; }, 50 );
						document.getElementById("username_input").value = "";
						document.getElementById("password_input").value = "";
						jQT.goTo("#patientScreen","slideleft");
					}
				});
				
				document.getElementById("status").style.visibility = 'hidden';
				
				
			}
			
			
			function logout(){
				
				$.post("logout.php");
				var results_Holder = document.getElementById("results_Holder");
				setTimeout( function() { results_Holder.innerHTML = ""; }, 50 );
				jQT.goBack();
			}
			
			
			function updateScores(){
				var scores = document.getElementsByName("score");
				var assignIDs = document.getElementsByName("assignID");
				for(var i=0 ; i<scores.length ; i++){
					if( !isInt(scores[i].value) || scores[i].value>10 || scores[i].value<0){
						alert("Invalid value! please check your entries!");
						scores[i].focus();
						return;
					}
				}
				for(var i=0 ; i<scores.length ; i++){

					$.post("update.php", { assID: assignIDs[i].innerHTML, score: scores[i].value });
				}
				alert("Your scores has been updated successfully!");
			}
			
			
			function isInt(string){
	
				var numericExpression = /^[0-9]+$/;
	
				if(string.match(numericExpression)) {

					return true;

				} else {

					return false;

				}

			}
			
        </script>
    </head>
    <body onload="init()">
        <!-- START - LOGIN SCREEN -->
        <div id="loginScreen">
            <div class="toolbar">
            	<h1>Login</h1>
                <a class="button" href="#aboutScreen">About</a>
            </div>
            <div class="logo"><img src="logo.png"/></div>
            <ul class="rounded">
            	
            	<li><h3>&nbsp;Login</h3></li>
                <li><input type="text" placeholder="Username/Email" name="username" id="username_input" autocapitalize="off" autocorrect="off" autocomplete="off"/></li>
                <li><input type="password" placeholder="Password" name="password" id="password_input" autocapitalize="off" autocorrect="off" autocomplete="off"/></li>
            	<li id="loginButton" class="arrow"><a href="#">Login</a></li>
        	</ul>
            <ul  class="error" id="status">
            	<li>
                	<img src='logging_in.gif'/>Logging In...
                </li>
	        </ul>
        </div>
        <!-- END - LOGIN SCREEN -->
        <!-- START - PATIENT SCREEN -->
        <div id="patientScreen">
            <div class="toolbar">
            	<h1>Aramco OGCS</h1>
                <a id="logoutButton" class="button" href="#">Logout</a>
            </div>
            <div id="results_Holder">
            	<li></li>
            </div>
        </div>
        <!-- END - PATIENT SCREEN -->
        <!-- START - ABOUT SCREEN -->
        <div id="aboutScreen">
            <div class="toolbar">
            	<h1>About</h1>
                <a class="back" href="#loginScreen">Back</a>
            </div>
            
            <ul class="rounded">
            	<li>About</li>
            </ul>
        </div>
    </body>
</html>