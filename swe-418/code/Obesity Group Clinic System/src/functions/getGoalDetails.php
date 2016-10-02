
<?php


/*
 *get goals details.php
* Yasir
*get goals details  
 * 2/01/2012 
 */



require_once("functions/t_config.php");


/*
 * get goal details
 * users:OGCT Memeber/patient
 * input: goal id
 * output: goal details object 
 * return 1 success
 * return -1 goal id does not exist
 * retrun -2 no sql query
 * retrun -3 if goal id is null
 */
  
  function get_goal_details($goal_id=-1)
  {
    
    global $conn,$database_conn;
	   //Establoish connection with the database server and check if the connection is established or not.
   
   //select the required database
   mysqli_select_db( $conn,$database_conn);
   
   
   //checking parameters...
   $goal_id = htmlentities(mysqli_real_escape_string($conn,$goal_id)); 

 //if the $goal_id is -1 then displays all goals with there details
    $select_stmt;
	
	if($goal_id== NULL)
	
    {
	return 	array(-3,NULL);
    }
	
	
    if ($goal_id ==-1 )
	{
	  return array(-4, null);
        }
	//else displays the spesfic goal details	
	else {
		  $select_stmt = "SELECT * FROM  goal WHERE goal_id = $goal_id AND deleted_flag = 0";
		  
	      }
		   
	$check_goal = mysqli_query($conn, $select_stmt);
  
	// if not query 
	 if(!$check_goal)
	 {
	    return array(-2, NULL); 
	}
	
	// if no goals are existed 
	 if(mysqli_num_rows( $check_goal) ==0) 
	 
	 {
		 return array(-1, NULL);	 
	 }
	
	else
	{			
	  return array (1,$check_goal);
	 }
	
	}
	
	

 ?>
