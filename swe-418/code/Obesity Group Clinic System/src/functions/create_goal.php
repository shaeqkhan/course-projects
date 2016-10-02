
<?php


/*
 * create_goal php
 * add goal to the system
 * Aziz 
 * 14/11/2011 by Sameer
 */



require_once("t_config.php");


/*
 * add goal
 * add a goal  the OGC system
 * users:Admin (OGCT Memeber)
 * input: goal info
 * return 1 success
 * return -1 null info
 * return -2 cannot add goal 
 */
  
  
  function create_goal($goal_cat_id, $goal_name, $goal_desc, $goal_type, $min, $max){
  
  
    global $conn,$database_conn;
	$deleted_flag = 0;
   //Establoish connection with the database server and check if the connection is established or not.
   
   //select the required database
   mysqli_select_db( $conn,$database_conn);
   
   
   //checking parameters...
   $goal_name = htmlentities(mysqli_real_escape_string($conn,$goal_name));
   $goal_desc = htmlentities(mysqli_real_escape_string($conn,$goal_desc));
   $goal_type = htmlentities(mysqli_real_escape_string($conn,$goal_type));
   $min = htmlentities(mysqli_real_escape_string($conn,$min));
   $max = htmlentities(mysqli_real_escape_string($conn,$max));

 
   if($goal_cat_id==-1)
   {
	 $insert_stmt = "INSERT INTO GOAL (goal_name, goal_description, goal_type, min_point_on_scale, max_point_on_scale, deleted_flag) VALUES " .   "( '$goal_name', '$goal_desc', '$goal_type', $min, $max, '$deleted_flag')";
	  
   }
 
 
else {
   //Insert statement
   $insert_stmt = "INSERT INTO GOAL (goal_category_id, goal_name, goal_description, goal_type, min_point_on_scale, max_point_on_scale, deleted_flag) VALUES " .   "('$goal_cat_id', '$goal_name', '$goal_desc', '$goal_type', $min, $max, '$deleted_flag')";
}
  
   //SQL query
    $query = mysqli_query($conn,$insert_stmt);
    if (!$query){
     return array(-2,NULL);
    }
	
	return array(1,NULL);
  }
 ?>
