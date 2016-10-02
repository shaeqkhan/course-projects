
<?php

 /*
 * FILE NAME: remove_goal_from_patient.php
 * FILE DESCRIPTION: Used to set the current_flag of a certain patient goal to either 1(current) 
 * or 0 (not current)
 * AUTHOR: Abdulaziz Alamoudi
 * LAST EDIT: Dec 15, 2011
 * LAST TESTED: Dec 15, 2011
 *Users: 
 *Input:assign id.
 *returns 1 if the current flag was set successfully, -1 if a field is empty, -2 if no such data exists,
 *-3 if a failure occured when deleting a patient goal.
 */
  
  require_once("/functions/t_config.php");
  
  function remove_patient_goal($assigned_id){

   global $conn,$database_conn;
   
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   //Check parameters...
   $assigned_id = htmlentities(mysqli_real_escape_string($conn,$assigned_id));   
   if($assigned_id == NULL){//no entry
    return (array(-1, NULL));
   }

   //Get the the current flag of the required patient goal.
   $get_flag = "SELECT assign_id, current_flag FROM patient_goals WHERE assign_id = '$assigned_id'";
   //SQL query result            
   $query = mysqli_query($conn, $get_flag);
   
   //get the required row
   $flag = mysqli_fetch_array($query);
   if($flag['assign_id'] == NULL){//no such record exists
    return array(-2, NULL);
   }
   
   //If the current_flag == 1 then set it to 0, else set it to 1.
   if($flag['current_flag'] == "1"){
    $update_flag = "UPDATE patient_goals SET current_flag = '0' WHERE assign_id = '$assigned_id'";   
   }
   
   elseif($flag['current_flag'] == "0")
   {
    return array(-4, null);
    
   }
   
   /*else{
    $update_flag = "UPDATE patient_goals SET current_flag = '1' WHERE assign_id = '$assigned_id'";   
    //The statement below sets category ID from the Goal table to NULL, since the category is deleted.
    //$update_cat_id = "UPDATE GOAL SET goal_category_id = NULL WHERE goal_category_id = '$category_id'";
    //mysqli_query($conn, $update_cat_id);
   }*/

   //update the active flag
   $update_query = mysqli_query($conn, $update_flag);
   if(!$update_query){//failure
    return (array(-3, NULL));
   }
   else{//successful
    return (array(1, NULL));
   } 
  }
  
 ?>


