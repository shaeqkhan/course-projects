<?php
require_once("t_config.php");

//-1 = all
//0 active only
//1 not active only
function getAssignedGoalDetails($assign_id,$current_flag=-1){
	global $conn,$database_conn;
	
	mysqli_select_db($conn,$database_conn);
	
	$query = "SELECT * FROM patient_goals pg ,goal g WHERE g.goal_id = pg.goal_id AND pg.assign_id = $assign_id and pg.current_flag != $current_flag";
	$result = mysqli_query($conn,$query);
	if($result){
		return array(1,$result);
	}
	return array(-1,NULL);
	
}

?>