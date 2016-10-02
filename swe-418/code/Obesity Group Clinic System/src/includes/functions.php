<?php
/*
 * FUNCTIONS FILE
 * 
 *************************
 * 
 * 20 NOVEMBER 2011
 */

require_once "t_config.php";
require_once ("user.class.php");

	
/*
 * FUNCTION NAME: initializeVariables
 * FUNCTION DESCRIPTION: Initializes the session and the object $user to be used throughout the code. THIS FUNCTION MUST BE ON TOP OF ANY PAGE!
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 * USERS: Anounymous users, Admin, HealthTeam members and Patients
 * INPUT: None
 * RETURN: Object of type $user represents the current logged in user, with all variables set.
 */

function initialize_Variables(){
    if(!isset($_SESSION)){
        session_start();
    }
    if(isset($_SESSION['user_id']) && $_SESSION['user_id'] != -1){
        $user = new User($_SESSION['user_id']);
    }else{
        $_SESSION['user_id']=-1;
        $user = new User();
    }
    return $user;
    
}


/*
 * FUNCTION NAME: checkEmail
 * FUNCTION DESCRIPTION: uses pattern to detect wether an email is valid or not.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 *Users: System
 *Input: $email to validate.
 *Return: true if email valid, false if not
 */
function checkEmail($email) {
  if(preg_match("/^([a-zA-Z0-9])+([a-zA-Z0-9\._-]) *@([a-zA-Z0-9_-])+([a-zA-Z0-9\._-]+)+$/",
               $email)){
    return true;
  }
  return false;
}

/*
 * FUNCTION NAME: loginUser
 * FUNCTION DESCRIPTION: uses pattern to detect wether an email is valid or not.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 * USERS: Anounymous, Admin, HealthTeam members and Patients
 * INPUT: $email to validate.
 * RETURN: true if email valid, false if not
 */
function loginUser($username,$password){
    $userId = User::authenticateUser($username,$password);
    if($userId!=-1){
        $_SESSION['user_id']=$userId;
        return 1;
    }else{
        $_SESSION['user_id']=-1;
        return -1;
    }
}

/*
 * FUNCTION NAME: logoutUser
 * FUNCTION DESCRIPTION: Destroy all session variables, remember to re-initialize the variables afterwards.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 * USERS: Admin, HealthTeam members and Patients
 * INPUT: None
 * OUTPUT: true if logging out is success, false otherwise
 */
function logoutUser(){
    if(isset($_SESSION)){
        return session_destroy();
    }else{
        return false;
    }
}
 /*
 * FUNCTION NAME: add_goal_cat
 * FUNCTION DESCRIPTION: Used to add a goal category to the database.
 * AUTHOR: Abdulaziz Alamoudi
 * LAST EDIT: Nov 15, 2011
 *
 *Users: 
 *Input:category name and category description.
 *returns 1 if the category was added, -1 otherwise (e.g. duplication, empty field for category name).
 */
 function add_goal_cat($category_name, $category_description){
   global $conn,$database_conn;
   $deleted_flag = 0;
   
	
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   //Check parameters...
   $category_name = htmlentities(mysqli_real_escape_string($conn,$category_name));
   if($category_name == NULL || $category_description == NULL){//no entry in one of the fields
    return -1;
   }
   //check if the category name already exists.
   $select_stmt = "SELECT category_name FROM category";
   $get_cat_name = mysqli_query($conn, $select_stmt);
   while($cat_names = mysqli_fetch_array($get_cat_name)){
    if($cat_names['category_name'] == $category_name){//check for duplications
     return -1;
    }
   }
   
   //Insert statement
   $insert_stmt = "INSERT INTO CATEGORY (category_name, category_description, deleted_flag) VALUES " . 
   "('$category_name', '$category_description', '$deleted_flag')";
   
   //SQL query
   $query = mysqli_query($conn, $insert_stmt); 
   //check if the query 
   if (!$query){//failure
    return -1;
   }
   else{//successful
    return 1;
   }
  }


/*
 * ADD GOAL
 * ADD A GOAL  THE OGC SYSTEM
 * AUTHOR: SAMEER AL-AMRI
 * users:Admin (OGCT Member)
 * input: goal info
 * return 1 success
 * return -1 cannot add goal 
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

   
   
   
   //Insert statement
   $insert_stmt = "INSERT INTO GOAL (goal_category_id, goal_name, goal_description, goal_type, min_point_on_scale, max_point_on_scale, deleted_flag) VALUES " .   "('$goal_cat_id', '$goal_name', '$goal_desc', '$goal_type', $min, $max, '$deleted_flag')";
  
  
   //SQL query
    $query = mysqli_query($conn,$insert_stmt);
    if (!$query){
     return -1;
    }
  }
  
   /*
 * FILE NAME: create_new_group.php
 * FILE DESCRIPTION: Used to create a new group.
 * AUTHOR: Abdulaziz Alamoudi
 * LAST EDIT: Nov 15, 2011
 *
 *Users: 
 *Input:group name and group description.
 *returns 1 if the group was added, -1 otherwise (e.g. duplication, empty fields).
 */
  
  
  function create_new_group($group_name, $group_description){
   
   global $conn,$database_conn;
   $active_flag = 0;
      
   //select the required database
   mysqli_select_db($conn, $database_conn);
   
   $group_name = htmlentities(mysqli_real_escape_string($conn,$group_name));
   if($group_name == NULL || $group_description == NULL){//no entry in one of the fields
    return -1;
   }
   
   //check if the group name already exists.
   $select_stmt = "SELECT group_name FROM patient_group";
   $get_group_name = mysqli_query($conn, $select_stmt);
   while($group_names = mysqli_fetch_array($get_group_name)){
    if($group_names['group_name'] == $group_name){//check for duplications
     return -1;
    }
   }
   
   //Insert statement
   $insert_stmt = "INSERT INTO patient_group (group_name, group_description, active_flag) VALUES " . 
   "('$group_name', '$group_description', active_flag)";
   
   //SQL query
   $query = mysqli_query($conn, $insert_stmt);
   if (!$query){//failure
    return -1;
   }
   else{//successful
    return 1;
   }
  }


/*
 * getPatientGoals
 * users:OGCT Memeber
 * input: goal flag, patient id 
 * return 1 success
 * return -1 no sql query (patient id's)
 * retrun -2 no patient exists
 * return -3 no sql query (goal's patient)
 * return -4 no goal assigned for that patient
 * return -5 no goal assigned and active for that patient
 * return -6 no assigned goal and not active for that patient 
 */
  function getPatientGoals($patient_id,$goal_flag=-1){
   // goal_flag used for which goals to retrive 
   // if  goal flag is 1 then retrun all goals assigned and active 
   // if goal flag is 2 then return all goals assigned and un active
   // if goal flag is -1 then  return all goals assigned
    global $conn,$database_conn;
    //Establish connection with the database server and check if the connection is established or not.
    //select the required database
    mysqli_select_db( $conn,$database_conn);
 
    // checking parmeter
    $patient_id = htmlentities(mysqli_real_escape_string($conn,$patient_id)); 
    $goal_flag = htmlentities(mysqli_real_escape_string($conn,$goal_flag)); 

    
    // checking the existing of the patient id 
    $select_stmt = " SELECT id FROM account_details WHERE type_flag=2";
    $patient_id_query=mysqli_query($conn, $select_stmt);
	  
	  
    // if no query
    if(!$patient_id_query){
      return -1;	  
    }
    
    if(mysqli_num_rows($patient_id_query) ==0) {
      return -2;	 
    }
    
     // displays the all goals of that patients
     if($goal_flag==-1){
	$select_stmt = "SELECT  account_details.first_name,account_details.last_name,patient_goals.assign_id,patient_goals.goal_id,patient_goals.patient_id,patient_goals.date_assigned,patient_goals.frequency,patient_goals.stated_daily_max,patient_goals.time_stamp as inserting_date,patient_goals.current_flag as patient_goal_status,goal.goal_name,goal.goal_description,goal.goal_type,goal.goal_category_id,goal.min_point_on_scale,goal.max_point_on_scale,goal.deleted_flag as goal_status FROM account_details,patient_goals,goal WHERE account_details.id=$patient_id AND patient_goals.goal_id=goal.goal_id AND patient_goals.patient_id=$patient_id";
	// send the query
	$patient_goals_results= mysqli_query($conn, $select_stmt);
	
	// if not query 
	if(!$patient_goals_results){
	  return -3;
	}
     
	//   no goals assigned
	if(mysqli_num_rows($patient_goals_results) ==0){
	     return -4;
	}
	return $patient_goals_results;
    
      }
      // Select the ID's of all goals assigned and active
      if($goal_flag==1){
	  $select_stmt = "SELECT  account_details.first_name,account_details.last_name,patient_goals.assign_id,patient_goals.goal_id,patient_goals.patient_id,patient_goals.date_assigned,patient_goals.frequency,patient_goals.stated_daily_max,patient_goals.time_stamp as inserting_date,patient_goals.current_flag as patient_goal_status,goal.goal_name,goal.goal_description,goal.goal_type,goal.goal_category_id,goal.min_point_on_scale,goal.max_point_on_scale,goal.deleted_flag as goal_status FROM account_details,patient_goals,goal WHERE account_details.id=$patient_id AND patient_goals.goal_id=goal.goal_id AND patient_goals.patient_id=$patient_id AND patient_goals.current_flag = 1";
	  $patient_goals_results= mysqli_query($conn, $select_stmt);
	  if(!$patient_goals_results){
	      return -3;
	  }
	  //   no goals assigned and active 
	  if(mysqli_num_rows($patient_goals_results) ==0){
	     return -5;	 
	  }
	  return $patient_goals_results;
     }
      if($goal_flag==2){
	  $select_stmt = "SELECT  account_details.first_name,account_details.last_name,patient_goals.assign_id,patient_goals.goal_id,patient_goals.patient_id,patient_goals.date_assigned,patient_goals.frequency,patient_goals.stated_daily_max,patient_goals.time_stamp as inserting_date,patient_goals.current_flag as patient_goal_status,goal.goal_name,goal.goal_description,goal.goal_type,goal.goal_category_id,goal.min_point_on_scale,goal.max_point_on_scale,goal.deleted_flag as goal_status FROM account_details,patient_goals,goal WHERE account_details.id=$patient_id AND patient_goals.goal_id=goal.goal_id AND patient_goals.patient_id=$patient_id AND patient_goals.current_flag = 0";
	  // send the query
	  $patient_goals_results= mysqli_query($conn, $select_stmt); 
	  if(!$patient_goals_results){
		 return -3; 
	  }
	
	 //   no goals assigned that is unactive for that patients
	 if(mysqli_num_rows($patient_goals_results) ==0){
	      return -6;	 
	 }
	 return $patient_goals_results;
      }
  }

	    /*
     * FUNCTION NAME: getScore
     * FUNCTION DESCRIPTION: gets the progress of one of the goals for a specific
     * period of time
     * AUTHOR: Rakan Al Ghofaily
     * LAST EDIT: Dec 18, 2011
     *
     * USERS: Admin, HealthTeam members and Patients
     * INPUT: $assignId,$date [of the first day], $number of days
     * RETURN: score(s) or 
     *       -1 if not successful
     */
    function getScore($assignId,$date,$days=1){
	global $conn,$database_conn;
        
        //select the required database
        mysqli_select_db($conn, $database_conn);
        
        $assignId = htmlentities(mysqli_real_escape_string($conn,$assignId));
        $date = htmlentities(mysqli_real_escape_string($conn,$date));
        $days = htmlentities(mysqli_real_escape_string($conn,$days));
        
        //calculate the date of the last day of that period
        $time = strtotime($date);
        $lastDayDate=  date("Y-m-d",strtotime("+ $days days",$time));
        
        //select the score and date for every day between the date and the lastDate date..
        $query = "SELECT score,date FROM patient_daily_record pdr WHERE pdr.assign_id = $assignId AND pdr.date< '$lastDayDate' AND pdr.date>='$date'";
        $result = mysqli_query($conn,$query);
        //die($query);
        //loop through the result and copy values to the result array according to the correct dates in the correct order..
        $i=0;
        $record=array();
        $row = mysqli_fetch_assoc($result);     //get the first record
        $flag=0;
        while( $i < $days ){

            //iterates iDate through the number of days
            $time = strtotime($date);
            $time = strtotime("+ $i days",$time);
            $iDate = date("Y-m-d",$time);
            
            if( $row['date'] == $iDate ){       //if the current Date matches the current iDate iteration
                $record[$i]=$row['score'];
                $i++;
                $row = mysqli_fetch_assoc($result);
            }else{                              //else set current array element to 0; because no entry matches the same date.
                $record[$i]=0;
                $i++;
            }
        }              
            
            
        return $record;
    }

	/*
     * FUNCTION NAME: setScore
     * FUNCTION DESCRIPTION: sets the score for the patient's progress
     * AUTHOR: Rakan Al Ghofaily
     * LAST EDIT: Dec 18, 2011
     *
     * USERS: Admin, HealthTeam members and Patients
     * INPUT: $assignId,$date,$score
     * RETURN: 1 if set successfully
     *       -1 if not set successfully
     */
	 
    function setScore($assignId,$date,$score){
	global $conn,$database_conn;
        
        //select the required database
        mysqli_select_db($conn, $database_conn);
        
        $assignId = htmlentities(mysqli_real_escape_string($conn,$assignId));
        $date = htmlentities(mysqli_real_escape_string($conn,$date));
        $score = htmlentities(mysqli_real_escape_string($conn,$score));
        
        
        //check if there is a scored stored for that day alreadys
        $query = "SELECT assign_id from patient_daily_record pdr WHERE pdr.assign_id = $assignId AND pdr.date = '$date'";
        $result = mysqli_query($conn,$query) or die("Unexpected error!");
        
        //if no score stored for that dat
        if(mysqli_num_rows($result)<1){
            $query = "INSERT INTO patient_daily_record(assign_id,date,score) VALUES ($assignId , '$date', $score);";
        }
        //otherwise, update existing score
        else{
            $query = "UPDATE patient_daily_record SET score=$score WHERE assign_id=$assignId AND date= '$date';";
        }
        
        if(mysqli_query($conn,$query)){
            return 1;
        }
        return -1;
        
    }
	
   
   

 ?>