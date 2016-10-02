<?php
 /*
 * FILE NAME: view_all_goals.php
 * FILE DESCRIPTION: Used to view all goals in the database.
 * AUTHOR: Yasir Al-Agl
 * LAST EDIT: Dec 27, 2011
 *
 *Users: 
 *Input: N/A.
 *returns (1, list of goals as an array) OR (-1, null) if no goals were found in the database OR (-2, null) if no goals exist in the database
 */
 
 
	//importing the connection
require_once("t_config.php");
	
	function getSpecificGoalDetails($goal_id)
	{
		
		//globaling the link to the database and the database name
		global $conn, $database_conn;
		
		
		//selecting the database
		mysqli_select_db($conn, $database_conn);
		
		
		//query to look up and select all goals
		$view_all_goals = "SELECT goal . * , category.category_name, category.category_id FROM goal LEFT JOIN category ON goal.goal_category_id = category.category_id WHERE goal.deleted_flag = 0 AND goal_id = $goal_id";
		
		
		//running the query
		$view_all_goals_query = mysqli_query($conn, $view_all_goals);
		
		
		//error handling. returns -1 if no goals exists in the database
		if(!$view_all_goals_query)
		{
			return array(-1, null);
		}
		
		if(mysqli_num_rows($view_all_goals_query) == 0)
		{
			return array(-2, null);
		}
		
	
		
		//returning the array
		return array(1, $view_all_goals_query);
	}
 
?>

