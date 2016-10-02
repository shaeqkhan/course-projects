<?php


require_once "t_config.php";


function checkActivationOfPatient($id)
	{
		global $conn, $database_conn;
		
		mysqli_select_db($conn, $database_conn);

		$select_statment = "SELECT active_flag FROM account_details WHERE id = $id";

		$select_statment_query = mysqli_query($conn, $select_statment);
		$checking_result = mysqli_fetch_array($select_statment_query);
	
		if($checking_result['active_flag'] == 0)
		{
			return -1;
		}
		elseif($checking_result['active_flag'] == 1)
		{
			return 1;
		}
		
	}
		
		?>