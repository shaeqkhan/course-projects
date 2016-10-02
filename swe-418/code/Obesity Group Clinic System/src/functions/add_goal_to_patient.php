<?php

 /*
 * FILE NAME: add_goal_to_patient.php
 * FILE DESCRIPTION: Used to assign a goal to a patient.
 * AUTHOR: Abdulaziz Alamoudi
 * LAST EDIT: Nov 18, 2011
 * LAST TESTED: Nov 22, 2011 
 *Users: 
 *Input:goal id, patient id, frequency, stated daily max.
 *returns 1 if the goal was assigned, -1 is a field is empty, -2 if the goal doesn't exist or
 * if the goal to be assigned was deleted, 
 *-3 if the patient doesn't exist or was deleted, -4 if the goal is already assigned to the patient, 
 *-5 for failure to assign the goal.
 */
  
require_once("t_config.php");
 
  function add_goal_to_patient($goalid, $patientid, $frequency, $stdlymax, $currflg){
     
   global $conn,$database_conn;
   $currflg = 1;
   
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   //Check parameters...
   $goalid = htmlentities(mysqli_real_escape_string($conn,$goalid));
   $patientid = htmlentities(mysqli_real_escape_string($conn,$patientid));
   $frequency = htmlentities(mysqli_real_escape_string($conn,$frequency));
   $stdlymax = htmlentities(mysqli_real_escape_string($conn,$stdlymax));
   $currflg = htmlentities(mysqli_real_escape_string($conn,$currflg));

   if($goalid == NULL || $patientid == NULL || $frequency == NULL || 
   $stdlymax == NULL || $currflg == NULL){//no entry in one of the fields
    return(array(-1, NULL));
   }
      
   //check if the goal exists
   $check_goal = checkIfGoalExist($goalid);
   if($check_goal == -2){//no such goal exists
    return(array(-2, NULL));
   }

   //check if the patient exists
   //$get_patient = "SELECT id, active_flag FROM account_details WHERE id = '$patientid' AND type_flag = 2";
   //$query = mysqli_query($conn, $get_patient);
   //get the required row   
   //$patient = mysqli_fetch_array($query);
   $check_patient = checkIfPatientExist($patientid);
   if($check_patient == -3){//no such patient exists
    return(array(-3, NULL));
   }
   
   //check if the goal is already assignend
	$check_goal_assigned = checkIfGoalAssigned($patientid, $goalid);   
    if($check_goal_assigned == -4){//check for duplications, if the goal is already assigned
     return(array(-4, NULL));
    }
   
   //Insert statement
   $insert_stmt = "INSERT INTO patient_goals (goal_id, patient_id, frequency, stated_daily_max, current_flag,date_assigned) VALUES " . 
   "($goalid, $patientid, $frequency, $stdlymax, '$currflg',CURRENT_TIMESTAMP)";
   
   //SQL query
   $query = mysqli_query($conn, $insert_stmt); 
   //check if the query 
   if (!$query){//failure
    return(array(-5, NULL));
   }
   else{//successful
    return(array(1, NULL));
   }
  }
  
  function checkIfGoalExist($goalid){

      global $conn,$database_conn;
	  
	  mysqli_select_db($conn, $database_conn);
	
	  //get the required goal
	  $get_goal = "SELECT goal_id, deleted_flag FROM goal WHERE goal_id = '$goalid'";
      $query = mysqli_query($conn, $get_goal);
   
      //get the required row   
      $goal = mysqli_fetch_array($query);
      if($goal['goal_id'] == NULL || $goal['deleted_flag'] == "1"){//no such goal exists
       return -2;
      }
	  
	  return(1);
	  
  }
  
  function checkIfPatientExist($patientid){
	  
	  global $conn,$database_conn;
	  
	  mysqli_select_db($conn, $database_conn);
	  
	  //get the required patient
	  $get_patient = "SELECT id, active_flag FROM account_details WHERE id = '$patientid' AND type_flag = 2";
      $query = mysqli_query($conn, $get_patient);
      //get the required row   
      $patient = mysqli_fetch_array($query);
      if($patient['id'] == NULL || $patient['active_flag'] == 0){//no such patient exists
       return -3;
      }
	  
	  return 1;
	  
  }
  
  function checkIfGoalAssigned($patientid, $goalid){

	  global $conn,$database_conn;
	  
	  mysqli_select_db($conn, $database_conn);

   //get the goal IDs assigned to this patient
   $select_stmt = "SELECT goal_id FROM patient_goals WHERE patient_id = '$patientid' AND current_flag = 1";
   $get_goal_id = mysqli_query($conn, $select_stmt);
   while($goal_ids = mysqli_fetch_array($get_goal_id)){
    if($goal_ids['goal_id'] == $goalid){//check for duplications, if the goal is already assigned
     return (-4);
    }
   }

	return(1);  
  }
  
 ?>