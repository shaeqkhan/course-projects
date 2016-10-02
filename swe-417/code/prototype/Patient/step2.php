<?php require_once('../Connections/conn.php'); ?>
<?php
if (!isset($_SESSION)) {
  session_start();
}
$MM_authorizedUsers = "1";
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

$colname_userDetails = "-1";
if (isset($_SESSION['MM_Username'])) {
  $colname_userDetails = $_SESSION['MM_Username'];
}
mysql_select_db($database_conn, $conn);
$query_userDetails = sprintf("SELECT * FROM account,paitent WHERE account.username = %s AND paitent.username = %s", GetSQLValueString($colname_userDetails, "text"),GetSQLValueString($colname_userDetails, "text"));
$userDetails = mysql_query($query_userDetails, $conn) or die(mysql_error());
$row_userDetails = mysql_fetch_assoc($userDetails);
$totalRows_userDetails = mysql_num_rows($userDetails);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/PatientPanel.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Aramco OGC System</title>
<script language="javascript">
	
	function setValue(){
		var checkBoxes = document.getElementsByTagName("input");
		
		var size= checkBoxes.length-2;
		var i;
		var value=0;
		for(i=0 ; i<size ; i++){
			if(checkBoxes[i].checked){
				value+=(+checkBoxes[i].value);
			}
		}
		
		document.getElementById("hiddenField").value = value;
	}

</script>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="../styles/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="mainContainer">
  <div id="header">
    <div id="logo"><img src="../images/logo.jpg" width="400" height="250" alt="OGC System" />
      <div class="upperNav">Welcome back! Mr. <?php echo $row_userDetails['lname']; ?> [<a class="upperNavLink" href="../loggedOut.php">Logout</a>]</div>
    </div>
  </div>
  <div id="leftNav">
   	<a href="index.php" class="leftNavButton">Home</a>
    <a href="#" class="leftNavButton">Add Goal</a>
    <a href="#" class="leftNavButton">Remove Goal</a><a href="../loggedOut.php" class="leftNavButton">Logout</a>
  </div>
  <div id="content">
  
    <!-- InstanceBeginEditable name="content" -->
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

mysql_select_db($database_conn, $conn);
$query_incrementalGoals = "SELECT * FROM goal WHERE type = 1 AND deleted_flag=0;";
$incrementalGoals = mysql_query($query_incrementalGoals, $conn) or die(mysql_error());
$row_incrementalGoals = mysql_fetch_assoc($incrementalGoals);
$totalRows_incrementalGoals = mysql_num_rows($incrementalGoals);

mysql_select_db($database_conn, $conn);
$query_decrementalGoals = "SELECT * FROM goal WHERE type = -1 AND deleted_flag=0;";
$decrementalGoals = mysql_query($query_decrementalGoals, $conn) or die(mysql_error());
$row_decrementalGoals = mysql_fetch_assoc($decrementalGoals);
$totalRows_decrementalGoals = mysql_num_rows($decrementalGoals);
?>
<style type="text/css">
.proceedButton {
	text-align: right;
}
</style>

<div class="contentTitle">
  <h1>Select Your Goals! </h1>
</div>
<div class="contentHolder"> </br>
  <table width="580" border="0" cellspacing="1" cellpadding="1">
    <tr>
      <td class="step">Welcome</td>
      <td class="currentStep">Select Goals</td>
      <td class="step">Customize</td>
      <td class="step">Finish</td>
    </tr>
  </table>
  <p class="contentHolderText">Text for step 2.</p>
  <div class="goalsIncrementalWizardTable">
        <h2>Positive Goals</h2>
    <table border="1" cellpadding="1" cellspacing="1">
      <tr>
            <th scope="col">Goal</th>
            <th scope="col">Description</th>
            <th scope="col">Pt. Scale</th>
      </tr>
      <?php do { ?>
        <tr>
          <td><input type="checkbox" name="eee" id="eee" value="<?php echo pow(10,($row_incrementalGoals['goal_id']-1)); ?>" />
            <?php echo $row_incrementalGoals['goal_name']; ?></td>
          <td><?php echo $row_incrementalGoals['description']; ?></td>
          <td>0 to <?php echo $row_incrementalGoals['daily_max']*$row_incrementalGoals['frequency']; ?></td>
        </tr>
        <?php } while ($row_incrementalGoals = mysql_fetch_assoc($incrementalGoals)); ?>
    </table>
        <p>&nbsp;</p>
  </div>
    <div class="goalsDecrementalWizardTable">
      <h2>Negative Goals</h2>
      <table border="1" cellpadding="1" cellspacing="1">
        <tr>
          <th scope="col">Goal</th>
          <th scope="col">Description</th>
          <th scope="col">Pt. Scale</th>
        </tr>
        <?php do { ?>
        <tr>
            <td><input type="checkbox" name="eee" id="eee" value="<?php echo pow(10,($row_decrementalGoals['goal_id']-1)); ?>" />

            <?php echo $row_decrementalGoals['goal_name']; ?></td>
            <td><?php echo $row_decrementalGoals['description']; ?></td>
            <td>0 to <?php echo $row_decrementalGoals['daily_max']*$row_decrementalGoals['frequency']; ?>
              
            </td>
        </tr>
          <?php } while ($row_decrementalGoals = mysql_fetch_assoc($decrementalGoals)); ?>
      </table>
      <p>&nbsp;</p>
    </div>
  <div class="clearDiv"></div>
  <form action="step3.php" method="post" name="form1" class="proceedButton">
    <input type="hidden" name="hiddenField" id="hiddenField">
    <input type="submit" onclick="setValue()" name="button" id="button" value="Add Goals and Proceed >>">
  </form>
  <p class="contentButton">&nbsp;</p>
  </p>
</div>
<?php
mysql_free_result($incrementalGoals);

mysql_free_result($decrementalGoals);
?>
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
?>
