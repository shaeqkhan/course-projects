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
  $insertSQL = sprintf("INSERT INTO account (username, aramco_id, email, fname, lname, gender, password, phone, type_flag) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)",
                       GetSQLValueString($_POST['username'], "text"),
                       GetSQLValueString($_POST['aramco_id'], "text"),
                       GetSQLValueString($_POST['email'], "text"),
                       GetSQLValueString($_POST['fname'], "text"),
                       GetSQLValueString($_POST['lname'], "text"),
                       GetSQLValueString($_POST['gender'], "text"),
                       GetSQLValueString(md5($_POST['password']), "text"),
                       GetSQLValueString($_POST['phone'], "text"),
                       GetSQLValueString($_POST['type'], "int"));

  mysql_select_db($database_conn, $conn);
  $Result1 = mysql_query($insertSQL, $conn) or die(mysql_error());
}

if ((isset($_POST["MM_insert"])) && ($_POST["MM_insert"] == "form1")) {
  $insertSQL = sprintf("INSERT INTO paitent (username, address, weight, height, doe, dperc, status) VALUES (%s, %s, %s, %s, %s, %s, %s)",
                       GetSQLValueString($_POST['username'], "text"),
                       GetSQLValueString($_POST['address'], "text"),
                       GetSQLValueString($_POST['weight'], "int"),
                       GetSQLValueString($_POST['height'], "int"),
                       GetSQLValueString($_POST['doe'], "date"),
                       GetSQLValueString($_POST['dperc'], "double"),
                       GetSQLValueString($_POST['status'], "int"));

  mysql_select_db($database_conn, $conn);
  $Result1 = mysql_query($insertSQL, $conn) or die(mysql_error());

  $insertGoTo = "registerPatient.php?opCode=added";
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
<script src="../SpryAssets/SpryValidationRadio.js" type="text/javascript"></script>
<script src="../SpryAssets/SpryValidationConfirm.js" type="text/javascript"></script>
<script src="../SpryAssets/SpryValidationPassword.js" type="text/javascript"></script>
<script src="../SpryAssets/SpryValidationTextarea.js" type="text/javascript"></script>
<link href="../SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css" />
<link href="../SpryAssets/SpryValidationRadio.css" rel="stylesheet" type="text/css" />
<link href="../SpryAssets/SpryValidationConfirm.css" rel="stylesheet" type="text/css" />
<link href="../SpryAssets/SpryValidationPassword.css" rel="stylesheet" type="text/css" />
<link href="../SpryAssets/SpryValidationTextarea.css" rel="stylesheet" type="text/css" />
<script src="../scripts/jquery.js" type="text/javascript" language="javascript"></script>
<script language="javascript" src="../scripts/checkUsername.js"></script>
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
  
    <!-- InstanceBeginEditable name="content" --> <div class="contentTitle">
      <h1>Register Patient</h1>
</div>
<div class="contentHolder">
							<?php
								if(isset($_GET['opCode'])){
									echo "<p class='contentHolderText'><span class='success'><img src='../images/check.jpg' width='20' height='20' />Patient has been added successfully!</span></p>";
								}
							?>
                            
  <p class="contentHolderText">Please fill the form below to register new patient to the system. (<span class="mandatoryField">*</span>: mandatory field).</p>
  <form id="form1" name="form1" method="POST" action="<?php echo $editFormAction; ?>">
    <h2>Account Details</h2>
    <p><span id="sprytextfield1">
      <label for="username">Username:</label>
      <input type="text" name="username" id="username" />
      <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span><span id="msgbox"></span></p>
    <p><span id="sprypassword1">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" />
      <span class="passwordRequiredMsg">A value is required.</span></span> <span class="mandatoryField">*</span></p>
    <span id="spryconfirm1">
    <label for="confirmPassword">Retype Password: </label>
    <input type="password" name="confirmPassword" id="confirmPassword" />
    <span class="confirmRequiredMsg">A value is required.</span><span class="mandatoryField">*</span><span class="confirmInvalidMsg">The values don't match.</span></span>
    <p class="mandatoryField">&nbsp; </p>
    <h2>Personal Details</h2>
    <p><span id="sprytextfield2">
      <label for="fname">First name:</label>
      <input type="text" name="fname" id="fname" />
      <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
    <p><span id="sprytextfield3">
      <label for="lname">Last Name:
        <input type="text" name="lname" id="lname" />
      </label>
      <span class="textfieldRequiredMsg">A value is required.</span></span> <span class="mandatoryField">*</span></p>
    <p>
      <label for="aramco_id">Aramco ID: </label>
      <input type="text" name="aramco_id" id="aramco_id" />
    </p>
    <p><span id="sprytextfield5">
      <label for="email">Email: </label>
      <input type="text" name="email" id="email" />
      <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
    <p><span id="sprytextfield4">
      <label for="phone">Phone: </label>
      <input type="text" name="phone" id="phone" />
      <span class="textfieldRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
    <p>Gender: <span id="spryradio1">
      <label>
        <input type="radio" name="gender" value="m" id="gender_0" />
        Male<span class="mandatoryField">*</span></label>
      <label>
        <input type="radio" name="gender" value="f" id="gender_1" />
        Female</label>
      <span class="mandatoryField">*</span><br />
      <span class="radioRequiredMsg">Please make a selection.</span></span></p>
    <p>Date of Birth (dd-m
      
      m-yyyy):
<label for="day"></label>
      <span id="sprytextfield6">
        <label for="month"></label>
        <input name="day" type="text" id="day2" size="3" maxlength="2" />
      </span> -
      <label for="month"></label>
      <span id="sprytextfield7">
      <input name="month" type="text" id="day3" size="3" maxlength="2" />
      </span> -
      <label for="year"></label>
      <span id="sprytextfield8">
      <input name="year" type="text" id="day4" size="5" maxlength="4" />
      </span><span class="mandatoryField">*</span></p>
    <p>&nbsp;</p>
    <h2>Patient Details</h2>
    <p><span id="sprytextfield9">
    <label for="weight">Weight:</label>
    <input type="text" name="weight" id="weight" />
    KG
    <span class="textfieldRequiredMsg">A value is required.</span><span class="textfieldInvalidFormatMsg">Invalid format.</span><span class="textfieldMinValueMsg">The entered value is less than the minimum required.</span><span class="textfieldMaxValueMsg">The entered value is greater than the maximum allowed.</span></span><span class="mandatoryField">*</span>    </p>
    <p><span id="sprytextfield10">
      <label for="height">Height:</label>
    <input type="text" name="height" id="height" />
    CM
    <span class="textfieldRequiredMsg">A value is required.</span><span class="textfieldInvalidFormatMsg">Invalid format.</span><span class="textfieldMinValueMsg">The entered value is less than the minimum required.</span><span class="textfieldMaxValueMsg">The entered value is greater than the maximum allowed.</span></span><span class="mandatoryField">*</span></p>
    <p><span id="sprytextarea1">
      <label for="address">Address: </label>
      <textarea name="address" cols="30" id="address"></textarea>
      <span class="textareaRequiredMsg">A value is required.</span></span><span class="mandatoryField">*</span></p>
    <p>
      <input type="hidden" name="type" id="type" value="1" />
      <input type="hidden" name="dperc" id="dperc" value="0" />
      <input type="hidden" name="status" id="status" value="1" />
      <input type="hidden" name="doe" id="doe" value="<?php echo date('d-m-Y');?>" />
      <input type="submit" name="button" id="button" value="Submit" />
      <input type="reset" name="button2" id="button2" value="Reset" />
    </p>
    <input type="hidden" name="MM_insert" value="form1" />
  </form>
    </div>
  <p class="contentHolderText">&nbsp;</p>
    <script type="text/javascript">
var sprytextfield8 = new Spry.Widget.ValidationTextField("sprytextfield8", "integer", {minValue:1900, maxValue:2015});
var sprytextfield7 = new Spry.Widget.ValidationTextField("sprytextfield7", "integer", {minValue:1, maxValue:12});
var sprytextfield6 = new Spry.Widget.ValidationTextField("sprytextfield6", "integer", {minValue:1, maxValue:31});
var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytextfield4");
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytextfield5");
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytextfield3");
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2");
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
var spryconfirm1 = new Spry.Widget.ValidationConfirm("spryconfirm1", "password");
var sprypassword1 = new Spry.Widget.ValidationPassword("sprypassword1");
var sprytextfield9 = new Spry.Widget.ValidationTextField("sprytextfield9", "integer", {minValue:0, maxValue:999});
var sprytextfield10 = new Spry.Widget.ValidationTextField("sprytextfield10", "integer", {minValue:0, maxValue:999});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("sprytextarea1");
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
