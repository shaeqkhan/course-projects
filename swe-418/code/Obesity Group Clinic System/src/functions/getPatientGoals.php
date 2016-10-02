
<?php


/*
 * getPatientGoals.php
 *getPatientGoals
 * Sameer 
 * 19/11/2011 
 */



require_once("t_config.php");



/*
 * getPatientGoals
 * users:OGCT Memeber
 * input: goal flag, patient id 
 * return 1 success
 * if the one of the parameter is null return -1
 * return -2 no sql query (patient id's)
 * retrun -3 no patient exists
 * return -4 no sql query (goal's patient)
 * return -5 no goal assigned for that patient
 * return -6 no goal assigned and active for that patient
 * return -7 no assigned goal and not active for that patient 
 */
   function get_patient_goals($patient_id,$goal_flag=-1){
   // goal_flag used for which goals to retrive 
   // if  goal flag is 1 then retrun all goals assigned and active 
   // if goal flag is 2 then return all goals assigned and un active
   //if goal flag is -1 then  return all goals assigned (BOTH)
    global $conn,$database_conn;
	   //Establoish connection with the database server and check if the connection is established or not.
   
   		//select the required database
   		 mysqli_select_db( $conn,$database_conn);
 
 		// checking parmeter
	   $patient_id = htmlentities(mysqli_real_escape_string($conn,$patient_id)); 
       $goal_flag = htmlentities(mysqli_real_escape_string($conn,$goal_flag)); 

      if ($goal_flag==NULL || $patient_id==NULL)

	 	 {
			 // one of the parameter is null
		  return array(-1,NULL);
		  }
    
	
	 if ($patien_id_result=check_patient_id($patient_id)==-2)
	 
	      {
		 
		 return array(-2,NULL);
		 
		 }
		  
		  
     if ($patien_id_result=check_patient_id($patient_id)==-3)
	 
	      {
		 
		  return array(-3,NULL);
		 
		 }
	  
	  $select_stmt; 
	  
	 // displays the all goals of that patients
	 if($goal_flag==-1)
	 {
		 
	   $select_stmt = "SELECT  account_details.first_name,account_details.last_name,patient_goals.assign_id,patient_goals.goal_id,patient_goals.patient_id,patient_goals.date_assigned,patient_goals.frequency,patient_goals.stated_daily_max,patient_goals.time_stamp as inserting_date,patient_goals.current_flag as patient_goal_status,goal.goal_name,goal.goal_description,goal.goal_type,goal.goal_category_id,goal.min_point_on_scale,goal.max_point_on_scale,goal.deleted_flag as goal_status FROM account_details,patient_goals,goal WHERE account_details.id=$patient_id AND patient_goals.goal_id=goal.goal_id AND patient_goals.patient_id=$patient_id";
	 
	  // send the query
	   $patient_goals_results= mysqli_query($conn, $select_stmt);
	    
		  // if not query 
	 if(!$patient_goals_results)
	 {
		 return array(-4,NULL);
	 }
	 
	 //   no goals assigned
	 if(mysqli_num_rows($patient_goals_results) ==0) 
	 
	 {
		return array(-5,NULL); 
	 }
	
	 
	    //	die($select_stmt);							
			 
	  //  to display the values in tables
   
	return $patient_goals_results;
	
				
				

	 }
	 
	 // Select the ID's of all goals assigned and active
	 
	 if($goal_flag==1) 
	 {
		 
		  
		 $select_stmt = "SELECT  account_details.first_name,account_details.last_name,patient_goals.assign_id,patient_goals.goal_id,patient_goals.patient_id,patient_goals.date_assigned,patient_goals.frequency,patient_goals.stated_daily_max,patient_goals.time_stamp as inserting_date,patient_goals.current_flag as patient_goal_status,goal.goal_name,goal.goal_description,goal.goal_type,goal.goal_category_id,goal.min_point_on_scale,goal.max_point_on_scale,goal.deleted_flag as goal_status FROM account_details,patient_goals,goal WHERE account_details.id=$patient_id AND patient_goals.goal_id=goal.goal_id AND patient_goals.patient_id=$patient_id AND patient_goals.current_flag = 1";
	  // send the query
	   $patient_goals_results= mysqli_query($conn, $select_stmt);
	   
	   
	   if(!$patient_goals_results)
	 {
		 return array(-4,NULL); 
	 }
	 
	 //   no goals assigned and active 
	 if(mysqli_num_rows($patient_goals_results) ==0) 
	 
	 {
		 return array(-6,NULL);	 
	 }
			 
	  //  to display the values in tables
   	return array(1,$patient_goals_results);
	
	 			
			
	 }
	 
	 // Select the ID's of all goals assigned and not active
	  if($goal_flag==2) 
	 
	 {
		$select_stmt = "SELECT  account_details.first_name,account_details.last_name,patient_goals.assign_id,patient_goals.goal_id,patient_goals.patient_id,patient_goals.date_assigned,patient_goals.frequency,patient_goals.stated_daily_max,patient_goals.time_stamp as inserting_date,patient_goals.current_flag as patient_goal_status,goal.goal_name,goal.goal_description,goal.goal_type,goal.goal_category_id,goal.min_point_on_scale,goal.max_point_on_scale,goal.deleted_flag as goal_status FROM account_details,patient_goals,goal WHERE account_details.id=$patient_id AND patient_goals.goal_id=goal.goal_id AND patient_goals.patient_id=$patient_id AND patient_goals.current_flag = 0";
	  
	  // send the query
	   $patient_goals_results= mysqli_query($conn, $select_stmt);
	   
	    if(!$patient_goals_results)
	 {
		 return array(-4,NULL); 
	 }
	 
	 //   no goals assigned that is unactive for that patients
	 if(mysqli_num_rows($patient_goals_results) ==0) 
	 
	 {
		 return array(-7,NULL);	 
	 }
	 						
			 
	  //  to display the values in tables
		return $patient_goals_results;

	 }
	 
	 
  }
	
	
	function check_patient_id($patient_id) 
	
      	{
		 global $conn,$database_conn;
	   //Establoish connection with the database server and check if the connection is established or not.
   
   		//select the required database
   		 mysqli_select_db( $conn,$database_conn);
 
 		// checking parmeter
	  $patient_id = htmlentities(mysqli_real_escape_string($conn,$patient_id)); 
	
	
	  $select_stmt = " SELECT id FROM account_details WHERE type_flag=2 AND id=$patient_id";
	 $patient_id_query=mysqli_query($conn, $select_stmt);
	 
	  // if no query
	  if(!$patient_id_query)
	  {
		 return -2;
		  
	  }
	  
	 // no id match found
	 if(mysqli_num_rows($patient_id_query) ==0) 
	 
	 {
		 return -3;	 
	 }
	 
	
		
		}
	   
	   
	
	//return goals that not assigned to that patient 
	// return -1 if the parameter is null 
	// return -2 if not the sql
	//return -3 if no patient exist
	// return -4 if no sql (patient goal result)
	//return -5 all goals assigned to that patient 
    function view_patient_goals_not_assigned($patient_id){
   
    global $conn,$database_conn;
	   //Establoish connection with the database server and check if the connection is established or not.
   
   		//select the required database
   		 mysqli_select_db( $conn,$database_conn);
 
 		// checking parmeter
	   $patient_id = htmlentities(mysqli_real_escape_string($conn,$patient_id)); 
	   
	   
	   //if the patient id is null 
	   if($patient_id==NULL)
	   {
		return array(-1,NULL);    
	   }
	   
	   
	 if ($patien_id_result=check_patient_id($patient_id)==-2)
	 
	      {
		 
		 return array(-2,NULL);
		 
		 }
		  
		  
     if ($patien_id_result=check_patient_id($patient_id)==-3)
	 
	      {
		 
		 return array(-3,NULL);
		 
		 }
	  
	  $select_stmt; 
	  
	 // displays the all goals that not belong to that patients
	 
	   $select_stmt = "SELECT * FROM goal WHERE goal_id NOT IN ( SELECT goal_id FROM patient_goals WHERE patient_id=$patient_id AND current_flag = 1)";
	 
	  // send the query
	   $patient_goals_results= mysqli_query($conn, $select_stmt);
	    
		  // if not query 
	 if(!$patient_goals_results)
	 {
		  return array(-4,NULL);
	 }
	 
	 //   all goals assigned to that patient 
	 if(mysqli_num_rows($patient_goals_results) ==0) 
	 
	 {
		  return array(-5,NULL); 
	 }
	 
	 return array(1, $patient_goals_results);
	}

 ?>
