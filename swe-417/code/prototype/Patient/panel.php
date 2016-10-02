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

$editFormAction = $_SERVER['PHP_SELF'];
if (isset($_SERVER['QUERY_STRING'])) {
  $editFormAction .= "?" . htmlentities($_SERVER['QUERY_STRING']);
}

if ((isset($_POST["MM_update"])) && ($_POST["MM_update"] == "form")) {
  $updateSQL = sprintf("UPDATE paitent_goals_history SET day1=%s, day2=%s, day3=%s, day4=%s, day5=%s, day6=%s, day7=%s WHERE paitent=%s AND assigned_goal=%s",
                       GetSQLValueString($_POST['day1'], "int"),
                       GetSQLValueString($_POST['day2'], "int"),
                       GetSQLValueString($_POST['day3'], "int"),
                       GetSQLValueString($_POST['day4'], "int"),
                       GetSQLValueString($_POST['day5'], "int"),
                       GetSQLValueString($_POST['day6'], "int"),
                       GetSQLValueString($_POST['day7'], "int"),
                       GetSQLValueString($_POST['iPaitentID1'], "text"),
                       GetSQLValueString($_POST['iGoalID1'], "int"));
  mysql_select_db($database_conn, $conn);
  $Result1 = mysql_query($updateSQL, $conn) or die(mysql_error());

  $updateGoTo = "panel.php?code=updated";
  if (isset($_SERVER['QUERY_STRING'])) {
    $updateGoTo .= (strpos($updateGoTo, '?')) ? "&" : "?";
    $updateGoTo .= $_SERVER['QUERY_STRING'];
  }
  header(sprintf("Location: %s", $updateGoTo));
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

$colname_incrementalGoals = "-1";
if (isset($_SESSION['MM_Username'])) {
  $colname_incrementalGoals = $_SESSION['MM_Username'];
}
mysql_select_db($database_conn, $conn);
$query_incrementalGoals = sprintf("SELECT * FROM goal g, paitent_goals pg, paitent_goals_history pgh WHERE (g.type=1 AND g.goal_id=pg.goal AND pg.paitent = %s AND pgh.paitent=pg.paitent AND pgh.assigned_goal =  pg.assignition_id AND pgh.week = 1)", GetSQLValueString($colname_incrementalGoals, "text"));
$incrementalGoals = mysql_query($query_incrementalGoals, $conn) or die(mysql_error());
$row_incrementalGoals = mysql_fetch_assoc($incrementalGoals);
$totalRows_incrementalGoals = mysql_num_rows($incrementalGoals);

$x_decrementalGoals = "-1";
if (isset($_SESSION['MM_Username'])) {
  $x_decrementalGoals = $_SESSION['MM_Username'];
}
mysql_select_db($database_conn, $conn);
$query_decrementalGoals = sprintf("SELECT * FROM goal g, paitent_goals pg, paitent_goals_history pgh WHERE (g.type=-1 AND g.goal_id=pg.goal AND pg.paitent = %s AND pgh.paitent=pg.paitent AND pgh.assigned_goal =  pg.assignition_id AND pgh.week = 1)", GetSQLValueString($x_decrementalGoals, "text"));
$decrementalGoals = mysql_query($query_decrementalGoals, $conn) or die(mysql_error());
$row_decrementalGoals = mysql_fetch_assoc($decrementalGoals);
$totalRows_decrementalGoals = mysql_num_rows($decrementalGoals);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/PatientPanel.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Aramco OGC System</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<script src="../SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<link href="../SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css" />
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
    <h1>My Week</h1>
    <div class="contentHolder">
      <div class="form">
          <?php
		if(isset($_GET['code'])){
			echo "<span class='success'><img src='../images/check.jpg' width='20' height='20' />Progress updated successfully!</span>";
		}
	
	?>
        <h2>Incremental Goals</h2>
        <table class="" width="100%" border="1" cellspacing="1" cellpadding="1">
          <tr>
            <th scope="col">Goal</th>
            <th width="40" scope="col">Sat</th>
            <th width="40" scope="col">Sun</th>
            <th width="40" scope="col">Mon</th>
            <th width="40" scope="col">Tue</th>
            <th width="40" scope="col">Wed</th>
            <th width="40" scope="col">Thu</th>
            <th width="40" scope="col">Fri</th>
            <th width="80" scope="col">Total</th>
          </tr>
          <?php do { ?>
            <tr><form method="POST" action="<?php echo $editFormAction; ?>" name="form">
              <th scope="row"><p><?php echo $row_incrementalGoals['goal_name']; ?></p>
                <table class="weeklyViewStatedMaxTable" width="100%" border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td>Total Max.</td>
                    <td><label for="textfield"></label>
                      <input name="textfield" type="text" disabled="disabled" id="textfield" value="<?php echo $row_incrementalGoals['daily_max']; ?>" size="2" /></td>
                    </tr>
                  <tr>
                    <td>Freq.</td>
                    <td><label for="textfield2"></label>
                      <input name="textfield2" type="text" disabled="disabled" id="textfield2" value="<?php echo $row_incrementalGoals['stated_frequency']; ?>" size="1" /></td>
                    <td><img src="../images/edit.jpg" width="25" height="25" alt="edit" /></td>
                    </tr>
                </table></th>
              <td width="40"><span id="sprytextfield1">
                <label for="day1"></label>
                <input name="day1" type="text" id="day1" value="<?php echo $row_incrementalGoals['day1']; ?>" size="2" />
              </span></td>
              <td width="40"><span id="sprytextfield2">
                <label for="day2"></label>
                <input name="day2" type="text" id="day2" value="<?php echo $row_incrementalGoals['day2']; ?>" size="2" />
              </span></td>
              <td width="40"><span id="sprytextfield3">
                <label for="day3"></label>
                <input name="day3" type="text" id="day3" value="<?php echo $row_incrementalGoals['day3']; ?>" size="2" />
              </span></td>
              <td width="40"><span id="sprytextfield4">
                <label for="day4"></label>
                <input name="day4" type="text" id="day4" value="<?php echo $row_incrementalGoals['day4']; ?>" size="2" />
              </span></td>
              <td width="40"><span id="sprytextfield5">
                <label for="day5"></label>
                <input name="day5" type="text" id="day5" value="<?php echo $row_incrementalGoals['day5']; ?>" size="2" />
              </span></td>
              <td width="40"><span id="sprytextfield6">
                <label for="day6"></label>
                <input name="day6" type="text" id="day6" value="<?php echo $row_incrementalGoals['day6']; ?>" size="2" />
              </span></td>
              <td width="40"><span id="sprytextfield7">
                <label for="day7"></label>
                <input name="day7" type="text" id="day7" value="<?php echo $row_incrementalGoals['day7']; ?>" size="2" />
              </span></td>
              <td width="80"><p>
              <?php 
			$maxScore = $row_incrementalGoals['stated_daily_max']*$row_incrementalGoals['stated_frequency'];
			$attainedScore = $row_incrementalGoals['day1']+
								$row_incrementalGoals['day2']+
								$row_incrementalGoals['day3']+
								$row_incrementalGoals['day4']+
								$row_incrementalGoals['day5']+
								$row_incrementalGoals['day6']+
								$row_incrementalGoals['day7'];
								
			echo ($attainedScore/$maxScore)*100;
			echo "%";
			
			 ?>
                <input name="iGoalID1" type="hidden" id="iGoalID1" value="<?php echo $row_incrementalGoals['assigned_goal'];
				 ?>" />
                  <input name="iPaitentID1" type="hidden" id="iPaitentID1" value="<?php echo $row_incrementalGoals['paitent']; ?>" />
                  </p>
                <p>
                  <input type="submit" name="button" id="button" value="Update" />
              </p></td>
              <input type="hidden" name="MM_update" value="form" />
            </form>
            </tr>
            <?php } while ($row_incrementalGoals = mysql_fetch_assoc($incrementalGoals)); ?>
        </table>
        <p>&nbsp;</p>
        <h2>Decremental Goals</h2>
        <table class="" width="100%" border="1" cellspacing="1" cellpadding="1">
          <tr>
            <th scope="col">Goal</th>
            <th width="40" scope="col">Sat</th>
            <th width="40" scope="col">Sun</th>
            <th width="40" scope="col">Mon</th>
            <th width="40" scope="col">Tue</th>
            <th width="40" scope="col">Wed</th>
            <th width="40" scope="col">Thu</th>
            <th width="40" scope="col">Fri</th>
            <th width="80" scope="col">Total</th>
          </tr>
          <?php do { ?>
          <tr>
            <form action="<?php echo $editFormAction; ?>" method="post" name="form" id="form">
              <th scope="row"><p><?php echo $row_decrementalGoals['goal_name']; ?></p>
                <table class="weeklyViewStatedMaxTable" width="100%" border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td>Total Max.</td>
                    <td><label for="textfield3"></label>
                      <input name="textfield3" type="text" disabled="disabled" id="textfield3" value="<?php echo $row_decrementalGoals['daily_max']; ?>" size="2" /></td>
                  </tr>
                  <tr>
                    <td>Freq.</td>
                    <td><label for="textfield4"></label>
                      <input name="textfield3" type="text" disabled="disabled" id="textfield4" value="<?php echo $row_decrementalGoals['stated_frequency']; ?>" size="1" /></td>
                    <td><img src="../images/edit.jpg" width="25" height="25" alt="edit" /></td>
                  </tr>
                </table></th>
              <td width="40"><label for="day8"></label>
                <input name="day8" type="text" id="day8" value="<?php echo $row_decrementalGoals['day1']; ?>" size="2" /></td>
              <td width="40"><label for="day9"></label>
                <input name="day8" type="text" id="day9" value="<?php echo $row_decrementalGoals['day2']; ?>" size="2" /></td>
              <td width="40"><label for="day10"></label>
                <input name="day8" type="text" id="day10" value="<?php echo $row_decrementalGoals['day3']; ?>" size="2" /></td>
              <td width="40"><label for="day11"></label>
                <input name="day8" type="text" id="day11" value="<?php echo $row_decrementalGoals['day4']; ?>" size="2" /></td>
              <td width="40"><label for="day12"></label>
                <input name="day8" type="text" id="day12" value="<?php echo $row_decrementalGoals['day5']; ?>" size="2" /></td>
              <td width="40"><label for="day13"></label>
                <input name="day8" type="text" id="day13" value="<?php echo $row_decrementalGoals['day6']; ?>" size="2" /></td>
              <td width="40"><label for="day14"></label>
                <input name="day8" type="text" id="day14" value="<?php echo $row_decrementalGoals['day7']; ?>" size="2" /></td>
              <td width="80"><p>
                <?php 
			$maxScore = $row_decrementalGoals['stated_daily_max']*$row_decrementalGoals['stated_frequency'];
			$attainedScore = $row_decrementalGoals['day1']+
								$row_decrementalGoals['day2']+
								$row_decrementalGoals['day3']+
								$row_decrementalGoals['day4']+
								$row_decrementalGoals['day5']+
								$row_decrementalGoals['day6']+
								$row_decrementalGoals['day7'];
								
			echo (($maxScore-$attainedScore)/$maxScore)*100;
			echo "%";
			
			 ?><input name="iGoalID2" type="hidden" id="iGoalID2" value="<?php echo $row_decrementalGoals['assigned_goal']; ?>" />
                  <input name="iPaitentID2" type="hidden" id="iPaitentID2" value="<?php echo $row_decrementalGoals['paitent']; ?>" />
                </p>
                <p>
                  <input type="submit" name="button2" id="button2" value="Update" />
              </p></td>
              <input type="hidden" name="MM_update2" value="form" />
            </form>
          </tr>
          <?php } while ($row_decrementalGoals = mysql_fetch_assoc($decrementalGoals)); ?>
        </table>
      </div>
    </div>
    <p>&nbsp;</p>
    <script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "integer", {minValue:0});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2", "integer", {minValue:0});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytextfield3", "integer", {minValue:0});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytextfield4", "integer", {minValue:0});
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytextfield5", "integer", {minValue:0});
var sprytextfield6 = new Spry.Widget.ValidationTextField("sprytextfield6", "integer", {minValue:0});
var sprytextfield7 = new Spry.Widget.ValidationTextField("sprytextfield7", "integer", {minValue:0});
    </script>
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

mysql_free_result($incrementalGoals);

mysql_free_result($decrementalGoals);
?>
