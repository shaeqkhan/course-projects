<?php
    
/*
 * FILE NAME: getPastGoals.php
 * FILE DESCRIPTION: Used to get past goals of the patient.
 * AUTHOR: Yasir Al-Agl
 * LAST EDIT: New Year's EVE, 2011; 1/1/2012 <== This function is so lucky born on the first day of new year
 *
 *Users: 
 *Input: N/A.
 *returns (1, list of patient's past goals) OR (-2, null) if no PAST goals were found in the database OR (-1, null) if there was an error with the connection
 */

require_once("t_config.php");
        
        function getPastGoals($patient_id)
        {
            		
		//globaling the link to the database and the database name
		global $conn, $database_conn;
		
		
		//selecting the database
		mysqli_select_db($conn, $database_conn);
                
                $get_past_goal = "SELECT patient_goals.goal_id, patient_goals.date_assigned, DATE_FORMAT(time_stamp,'%Y-%m-%d') AS time_stamp, patient_goals.assign_id, goal.goal_name AS goal_name FROM patient_goals, goal WHERE patient_id = $patient_id AND goal.goal_id = patient_goals.goal_id AND patient_goals.current_flag = 0";
                
                $get_past_goals_query = mysqli_query($conn, $get_past_goal);
                
                if(!$get_past_goals_query)
		{
			return array(-1, null);
		}
                
                //no past goals
                if(mysqli_num_rows($get_past_goals_query) == 0)
                {
                    return array(-2, null);
                }
                
                return array(1, $get_past_goals_query);
        }

        
?>