<?php require_once('../Connections/conn.php'); ?>
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

$colname_usernames = "-1";
if (isset($_POST['user_name'])) {
  $colname_usernames = $_POST['user_name'];
}
mysql_select_db($database_conn, $conn);
$query_usernames = sprintf("SELECT username FROM `user` WHERE username = %s", GetSQLValueString($colname_usernames, "text"));
$usernames = mysql_query($query_usernames, $conn) or die(mysql_error());
$row_usernames = mysql_fetch_assoc($usernames);
$totalRows_usernames = mysql_num_rows($usernames);

//  Developed by Roshan Bhattarai 
//  Visit http://roshanbh.com.np for this script and more.
//  This notice MUST stay intact for legal use

//this varible contains the array of existing users

//$existing_users=array('roshan','mike','jason'); 
//value got from the get metho
//checking weather user exists or not in $existing_users array

if ($totalRows_usernames==1)
{
	//user name is not availble
	echo "no";
} 
else
{
	//user name is available
	echo "yes";
}

mysql_free_result($usernames);
?>