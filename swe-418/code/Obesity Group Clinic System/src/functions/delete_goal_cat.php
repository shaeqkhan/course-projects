
<?php

 /*
 * FILE NAME: delete_goal_cat.php
 * FILE DESCRIPTION: Used to set the deleted_flag of a certain category to either 0(not deleted) 
 * or 1 (deleted) and then set the 
 * category id in the Goal table to NULL if the category flag was set to one, i.e. deleted.
 * AUTHOR: Abdulaziz Alamoudi
 * LAST EDIT: Nov 15, 2011
 * LAST TESTED: Nov 21, 2011
 *Users: 
 *Input:category id.
 *returns 1 if the deleted flag was set successfully, -1 if a field is empty, -2 if no such category exists,
 *-3 if a failure occured when deleting a category.
 */
  
  
require_once("t_config.php");
  
  delete_goal_cat($_GET['id']);
 
  function delete_goal_cat($category_id){

   global $conn,$database_conn;
   
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   //Check parameters...
   $category_id = htmlentities(mysqli_real_escape_string($conn,$category_id));   
   if($category_id == NULL){//no entry
    return(array(-1, NULL));
   }

   //check if the category exist
   $check_catgry_not_exist = checkIfCatgryNotExist($category_id);
   if($check_catgry_not_exist == -2){//no such record exists
    return(array(-2, NULL));
   }
   
   //If the deleted_flag == 1 then set it to 0, else set it to 1.
   //if($flag['deleted_flag'] == "1"){
    //$update_flag = "UPDATE CATEGORY SET deleted_flag = '0' WHERE category_id = '$category_id'";   
  // }
   //else{
    $update_flag = "UPDATE CATEGORY SET deleted_flag = '1' WHERE category_id = '$category_id'";
       
    //The statement below sets category ID from the Goal table to NULL, since the category is deleted.
    $update_cat_id = "UPDATE GOAL SET goal_category_id = NULL WHERE goal_category_id = '$category_id'";
    mysqli_query($conn, $update_cat_id);
   //}

   //update the active flag
   $update_query = mysqli_query($conn, $update_flag);
   if(!$update_query){//failure
    return(array(-3, NULL));
   }
   else{//successful
    return(array(1, NULL));
   } 
  }
  
  function checkIfCatgryNotExist($category_id){
	  
   global $conn,$database_conn;
   
   //select the required database
   mysqli_select_db($conn, $database_conn);  
	  
   //Get the the deleted flag of the required group.
   $get_flag = "SELECT category_id, deleted_flag FROM CATEGORY WHERE category_id = '$category_id'";
   //SQL query result            
   $query = mysqli_query($conn, $get_flag);
   
   //get the required row
   $flag = mysqli_fetch_array($query);
   if($flag['category_id'] == NULL){//no such record exists
    return -2;
   }

   return 1;  
  }
  
 ?>

