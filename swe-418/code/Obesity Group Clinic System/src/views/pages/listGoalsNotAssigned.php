<?php
	$PAGE_TYPE = "PANEL";						//{ HOME,PANEL,HELP,ABOUT }	
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	//require_once "functions/user.class.php";
	require_once "views/renderLayout.php";
	require_once "views/viewGoalsNotAssigned.php";

	$user = initialize_Variables();
	
	if(!restrictAccess($user, -1)){
		include "views/pages/forbidden.php";
		die();
	}
	
	$gets = array("id");
	if(!requireGets($gets) ){
		include "views/pages/forbidden.php";
		die();
	}
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<?php
	loadHead($PAGE_TYPE);
?>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Aramco OGC - Adding Goals</title>


</head>

<body>

<div class="container">

   <?php
   		viewHeader($user,$PAGE_TYPE,$loginStatus);
   ?>
  <div class="sidebar"><?php viewSideBar($user); ?></div>
  
  <div class="content">
      
    <br />
	<br />
	<br />
<div class="heading">Assigning New Goals</div>
    
    <div class="contentBody"><?php viewGoalsNotAssigned(); ?><br /></div>
    
  </div>
  
  <div class="footer">
  	  <?php viewFooter(); ?>
  </div>
  
  
</div>

</body>
</html>