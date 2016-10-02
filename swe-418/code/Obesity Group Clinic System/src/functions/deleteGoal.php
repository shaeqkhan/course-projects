 <?php
 /*
 * FILE NAME: delete_goal.php
 * FILE DESCRIPTION: Used to delete a goal from the database. The row is not deleted physically, rather its delete_flag is updated to 1.
 * AUTHOR: Yasir Al-Agl
 * LAST EDIT: Dec 22, 2011
 *
 *Users: 
 *Input: goal name and goal id.
 *returns -2 if the goal was not found, -1 if the goal was already deleted, -3 if an error occured while deleting and returns 1 if the delete was successful. It updates the current flag in pateient_goals table as well.
 */


	
	//importing the connection
require_once("t_config.php");
	require_once("checkDeletedGoal.php");
	
	//implementing the delete_goal function
	function deleteGoal($goal_id)
	{
		
		//checking to see if the goal exists or deleted before [from check_deleted_goal.php]
		$isGoalDeleted = checkDeletedGoal($goal_id);
		
		//returns -2 if the goal was not found or -1 if the goal was already deleted
		if($isGoalDeleted[0] < 0)
			return $isGoalDeleted;
			
		//globaling the link to the database and the database name
		global $conn, $database_conn;
		
		//selecting the database
		mysqli_select_db($conn, $database_conn);
		
		
		//query for updating the deleted_flag in goal table to 1 as a sign of deletion
		$update_flag = "UPDATE goal SET deleted_flag = 1 WHERE goal_id = $goal_id";
	
		//query for updating the current_flag in patient_goals table to 0. This step is needed due to cascading
		$patient_goal_deactivate = "UPDATE patient_goals SET current_flag = 0 WHERE goal_id = $goal_id";		
		
		
		//running the updating query
		$update_query = mysqli_query($conn, $update_flag);
		
		
		//error handling, returns -3 if an error occured while deleting the goal. This also means the patient_goals table will not be updated
		if(!$update_query)
		{
			return array(-3, null);
		}
		
		//return 1 and update patient_goals table
		else
		{
			//update the cascading patient_goal table and return 1
			mysqli_query($conn, $patient_goal_deactivate);
			return array(1, null);
		}
		
	}
?>


