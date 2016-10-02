<?php
// *** Logout the current user.
$logoutGoTo = "index.php";
if (!isset($_SESSION)) {
  session_start();
}
$_SESSION['MM_Username'] = NULL;
$_SESSION['MM_UserGroup'] = NULL;
unset($_SESSION['MM_Username']);
unset($_SESSION['MM_UserGroup']);
if ($logoutGoTo != "") {header("Location: $logoutGoTo");
exit;
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Untitled-1.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Aramco OGC System</title>
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
    <div class="contentTitle">
      <h1>Good Bye!</h1>
    </div>
    <div class="contentHolder">
      <p class="contentHolderText">You have logged out successfully!</p>
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
