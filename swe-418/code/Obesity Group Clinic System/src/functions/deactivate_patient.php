<?php


require_once("t_config.php");

function deactivatePatient($id)
	{
		global $conn, $database_conn;
		
		mysqli_select_db($conn, $database_conn);
		
		
		
		$update_statment = "UPDATE account_details SET active_flag = 0 WHERE id = $id AND active_flag = 1";

		
		$update_statment_query = mysqli_query($conn, $update_statment);
		
		if(!$update_statment_query)
		{
			return -1;
		}
		else return 1;
	}
?>