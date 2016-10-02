<?php
	$PAGE_TYPE = "ABOUT";					//{ HOME,PANEL,HELP,ABOUT }	
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";
	
	$user = initialize_Variables();
	
	if( isset( $_POST['login'] ) ){
		$loginStatus = 1;
		$email = $_POST['login-email'];
		$password = $_POST['login-password'];
		
		//if login successful
		if( loginUser($email,$password)==1 ){
			$user = initialize_Variables();
			header("location:panel.php");
		}
	}
	
	
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<?php
	loadHead($PAGE_TYPE);
?>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Aramco OGC - Home</title>


</head>

<body>

<div class="container">

   <?php
   		viewHeader($user,$PAGE_TYPE,$loginStatus);
   ?>
    
  <div class="content">
  <div class="contentBody">
    <div class="heading">About The Obesity Group Clinic</div>

    	<p>
        OGCS Obesity Group Clinic System has been developed by a team of undergraduates studying Software Engineering at King Fahd University of Petroleum and Minerals for an Obesity Group Clinic located inside the Saudi Aramco Campus.
        </p>
        
        <p>
        Dr. Essam Jalal is the head of this clinic and he had approached the Department of Computer Science and Engineering to make a software system that helps him manage his patients better. Under the supervision of Dr. Sajjad, six seniors joined their talents to take this up as their senior design project and deliver a quality web application.
        </p>
        
        <p>All of us have learnt a lot along the way and we feel proud and satisfied upon completion of this project.</p>
        
        <p>Our team consists of the following members : -</p>
        
        <table width="1000"  border="0" >
  <tr>
    <td width="500"><p>
        Abdulaziz Al-Amoudi
        <br/>
        <a href="mailto:azoooz.09@gmail.com">azoooz.09@gmail.com</a>
        <div style="float:left;"><img src="images/aziz.JPG" width="300" height="400" alt="Aziz" /></div>
        </p></td>
    <td width="500"><p>
        Rakan Al-Ghufaili
        <br/>
        <a href="mailto:rakan.i.g@gmail.com">rakan.i.g@gmail.com</a>
        <div style="float:left;"><img src="images/rakan.JPG" width="300" height="331" alt="Rakan" /></div>
        </p></td>
  </tr>
  <tr>
    <td><p>
        Saeed Al-Tuwaileb
        <br/>
        <a href="mailto:saeed.altuwaileb@gmail.com">saeed.altuwaileb@gmail.com</a>
        <div style="float:left;"><img src="images/saeed.JPG" width="300" height="400" alt="Saeed" /></div>
        </p></td>
    <td><p>
        Sameer Al-Amri
        <br/>
        <a href="mailto:sameer0703@gmail.com">sameer0703@gmail.com</a>
        <div style="float:left;"><img src="images/sameer.JPG" width="300" height="400" alt="Sameer" /></div>
        </p></td>
  </tr>
  <tr>
    <td><p>
        Shaeq Khan
        <br/>
        <a href="mailto:shaeqkhan@gmail.com">shaeqkhan@gmail.com</a>
        <div style="float:left;"><img src="images/shaeq.JPG" width="400" height="300" alt="Shaeq" /></div></p></td>
    <td><p>
        Yasir Al-Agl
        <br/>
        <a href="mailto:alagly@gmail.com">alagly@gmail.com</a>
        <div style="float:left;"><img src="images/yasir.JPG" width="315" height="270" alt="Yasir" /></div>
        </p></td>
  </tr>

</table>

        
        
        
      
    </div>
  

  
  <div class="footer">
  	  <?php viewFooter(); ?>
  </div>
</div>

</body>
</html>