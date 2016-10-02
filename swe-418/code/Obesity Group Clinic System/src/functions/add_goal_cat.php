<?php

 /*
 * FILE NAME: add_goal_cat.php
 * FILE DESCRIPTION: Used to add a goal category to the database.
 * AUTHOR: Abdulaziz Alamoudi
 * LAST EDIT: Dec 17, 2011
 * LAST TESTED: Dec 17, 2011
 * Users: OGCT Member
 * Input:category name and category description.
 * returns 1 if the category was added, -1 if a field is empty, -2 if the category already exists,  
 * -3 if there was a failure to add the category.
 */
  //require "t_config.php" page to get the database t_configuration
require_once("t_config.php");
// echo("adding");
  function add_goal_cat($category_name, $category_description){
     
   global $conn,$database_conn;
   //hardcode deleted flag to zero
   $deleted_flag = 0;
	
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   //Check parameters...
   $category_name = htmlentities(mysqli_real_escape_string($conn,$category_name));

   //check if one of the required fields was empty
   if($category_name == NULL || $category_description == NULL){
    return(array(-1, NULL));
   }

   //check for duplications
   $check_duplicate = checkForCatgryDuplication($category_name);

   if($check_duplicate == -2){
	 return(array(-2, NULL));
   }

   //Insert statement
   $insert_stmt = "INSERT INTO CATEGORY (category_name, category_description, deleted_flag) VALUES " . 
   "('$category_name', '$category_description', '$deleted_flag')";
   
   //SQL query
   $query = mysqli_query($conn, $insert_stmt); 
   //check if the query 
   if (!$query){//failure
    return(array(-3, NULL));
   }
   else{//successful
    return(array(1, NULL));
   }
  }
  
  function checkForCatgryDuplication($category_name){
	
   global $conn,$database_conn;
	
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   //get the category with the same name as the one to be added if exists
   $select_stmt = "SELECT category_name FROM category where category_name = '$category_name'";
   //query statement
   $get_cat_name = mysqli_query($conn, $select_stmt);
   //check for duplications
   if(mysqli_fetch_array($get_cat_name) != NULL){  
    return -2;			
   }
   return 1;
  }
   
   

  
 ?>