<?php
	$PAGE_TYPE = "PANEL";					//{ HOME,PANEL,HELP,ABOUT }	
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";

	$user = initialize_Variables();
	
	
	
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
  <div class="sidebar"><?php viewSideBar($user); ?></div>
  
  <div class="content">
  
    
    
    <div class="heading">Welcome to your control panel!</div><br />

    
    <div class="contentBody">You can use the left side bar to navigate through the system.<br />
In case you thought you are in a need for a hand, you can always get some <a href="help.php">help</a>.<br />
If you need any further assistance, feel free to <a href="mailto:essam.jalal@aramco.com">contact</a> for any issue</div>
    
  </div>
  
  <div class="footer">
  	 <?php viewFooter(); ?>
  </div>
  
</div>

</body>
</html>