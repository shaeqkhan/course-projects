<?php require_once('../Connections/conn.php'); ?>
<?php require_once('../Connections/conn.php'); ?>
<?php
	if(isset($_POST['hiddenField'])){
		$goals_Code = $_POST['hiddenField'];
	}else{
		die("error");
	}
	
	function generatedQuery($code){
		$code_length = strlen($code);
		$reversed = strrev( $code)."0";
		$query = "SELECT * FROM GOAL WHERE";
		for($i=0 ; $i< $code_length ; $i++){
			if($reversed[$i+1]==1){
				$query = $query." goal_id = $i OR";
			}
		}
		
		$queryLength = strlen($query);
		$query = substr($query,0,$queryLength-3);
		return $query;
	}
?>
	
<?php 
	generatedQuery($goals_Code);
	require_once('../Connections/conn.php'); ?>
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

mysql_select_db($database_conn, $conn);
$query_selectedGoals = generatedQuery($goals_Code);
$selectedGoals = mysql_query($query_selectedGoals, $conn) or die(mysql_error());
$row_selectedGoals = mysql_fetch_assoc($selectedGoals);
$totalRows_selectedGoals = mysql_num_rows($selectedGoals);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/PatientPanel.dwt.php" codeOutsideHTMLIsLocked="false" -->
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
    <div class="contentTitle">
      <h1>Customize Your Goals!</h1>
    </div>
    <div class="contentHolder"> </br>
      <table width="580" border="0" cellspacing="1" cellpadding="1">
        <tr>
          <td class="step">Welcome</td>
          <td class="step">Select Goals</td>
          <td class="currentStep">Customize</td>
          <td class="step">Finish</td>
        </tr>
      </table>
      <p class="contentHolderText">Text for step 3.</p><form id="form1" name="form1" method="post" action="">
        <?php do { ?>
          <table width="450" border="0" cellspacing="1" cellpadding="1">
            <tr>
              <th width="200" scope="col"><blockquote>
                <?php echo $row_selectedGoals['goal_name']; ?>
              </blockquote></th>
              <th width="114" scope="col">&nbsp;</th>
              <th width="51" scope="col">&nbsp;</th>
            </tr>
            <tr>
              <td width="200"><input type="hidden" name="doa" id="doa" />
                <input type="hidden" name="current_flag" id="current_flag" />
                <input type="hidden" name="assigned_by" id="assigned_by" />
              <input type="hidden" name="goal_id" id="goal_id" /></td>
              <td width="114">Stated Daily Max:</td>
              <td><label for="textfield"></label>
              <input name="textfield" type="text" id="dailymax" size="2" /></td>
            </tr>
            <tr>
              <td width="200">&nbsp;</td>
              <td width="114">Stated Frequency</td>
              <td><input name="frequency" type="text" id="frequency" size="2" /></td>
            </tr>
          </table>
          <p class="contentHolderText"></p>
          <p class="contentHolderText">
          </p>
          <?php } while ($row_selectedGoals = mysql_fetch_assoc($selectedGoals)); ?>
</p>
      <p class="contentButton"><a href="step4.php">Proceed to the next step &gt;&gt;</a></p>
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
<?php
mysql_free_result($userDetails);

mysql_free_result($selectedGoals);
?>