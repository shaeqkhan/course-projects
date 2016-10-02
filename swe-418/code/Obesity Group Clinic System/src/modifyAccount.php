<?php
	$PAGE_TYPE = "PANEL";						//{ HOME,PANEL,HELP,ABOUT }	
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";
	require_once "views/viewModifyAccount.php";

	$user = initialize_Variables();
	
	//check the user group
	if(!restrictAccess($user,-1)){
		include "views/pages/forbidden.php";
		die();
	}
	
	//check the gets provided
	$gets = array("id");
	if(!requireGets($gets) ){
		include "views/pages/forbidden.php";
		die();
	}
	
	//check authorization
	if($user->type_flag ==2){	//he is a patient
		if( $user->id != $_GET['id'] ){	//his id not the same as the get id
			include "views/pages/forbidden.php";
			die();
		}
	}
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<?php
	loadHead($PAGE_TYPE);
?>
<script type="text/javascript" src="js/confirmPassword.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Aramco OGC - Modify Account</title>


</head>

<body>

<div class="container">

   <?php
   		viewHeader($user,$PAGE_TYPE,$loginStatus);
   ?>
  <div class="sidebar"><?php viewSideBar($user); ?></div>
  
  <div class="content">
      

<div class="heading">Modify Account</div>
    
    <div class="contentBody"><?php viewModifyAccount($user,$_POST); ?><br /></div>
    
  </div>
  
  <div class="footer">
  	  <?php viewFooter(); ?>
  </div>
  
  
</div>

</body>
</html>