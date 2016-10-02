<?php require_once('../Connections/conn.php'); ?>
<?php
if (!isset($_SESSION)) {
  session_start();
}


$MM_authorizedUsers = "3";
$MM_donotCheckaccess = "false";

// *** Restrict Access To Page: Grant or deny access to this page
function isAuthorized($strUsers, $strGroups, $UserName, $UserGroup) { 
  // For security, start by assuming the visitor is NOT authorized. 
  $isValid = False; 

  // When a visitor has logged into this site, the Session variable MM_Username set equal to their username. 
  // Therefore, we know that a user is NOT logged in if that Session variable is blank. 
  if (!empty($UserName)) { 
    // Besides being logged in, you may restrict access to only certain users based on an ID established when they login. 
    // Parse the strings into arrays. 
    $arrUsers = Explode(",", $strUsers); 
    $arrGroups = Explode(",", $strGroups); 
    if (in_array($UserName, $arrUsers)) { 
      $isValid = true; 
    } 
    // Or, you may restrict access to only certain users based on their username. 
    if (in_array($UserGroup, $arrGroups)) { 
      $isValid = true; 
    } 
    if (($strUsers == "") && false) { 
      $isValid = true; 
    } 
  } 
  return $isValid; 
}

$MM_restrictGoTo = "../login.php?authCode=AccessDenied";
if (!((isset($_SESSION['MM_Username'])) && (isAuthorized("",$MM_authorizedUsers, $_SESSION['MM_Username'], $_SESSION['MM_UserGroup'])))) {   
  $MM_qsChar = "?";
  $MM_referrer = $_SERVER['PHP_SELF'];
  if (strpos($MM_restrictGoTo, "?")) $MM_qsChar = "&";
  if (isset($_SERVER['QUERY_STRING']) && strlen($_SERVER['QUERY_STRING']) > 0) 
  $MM_referrer .= "?" . $_SERVER['QUERY_STRING'];
  $MM_restrictGoTo = $MM_restrictGoTo. $MM_qsChar . "accesscheck=" . urlencode($MM_referrer);
  header("Location: ". $MM_restrictGoTo); 
  exit;
}
?>
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

$editFormAction = $_SERVER['PHP_SELF'];
if (isset($_SERVER['QUERY_STRING'])) {
  $editFormAction .= "?" . htmlentities($_SERVER['QUERY_STRING']);
}

if (isset($_GET['goal'])) {
  $updateSQL = sprintf("UPDATE goal SET deleted_flag=%s WHERE goal_id=%s",
                       1,
                       $_GET['goal']);

  mysql_select_db($database_conn, $conn);
  $Result1 = mysql_query($updateSQL, $conn) or die(mysql_error());
}

$colname_userDetails = "-1";
if (isset($_SESSION['MM_Username'])) {
  $colname_userDetails = $_SESSION['MM_Username'];
}
mysql_select_db($database_conn, $conn);
$query_userDetails = sprintf("SELECT * FROM account WHERE username = %s", GetSQLValueString($colname_userDetails, "text"));
$userDetails = mysql_query($query_userDetails, $conn) or die(mysql_error());
$row_userDetails = mysql_fetch_assoc($userDetails);
$totalRows_userDetails = mysql_num_rows($userDetails);

mysql_select_db($database_conn, $conn);
$query_goals = "SELECT goal_id, goal_creator, goal_name, `description`, doc FROM goal WHERE deleted_flag = 0";
$goals = mysql_query($query_goals, $conn) or die(mysql_error());
$row_goals = mysql_fetch_assoc($goals);
$totalRows_goals = mysql_num_rows($goals);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="../Templates/DoctorPanel.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Aramco OGC System</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="../styles/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="mainContainer">
  <div id="header">
    <div id="logo"><img src="../images/logo.jpg" width="400" height="250" alt="OGC System" />
      <div class="upperNav">Welcome back! Dr. <?php echo $row_userDetails['lname']; ?> [<a class="upperNavLink" href="../loggedOut.php">Logout</a>]</div>
    </div>
  </div>
  <div id="leftNav">
   	<a href="index.php" class="leftNavButton">Home</a>
    <a href="registerOGCT.php" class="leftNavButton">Add Health Team</a>
    <a href="registerPatient.php" class="leftNavButton">Add Patient</a>
    <a href="addGoal.php" class="leftNavButton">Add Goal</a>
    <a href="deleteGoal.php" class="leftNavButton">Delete Goal</a><a href="#" class="leftNavButton">Reports</a><a href="../loggedOut.php" class="leftNavButton">Logout</a>
  </div>
  <div id="content">
  
    <!-- InstanceBeginEditable name="content" -->
    <div class="contentTitle">
      <h1>Delete Goal</h1>
    </div>
    <div class="contentHolder"><?php
		if(isset($_GET['goal'])){
			echo "<span class='success'><img src='../images/check.jpg' width='20' height='20' />Goal deleted successfully</span>";
		}
	
	?>
    <p class="contentHolderText">Select a goal to delete:</p>
    <table width="550" border="1" cellspacing="1" cellpadding="1">
      <tr>
        <th width="120" scope="col">Goal Name</th>
        <th width="200" scope="col">Description</th>
        <th width="80" scope="col">Created by</th>
        <th width="70" scope="col">On</th>
        <th scope="col">Del?</th>
      </tr>
      <?php do { ?>
        <tr>
          <td width="120"><?php echo $row_goals['goal_name']; ?></td>
          <td width="200"><?php echo $row_goals['description']; ?></td>
          <td width="80"><?php echo $row_goals['goal_creator']; ?></td>
          <td width="70"><?php echo $row_goals['doc']; ?></td>
          <td><a href="deleteGoal.php?goal=<?php echo $row_goals['goal_id']; ?>"><img src="../images/x.jpg" width="20" height="20" /></a></td>
        </tr>
        <?php } while ($row_goals = mysql_fetch_assoc($goals)); ?>
    </table>
    <form id="form1" name="form1" method="POST" action="<?php echo $editFormAction; ?>">
      <input name="hiddenField" type="hidden" id="hiddenField" value="1" />
      <input type="hidden" name="MM_update" value="form1" />
    </form>
    <p>&nbsp;</p>
    <p class="contentHolderText"> </p>
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
<?php
mysql_free_result($userDetails);
mysql_free_result($goals);
?>