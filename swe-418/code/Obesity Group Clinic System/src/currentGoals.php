<?php
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "views/renderLayout.php";
	require_once "views/viewCurrentGoals.php";
		
	$user = initialize_Variables();
	$requiredGets = array("id");
	if(!requireGets($requiredGets)){
		// restirct the access
		die('1');
	}
	if(!restrictAccess($user,-1)){
		// restrict the access
		die('2');
	}
	
	//if( $user->type_flag == 2 && $user->id != $_GET['id'] ){
		//retrict the access
	//	die('3');
	//}
	
	
	
?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<?php
	loadHead();
?>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OGC Aramco - Current Goals</title>
</head>

<body>
<?php
	viewCurrentGoals();
?>
</body>
</html>