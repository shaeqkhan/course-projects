
<?php


/*
 * create_user.php
 * add user to the system
 * Sameer 
 * 19/11/2011 
 */



require_once("t_config.php");
require_once("add_patient_to_bmi_history.php");


/*
 * add a user 
 * add a user to the OGC system
 * users:Admin (OGCT Memeber)
 * input: user info
 * return 1 success
 * return -1 if null info
 * return -2 duplicate e-mail
 * return -3 duplicate user name
 * return -4 no SQL
 * return -5 cannot add a patient bmi history 
 */
  
  
  function create_user($mail, $username, $password, $aramco_id, $first_name, $last_name,$gender,$mobile_number,$date_of_birth,$user_type,$start_date,$active_flag,$assigned_group,$weight,$height){
  
  
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
    
   if($mail==NULL || $username ==NULL || $password ==NULL || $aramco_id ==NULL ||$first_name==NULL || $last_name==NULL ||$gender==NULL ||$mobile_number==NULL ||$date_of_birth==NULL ||$user_type==NULL ||$start_date==NULL ||$active_flag==NULL)
   {
	  return array(-1,NULL); 
   }
    //check for duplications for the user name or email 
 $select_stmt = "SELECT email,username FROM account_details WHERE email='$mail' OR username='$username'";
   $check_dup = mysqli_query($conn, $select_stmt);
   while($result_check = mysqli_fetch_array($check_dup)){
    if($result_check['email'] == $mail){    

     return array(-2,NULL);
    }
	if($result_check['username']==$username){    

     return array(-3,NULL);
    }
   } 
   //Insert statement
  $insert_stmt = "INSERT INTO ACCOUNT_DETAILS(email, username, password, aramco_id, first_name, last_name, gender,mobile_number,date_of_birth,type_flag,start_date,active_flag,assigned_group) VALUES ('$mail', '$username', '$password', '$aramco_id', '$first_name', '$last_name', '$gender','$mobile_number','$date_of_birth',$user_type,'$start_date',$active_flag,$assigned_group)";
   //SQL query
    $query = mysqli_query($conn,$insert_stmt);
    if (!$query){
     return array(-4,NULL);
    }
	
		// if the user added is a patient type,, and the user is added successfully then we add a bmi history to that patient  
		if($query && $user_type==2)
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
	           		return array(-5,NULL);	
				}
   
   			return array(1,$patient_id);	
		}
		return array(1,NULL);
	}
	// checking for number of ADMIN 
	//checking for assigned_groups avaliablty
 ?>
