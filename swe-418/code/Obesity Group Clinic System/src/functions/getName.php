<?php

require_once("t_config.php");
 
 function getPatientName($id){
	 
     global $conn,$database_conn;
	 
     mysqli_select_db($conn, $database_conn);
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));   
	 
	 $select_stmt = "SELECT first_name, last_name FROM account_details WHERE id = $id";
	 $query = mysqli_query($conn, $select_stmt);
	 $rtrn_array = mysqli_fetch_assoc($query);
	 $name = $rtrn_array['first_name'] . " " . $rtrn_array['last_name'];
	 	 
	 return($name);

 }

?>