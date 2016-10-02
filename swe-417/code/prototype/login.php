<?php require_once('Connections/conn.php'); ?>
<?php
if (!function_exists("GetSQLValueString")) {
function GetSQLValueString($theValue, $theType, $theDefinedValue = "", $theNotDefinedValue = "") 
{
  if (PHP_VERSION < 6) {
    $theValue = get_magic_quotes_gpc() ? stripslashes($theValue) : $theValue;
  }

  $theValue = function_exists("mysql_real_escape_string") ? mysql_real_escape_string($theValue) : mysql_escape_string($theValue);

  switch ($theType) {
    case "text":
      $theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
      break;    
    case "long":
    case "int":
      $theValue = ($theValue != "") ? intval($theValue) : "NULL";
      break;
    case "double":
      $theValue = ($theValue != "") ? doubleval($theValue) : "NULL";
      break;
    case "date":
      $theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
      break;
    case "defined":
      $theValue = ($theValue != "") ? $theDefinedValue : $theNotDefinedValue;
      break;
  }
  return $theValue;
}
}
?>
<?php
// *** Validate request to login to this site.
if (!isset($_SESSION)) {
  session_start();
}

$loginFormAction = $_SERVER['PHP_SELF'];
if (isset($_GET['accesscheck'])) {
  $_SESSION['PrevUrl'] = $_GET['accesscheck'];
}

if (isset($_POST['username'])) {
  $loginUsername=$_POST['username'];
  $password=md5($_POST['password']);
  $MM_fldUserAuthorization = "type_flag";
  $MM_redirectLoginSuccess = "loggedIn.php";
  $MM_redirectLoginFailed = "login.php?authCode=fail";
  $MM_redirecttoReferrer = false;
  mysql_select_db($database_conn, $conn);
  	
  $LoginRS__query=sprintf("SELECT username, password, type_flag FROM account WHERE username=%s AND password=%s",
  GetSQLValueString($loginUsername, "text"), GetSQLValueString($password, "text")); 
   
  $LoginRS = mysql_query($LoginRS__query, $conn) or die(mysql_error());
  $loginFoundUser = mysql_num_rows($LoginRS);
  if ($loginFoundUser) {
    
    $loginStrGroup  = mysql_result($LoginRS,0,'type_flag');
    
	if (PHP_VERSION >= 5.1) {session_regenerate_id(true);} else {session_regenerate_id();}
    //declare two session variables and assign them
    $_SESSION['MM_Username'] = $loginUsername;
    $_SESSION['MM_UserGroup'] = $loginStrGroup;	      

    if (isset($_SESSION['PrevUrl']) && false) {
      $MM_redirectLoginSuccess = $_SESSION['PrevUrl'];	
    }
    header("Location: " . $MM_redirectLoginSuccess );
  }
  else {
    header("Location: ". $MM_redirectLoginFailed );
  }
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Untitled-1.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Aramco OGC System - Login</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="styles/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="mainContainer">
  <div id="header">
    <div id="logo"><img src="images/logo.jpg" width="400" height="250" alt="OGC System" />
      <div class="upperNav">You are not logged in [<a href="login.php" class="upperNavLink">Login</a>]</div>
    </div>
  </div>
  <div id="leftNav">
   	<a href="#" class="leftNavButton">Home</a>
    <a href="#" class="leftNavButton">Location</a>
    <a href="#" class="leftNavButton">About</a>
    <a href="#" class="leftNavButton">Contact us</a>
  </div>
  <div id="content">
  
    <!-- InstanceBeginEditable name="content" -->
      <h1>Login</h1>
<div class="contentHolder">
  <form class="form" id="loginForm" name="loginForm" method="POST" action="<?php echo $loginFormAction; ?>">
    <?php
	if(isset($_GET['authCode'])){
		if($_GET['authCode']=="AccessDenied"){
			echo "<p class='error'><img src='images/x.jpg' width='20' height='20' /> Authentication required: only permitted users can access this content.</p>";
		}
		elseif($_GET['authCode']=="fail"){
			echo "<p class='error'><img src='images/x.jpg' width='20' height='20' /> Authentication failed: Invalid username/password.</p>";
		}
		else{
			echo "<p class='error'>Unexpected error: Please try again.</p>";
		}
	}else{
		echo "<p>&nbsp;</p>";
	}
	?>
    <p>
      <label for="username">Username: </label>
      <input type="text" name="username" id="username" />
    </p>
    <p>
      <label for="password">Password: </label>
      <input type="password" name="password" id="password" />
    </p>
    <p>
      <input type="submit" name="button" id="button" value="Login" />
      <input type="reset" name="button2" id="button2" value="Reset" />
    </p>
  </form>
</div>
    <!-- InstanceEndEditable -->
  </div>
  
  
  <div id="footer">
  <p><a href="#">Home</a> | <a href="#">Location</a> | <a href="#">About</a> | <a href="#">Contact us</a></p>
  <p>&quot;copyright message will be here, the links above are optional if want to keep them&quot;</p>
</div>
</div>
</body>
<!-- InstanceEnd --></html>
