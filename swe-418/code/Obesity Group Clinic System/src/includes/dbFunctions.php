<?php


/*
 * DB FUNCTIONS FILE
 *
 * List of functions which extracts data from the db
 *
 * RULE OF THUMB: does it connect to the db?
 * if yes, you are looking in the right place!
 * 
 *************************
 * 
 * 18 DECEMBER 2011
 *
 * Functions Catalog
 * 	- checkEmail()
 * 
 */

require_once("t_t_config.php");

//-------------------- DB FUNCTIONS --------------------//
//														//
// Get data from the db.                  				//
//////////////////////////////////////////////////////////

/*
 * checkUserDuplicates
 * add a user to the OGC system
 * users:Admin (OGCT Memeber)
 * input: user info
 * return 1 no duplicates<br />
 * return -1 duplicate username
 * return -2 duplicate email
 */
function db_checkUserDuplicates($username,$email){
	global $conn,$database_conn;
	//Establoish connection with the database server and check if the connection is established or not.
   
   //select the required database
   mysqli_select_db( $conn,$database_conn);
   
   $email= htmlentities(mysqli_real_escape_string($conn,$email));
   $username = htmlentities(mysqli_real_escape_string($conn,$username));
   
   //check for duplications for the user name
	$select_stmt = "SELECT id FROM account_details WHERE username='$username'";
	$check_dup = mysqli_query($conn, $select_stmt);
    if(mysqli_num_rows($check_dup)!=0){
		return -1;
	}
	//check for duplications for the user name or email 
	$select_stmt = "SELECT id FROM account_details WHERE email='$email'";
	$check_dup = mysqli_query($conn, $select_stmt);
    if(mysqli_num_rows($check_dup)!=0){
		return -2;
	}
   
}


/*
 * add a user 
 * add a user to the OGC system
 * users:Admin (OGCT Memeber)
 * input: user info
 * return 1 success
 * return -1 cannot add user
 * return -2 cannot add user (duplicate, same e-mail or user name )
 * return -3 cannot add a patient bmi history 
 */
  
  
function db_create_user($mail, $username, $password, $aramco_id, $first_name, $last_name,$gender,$mobile_number,$date_of_birth,$user_type,$start_date,$active_flag,$assigned_group,$weight,$height){
  
  
    global $conn,$database_conn;
	//Establoish connection with the database server and check if the connection is established or not.
   
   //select the required database
   mysqli_select_db( $conn,$database_conn);
   
   
   //checking parameters...
   $mail= htmlentities(mysqli_real_escape_string($conn,$mail));
   $username = htmlentities(mysqli_real_escape_string($conn,$username));
   $aramco_id = htmlentities(mysqli_real_escape_string($conn,$aramco_id));
   $first_name = htmlentities(mysqli_real_escape_string($conn,$first_name));
   $last_name = htmlentities(mysqli_real_escape_string($conn,$last_name));
   $gender = htmlentities(mysqli_real_escape_string($conn,$gender));
   $mobile_number = htmlentities(mysqli_real_escape_string($conn,$mobile_number));
   $date_of_birth = htmlentities(mysqli_real_escape_string($conn,$date_of_birth));
   $user_type = htmlentities(mysqli_real_escape_string($conn,$user_type));
   $start_date= htmlentities(mysqli_real_escape_string($conn,$start_date));
   $active_flag= htmlentities(mysqli_real_escape_string($conn,$active_flag));
   $assigned_group= htmlentities(mysqli_real_escape_string($conn, $assigned_group));
 
 
 
   if($assigned_group==""){
	   $assigned_group="NULL";
   }
    

    
   //Insert statement
	  $insert_stmt = "INSERT INTO ACCOUNT_DETAILS(email, username, password, aramco_id, first_name, last_name, gender,mobile_number,date_of_birth,type_flag,start_date,active_flag,assigned_group) VALUES ('$mail', '$username', '$password', '$aramco_id', '$first_name', '$last_name', '$gender','$mobile_number','$date_of_birth',$user_type,'$start_date',$active_flag,$assigned_group)";
  
   	//SQL query
    	$query = mysqli_query($conn,$insert_stmt);
	    if (!$query){
		
	   	  return -1;
	    }
	
		// if the user added is a patient type,, and the user is added successfully then we add a bmi history to that patient  
		if($query && $user_type='2')
		{
	
		// fisrt we should get that patient_id which is the last tuple inserted 
		// retrun the last patient id inserted in the table 
		$select_stmt_id = "SELECT id FROM account_details WHERE type_flag='2' ORDER BY id desc LIMIT 1";
   		$get_id = mysqli_query($conn, $select_stmt_id);
   		$patient_id_result= mysqli_fetch_array($get_id);
	   $patient_id= $patient_id_result['id'];
		if($get_id)
			    {
			create_patient_bmi($patient_id, $weight, $height);
		
		}
		//if there is an error when returning the patient id 	
		else 
		{
	         return -3;	
		}
   } 	
}
	// checking for number of ADMIN 
	//checking for assigned_groups avaliablty

?>