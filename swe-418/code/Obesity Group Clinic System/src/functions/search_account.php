
<?php

 require_once("/functions/t_config.php");

 

 function search_patient($first_name, $last_name, $email, $mobile_number)
 {
  
	 global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $first_name = htmlentities(mysqli_real_escape_string($conn,$first_name));
	 $last_name = htmlentities(mysqli_real_escape_string($conn,$last_name));
	 $email = htmlentities(mysqli_real_escape_string($conn,$email));
	 

	 $select_stmt = "SELECT id, CONCAT(first_name,' ',last_name) AS name, email, type_flag FROM account_details WHERE first_name LIKE '%$first_name%' AND last_name LIKE '%$last_name%' AND email LIKE '%$email%' AND mobile_number LIKE '%$mobile_number%'";
	 //die($select_stmt);
	 $query = mysqli_query($conn, $select_stmt);

	 
	 if(mysqli_num_rows($query)==0)
	 {
	   return array(-1, null);
	 }
	 return array(1, $query);
 }  

?>