<?php

/*
 * FILE NAME: check_deleted_goal.php
 * FILE DESCRIPTION: used to check if the goal doesn't exist or has a deleted_flag of 1
 * AUTHOR: Yasir Al-Agl
 * LAST EDIT: Dec 22, 2011
 *
 *Users: 
 *Input: N/A.
 *returns -2 if the goal was not found OR -1 if the goals has a deleted flag of 1
 **/

	//importing the connection
	require_once("t_config.php");

	function checkDeletedGoal($goal_id)
	{
		//globaling the link to the database and the database name
		global $conn, $database_conn;
		
		//selecting the database
		mysqli_select_db($conn, $database_conn);
		
		//query to look up the desired goal
		$search_desired_goal = "SELECT deleted_flag FROM goal WHERE goal_id = $goal_id";
		
		//running the query 
		$search_desired_goal_query = mysqli_query($conn, $search_desired_goal);
		
		//error handling, returns -2 if the goal was not found
		if(!$search_desired_goal_query)
		{
			return array(-2, null);
		}
		
		//storing the result in an array
		$result = mysqli_fetch_array($search_desired_goal_query);
		
		//checking to see if the goal was previuosly there but got deleted, returns -1 if the goal was previuosly deleted
		if($result['deleted_flag'] == 1)
		{
			return array(-1, null);
		}
		
		
		return array(1, null);
	}
?>