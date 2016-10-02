<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aramco OGC</title>

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
        
       
    </style>
    <script src="jqtouch/jquery-1.4.2.js" type="text/javascript" charset="utf-8"></script>
    <script src="jqtouch/jqtouch.js" type="application/x-javascript" charset="utf-8"></script
    
    <!-- JavaScript goes here -->
    <script type="text/javascript">
      // Fire up JQTouch
      var jQT = new $.jQTouch();
      
        function init(){
            // Determine if iPhone, Android or Desktop OS and setup the right click-event ("tap" vs "click").
            var userAgent = navigator.userAgent.toLowerCase();
            var isiPhone = (userAgent.indexOf('iphone') != -1 || userAgent.indexOf('ipod') != -1) ? true : false;
            var clickEvent = isiPhone ? 'tap' : 'click';
            $("#loginButton").bind(clickEvent, function(e){
                login();
            });
            $("#updateButton").bind(clickEvent, function(e){
            login();
            });
            $("#logoutButton").bind(clickEvent, function(e){
            logout();
            });
        }
            
            function login(){
                // Show a loading message
                var loginMsg = document.getElementById("authenticating");
                loginMsg.innerHTML = "<li><img src='logging_in.gif'/>Logging In...</li>";
        
                // Post username and password to login
                var user = document.getElementById("username_input").value;
                var pass = document.getElementById("password_input").value;
                
                var results_Holder = document.getElementById("results_Holder");
                
                $.post("login.php", { username: user, password: pass },
                function(data) {
                    if(data=="ERROR"){
                        alert("Authentication Failed!")
                        jQT.goback();
                    }
                    else{
                        results_Holder.innerHTML = data;
                        jQT.goTo("#patientScreen","flip");
                        document.getElementById("username_input").value = "";
                        document.getElementById("password_input").value = "";
                    }
                });
                
                
                loginMsg.style.visibility= "hidden";
                
                
                
            }
            function logout(){
                
                //alert("you are logged out!!");
                var results_Holder = document.getElementById("results_Holder");
                results_Holder.innerHTML = "<ul id='authenticating' class='rounded'></ul>";
                jQT.goTo("loginScreen","flip");
            }
    </script>

    <!-- CSS styles -->
    <style type="text/css" >

    </style>
  </head>

  <!-- UI definition goes here -->
<body onload="init()">
  <!-- "The Login Form -->
  <div id="loginScreen">
    <div class="toolbar">
      <h1>Aramco OGCS</h1>
      <a class="button" href="#aboutScreen">About</a>
    </div>
    <div class="logo"><img src="logo.png"/></div>
    <ul class="rounded">
        
      <li><h3> &nbsp; Login</h3></li>
      <li><input type="text" placeholder="User name" name="username" id="username_input" autocapitalize="off" autocorrect="off" autocomplete="off"/></li>
      <li><input type="password" placeholder="Password" name="password" id="password_input" autocapitalize="off" autocorrect="off" autocomplete="off"/></li>
      <li class="arrow"><a href="#" id="loginButton">Login</a></li>
    </ul>
  </div>
    
  <!-- "PatientScreen-->
  <div id="patientScreen">
    <div class="toolbar">
      <h1>Aramco OGCS</h1>
      <a id="logoutButton" class="button" href="#loginScreen">Logout</a>
    </div>
    <div id="results_Holder">
        <ul id="authenticating" class="rounded">
            
        </ul>
    </div>
    
  </div>
  <!-- About-->
  <div id="aboutScreen">
    <div class="toolbar">
      <h1>About</h1>
      <a class="back" href="#loginScreen">back</a>
      
    </div>
    <ul class="rounded">
        <li>Some information about the system to be shown here.. This is a very long text by the way..</li>
    </ul>
    
   
  

</body>
</html>