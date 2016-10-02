<?php


/*
 * createMedicalHistory .php
 * add medical history to patient
 * Sameer
 * input: patient_id,midcal his
 * output: nothing 
 * 19/11/2011 
 */

require_once("t_config.php");



/*
 * add midcal his for a patient
 * users:Admin (OGCT Memeber)
 * input: patient id and history
 * return 1 success
 * return -1 cannot add because the pateint midcal history
 */
  
  
  function insert_patient_MedicalHistory($patient_id, $descrption){
  
  
    global $conn,$database_conn;
	   //Establoish connection with the database server and check if the connection is established or not.
   
   //select the required database
   mysqli_select_db( $conn,$database_conn);
   
   //checking parameters...
  $patient_id= htmlentities(mysqli_real_escape_string($conn,$patient_id));
   $descrption = htmlentities(mysqli_real_escape_string($conn, $descrption));
  
  
  
   //Insert statement
  $insert_stmt = "INSERT INTO  patient_medical_history (patient_id,description) VALUES ('$patient_id', ' $descrption')";
  
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
