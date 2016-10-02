<?php
/*
 * FILE NAME: UpdatePatientGoal.php
 * FILE DESCRIPTION: Used to update the goal assigned to a patient
 * AUTHOR: Yasir Al-Agl
 * LAST EDIT: Dec 22, 2011
 *
 *Users: 
 *Input: N/A.
 *returns 1 if the update operation was successful OR -1 if it's failed.
 */
 
 		//requiring the connection
		require_once("/functions/t_config.php");
		
		//implmenting the function
		function updatePateintGoal($assign_id, $frequency, $stated_daily_max)
		{
			//globaling the connection
			global $conn, $database_conn;
			
			//selecting the database
			mysqli_select_db($conn, $database_conn);
			
			//query for updating the patient goal...$goalid, $patientid, $frequency, $stdlymax, $currflg
			$update_patient_goal = "UPDATE patient_goals SET frequency = $frequency, stated_daily_max = $stated_daily_max, current_flag = 1 WHERE assign_id = $assign_id";
			
			//running the query
			$update_patient_goal_qury = mysqli_query($conn, $update_patient_goal);
			
			//error handling. return -1 if the update query failed
			if(!$update_patient_goal_qury)
			{
				return array(-1, null);
			}
			
			return array(1, null);
		}
 ?>