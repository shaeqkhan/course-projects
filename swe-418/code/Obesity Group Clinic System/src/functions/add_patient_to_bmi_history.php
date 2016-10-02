
<?php


/*
 * add patient to bmi history .php
 * add patient to patient_bmi_history table
 * Sameer 
 * input: patient_id, patient weight, patient height
 * output: add patient to BMI history 
 * 19/11/2011 
 */



require_once("t_config.php");


/*
 * add wieght and hieght for a patient
 * users:Admin (OGCT Memeber)
 * input: weight and height
 * return 1 success
 * return -1 cannot add because the pateint is not add or existed in the account table
 */
  
  
  function create_patient_bmi($patient_id, $weight, $height){
  
  
    global $conn,$database_conn;
	   //Establoish connection with the database server and check if the connection is established or not.
   
   //select the required database
   mysqli_select_db( $conn,$database_conn);
   
   //checking parameters...
  $patient_id= htmlentities(mysqli_real_escape_string($conn,$patient_id));
   $weight = htmlentities(mysqli_real_escape_string($conn,$weight));
   $height = htmlentities(mysqli_real_escape_string($conn,$height));
  
  
   //Insert statement
  $insert_stmt = "INSERT INTO PATIENT_BMI_HISTORY(patient_id,weight,height) VALUES ('$patient_id', '$weight', '$height')";
  
   //SQL query
    $query = mysqli_query($conn,$insert_stmt);
    if (!$query){
		
     return array(-1,NULL);
    }
	
	else
	 {
	 return array(1,NULL);	
		
	}
	
  }
 ?>
