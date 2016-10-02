<?php
	$PAGE_TYPE = "PANEL";
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "views/renderLayout.php";
	require_once "views/viewCreateUser.php";
	
	$user = initialize_Variables();
	restrictAccess($user,1);
	
?>
<html>
	<head>
    	<?php
			loadHead($PAGE_TYPE);
		?>
	    <title>Aramco OGC - Update Account</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/form.css" rel="stylesheet" type="text/css" />
		<link href="css/patientGoals.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="js/validate.js"></script>
    </head>
    <body>
    	<div id="header">
	    	<?php
				viewHeader($user,$PAGE_TYPE,$loginStatus);
			?>
        </div>
        <div id="content">
        	<?php
				viewCreateUser($_POST);
			?>
        </div>
        <div id="footer">
        	<?php
				viewFooter();
			?>
        </div>
    </body>