<?php

/*
 * t_configURATION FILE
 * Defines deployement options, customizations, and variables used by the OGCS
 *************************
 * Rakan Al Ghufaily
 * 20 NOVEMBER 2011
 * LAST TESTED: 20
 */
 
/*
 * DATABASE CONNECTION DETAILS
 */
$hostname_conn = "localhost";
$database_conn = "ogc";
$username_conn = "root";
$password_conn = "";
$conn = mysqli_connect($hostname_conn, $username_conn, $password_conn) or trigger_error(mysql_error(),E_USER_ERROR);


/*
 * SYSTEM RELATED VARIABLES - DON'T MESS WITH THESE!
 */

$today=date("Y-m-d");


/*
 * SYSTEM CUSTOMIZATION VARIABLES
 */
// The format to display the current date
$displayToday= date("D,j F Y");

// The name display format (0: FirstName LastName | 1: LastName, FirstName)
$nameDisplayFormat = 0;

?>