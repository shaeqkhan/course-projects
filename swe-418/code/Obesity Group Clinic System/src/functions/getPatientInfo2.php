<?php

 require_once "t_config.php";
 
 
// function to get the patient info 
// -1 no such patient existed
 function getPatientInfo($id){
	 global $conn, $database_conn;
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));
	
	 $select_stmt = "SELECT * FROM account_details WHERE id = $id AND type_flag = 2";
     $query = mysqli_query($conn, $select_stmt);
	
	
	 if(mysqli_num_rows($query)==0)
	 			
				{
					// if there is no patient
		          return array(-1,NULL);
				 
			    }
				//	echo("<h1>getting patient info</h1>");

	//get the last bmi for that 
	 
	 $resultbmi=getLastBmi($id);
	  if($resultbmi==-1 || $resultbmi==NULL)
	  {
		  
	  $resultbmi=0;  
	 
	  }
		 			
	  		//	echo("query = " . mysqli_fetch_row($query) . "<br/>");
		return array(1,$query);
 }  


           
		   
		   
		   function getLastBmi($id)


      {
	
    global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));
	
	 $select_stmt = "SELECT weight,height FROM  patient_bmi_history WHERE patient_id= '$id'";
     $query = mysqli_query($conn, $select_stmt);
	 
	 if(mysqli_num_rows($query)==0)
	       {
           
		   return -1;

           }
		   
		   $result_res;
	  
	  
	  while ( $result=mysqli_fetch_row($query))
	      {
		  
		   $result_res=$result;
		  
	       }
	  
	                   return  $result_res;
	  }
	  
	  function getMedicalHistory ($id)
	  {
		  
	global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));
	  $select_stmt = "SELECT description FROM patient_medical_history WHERE patient_id= '$id'";
   
	$query = mysqli_query($conn, $select_stmt);
	//$result = mysqli_fetch_row($query);
	 //echo("<h1>med his" . $result[0] . "</h1>");
		  return $query;
	  }
	  
	 
?>