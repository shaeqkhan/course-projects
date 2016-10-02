<?php
	$PAGE_TYPE = "PANEL";					//{ HOME,PANEL,HELP,ABOUT }	
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";
	
	$user = initialize_Variables();
	
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Aramco OGC</title>
<?php
	loadHead($PAGE_TYPE);
?>
</head>

<body>

<div class="container">

   <?php
   		viewHeader($user,$PAGE_TYPE);
   ?>
  
  <div class="sidebar"><?php viewSideBar($user); ?></div>
  
  <div class="content">
  
    <div class="errorMessages">
    Check the following error message(s).
    <ul>
    	<li>Error message 1.</li>
    </ul>
    
    </div>
    
    <div class="heading">Heading</div>
    
    <div class="contentBody">call content herecall content herecall content herecall content herecall content herecall content herecall content</div>
    
  </div>
  
  <div class="footer">
  	  <?php viewFooter(); ?>
  </div>
  
</div>

</body>
</html>