<?php
 //created by Abdulaziz Alamoudi

require_once("t_config.php");

 //this functions gets all categories
 function getGoalCatgry(){
	 
  	 global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $select_stmt = "SELECT category_id, category_name, category_description FROM category WHERE deleted_flag = 0";
	 $query = mysqli_query($conn, $select_stmt);
	 
	 if(!$query){
	  return(array(-1, NULL));	 
	 }
	 
	 if(mysqli_num_rows($query) == 0){
	  return(array(-2, NULL));
	 }
	 
	 //$array = mysqli_fetch_array($query);
	 
	 return array(1, $query);
	 
 }
 
 //this function counts how many goals belong to a certain category
 function countCatgryGoals($ctgry_id){
	 
	 global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);  
	 
	 $select_stmt = "SELECT goal_id FROM goal WHERE goal_category_id = '$ctgry_id' AND 	deleted_flag = 0";
	 $query = mysqli_query($conn, $select_stmt);
	 
	 return(mysqli_num_rows($query));
 }

?>
