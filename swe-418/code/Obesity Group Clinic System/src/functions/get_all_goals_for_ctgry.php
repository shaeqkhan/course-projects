<?php

 //created by Abdulaziz Alamoudi

 require_once("functions/t_config.php");

 //require_once("../functions/t_config.php");

 //the following function gets all goals that belong to the category with the gived ctgry_id
 function getAllGoalsForCtgry($ctgry_id){

	 global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $select_stmt = "SELECT * FROM goal " . 
	                "WHERE goal_category_id = $ctgry_id AND deleted_flag = 0";
	 
	 $query = mysqli_query($conn, $select_stmt);
	 if(!$query){
	  return(array(-1, NULL));	 
	 }
	 
	 if(mysqli_num_rows($query) == 0){
	  return(array(-2, NULL));	 		 
	 }
	 
	 //the following was used for testing purposes
	 /*							
	 echo"<table border='1'>";
	 echo"<tr>";
	 echo"<th>goal_id</th>";
	 echo"<th>goal_name</th>";
	 echo"<th>goal_description</th>";
	 echo"<th>goal_type</th>";
	 echo"<th>goal_category_id</th>";
	 echo"<th>min_point_on_scale</th>";
	 echo"<th>max_point_on_scale</th>";
	 echo"</tr>";
	 while($fetched_goals = mysqli_fetch_assoc($query)){
		 echo"<tr>";
		 echo"<td>" . $fetched_goals['goal_id'] . "</td>";
		 echo"<td>" . $fetched_goals['goal_name'] . "</td>";
		 echo"<td>" . $fetched_goals['goal_description'] . "</td>";
		 echo"<td>" . $fetched_goals['goal_type'] . "</td>";
		 echo"<td>" . $fetched_goals['goal_category_id'] . "</td>";
		 echo"<td>" . $fetched_goals['min_point_on_scale'] . "</td>";
		 echo"<td>" . $fetched_goals['max_point_on_scale'] . "</td>";
		 echo"</tr>";
	 }
	 echo"</table>";
	 */
	 return(array(1, $query));
	 									
 }
 
  //getAllGoalsForCtgry(1);
  //get the category information with the provided category ID
 function getCategoryInfoById($ctgry_id){
  	 
	 global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);  
	 
	 $select_stmt = "SELECT category_name, category_description FROM category WHERE category_id = '$ctgry_id' AND deleted_flag = 0";
	 $query = mysqli_query($conn, $select_stmt);
	 
	 return($query);

 }
 
 //get the number of patients assigned to a certain goal
 function getNumOfPatients($goal_id){
	 global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);  
	 
	 $select_stmt = "SELECT DISTINCT patient_id FROM patient_goals WHERE goal_id = $goal_id AND current_flag = 1";
	 $query = mysqli_query($conn, $select_stmt);
	 
	 return(mysqli_num_rows($query));
 }

?>