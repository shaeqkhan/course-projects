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

if ((isset($_POST["MM_insert"])) && ($_POST["MM_insert"] == "form1")) {
  $insertSQL = sprintf("INSERT INTO goal (goal_creator, goal_name, `description`, doc, daily_max, frequency, type, deleted_flag) VALUES (%s, %s, %s, %s, %s, %s, %s, %s)",
                       GetSQLValueString($_POST['goal_creator'], "text"),
                       GetSQLValueString($_POST['goal_name'], "text"),
                       GetSQLValueString($_POST['description'], "text"),
                       GetSQLValueString($_POST['doc'], "date"),
                       GetSQLValueString($_POST['daily_max'], "int"),
                       GetSQLValueString($_POST['frequency'], "int"),
                       GetSQLValueString($_POST['type'], "int"),
                       GetSQLValueString($_POST['deleted_flag'], "int"));

  mysql_select_db($database_conn, $conn);
  $Result1 = mysql_query($insertSQL, $conn) or die(mysql_error());

  $insertGoTo = "goalAdded.php";
  if (isset($_SERVER['QUERY_STRING'])) {
    $insertGoTo .= (strpos($insertGoTo, '?')) ? "&" : "?";
    $insertGoTo .= $_SERVER['QUERY_STRING'];
  }
  header(sprintf("Location: %s", $insertGoTo));
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
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/DoctorPanel.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Aramco OGC System</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<script src="../SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<script src="../SpryAssets/SpryValidationTextarea.js" type="text/javascript"></script>
<script src="../SpryAssets/SpryValidationRadio.js" type="text/javascript"></script>
<link href="../SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css" />
<link href="../SpryAssets/SpryValidationTextarea.css" rel="stylesheet" type="text/css" />
<link href="../SpryAssets/SpryValidationRadio.css" rel="stylesheet" type="text/css" />
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
      <h1>Add Goal</h1>
    </div>
    <div class="contentHolder">
      <p class="contentHolderText">Please fill the form below to add a new goal. (<span class="mandatoryField">*</span>: mandatory field).</p>
      <form class="form" id="form1" name="form1" method="POST" action="<?php echo $editFormAction; ?>">
        <h2>Goal Details</h2>
        <p><span id="sprytextfield1">
          <label for="goal_name">Goal Name:</label>
          <input type="text" name="goal_name" id="goal_name" />
        <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
        <p><span id="sprytextarea1">
          <label for="description">Description:</label>
          <textarea name="description" id="description" cols="30" rows="3"></textarea>
        <span class="textareaRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
        <p><span id="sprytextfield2">
          <label for="daily_max">Daily Max:</label>
          <input type="text" name="daily_max" id="daily_max" />
        <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
        <p><span id="sprytextfield3">
          <label for="frequency">Maximum Frequency:</label>
          <input type="text" name="frequency" id="frequency" />
        <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
        <div id="spryradio1">
          <table width="300">
            <tr>
            <td>
            Type:
            </td>
              <td><label>
                <input type="radio" name="type" value="1" id="type_0" />
                Incremental<span class="mandatoryField">*</span></label></td>
            </tr>
            <tr>
            <td>
            </td>
              <td><label>
                <input type="radio" name="type" value="-1" id="type_1" />
                Decremental<span class="mandatoryField">*</span></label></td>
            </tr>
          </table>
        </div>
        <p>
          <input name="goal_creator" type="hidden" id="goal_creator" value="<?php echo $_SESSION['MM_Username']; ?>" />
          <input name="doc" type="hidden" id="doc" value="<?php echo date('d-m-Y'); ?>" />
          <input name="deleted_flag" type="hidden" id="deleted_flag" value="0" />
          <input type="submit" name="submit" id="submit" value="Submit" />
          <input type="reset" name="reset" id="reset" value="Reset" />
        </p>
        <input type="hidden" name="MM_insert" value="form1" />
      </form>
      <p class="contentHolderText">&nbsp;</p>
    </div>
    <script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
var sprytextarea1 = new Spry.Widget.ValidationTextarea("sprytextarea1");
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2");
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytextfield3");
var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
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
?>
