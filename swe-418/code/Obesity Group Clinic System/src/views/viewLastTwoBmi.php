<?php

require_once("functions/t_config.php");


// Viewing the last BMI
  function getLastBmi($id){
	
     global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));
	
	 $select_stmt = "SELECT weight, height, bmi_time_stamp " . 
                    "FROM patient_bmi_history " .  
                    "WHERE patient_id =$id " . 
                    "ORDER BY bmi_time_stamp ASC";

     $query = mysqli_query($conn, $select_stmt);
	 
	 if(mysqli_num_rows($query)==0){
		 
		 return -1;
		 
     }
		   
		   $result;
		   //the fetched row will be stored in this variable
		   /*the following for-loop is executed according to the number of rows 
		   returned by the query
		   it checks if the iterator variable (i) is the first index or the (number of rows-1)
		   if not thin it skips the fetched row and goes to the next.
		   */
		   $bmi_array = array();
		   $index = 0;
		   
		   echo"<table border='1'>";
		   echo"<thead>";
		   echo"<tr>";
		   echo"<th>Weight</th>";
		   echo"<th>Height</th>";
		   echo"<th>BMI</th>";
		   echo"<th>Date Recorded</th>";
		   echo"</tr>";
		   echo"</thead>";
		   
		   echo"<tbody>";
		  	for($i = 0; $i < mysqli_num_rows($query); $i++){
				
				if($i != 0 ){//check if the iterator variable is not zero
				
					if($i != (mysqli_num_rows($query) - 1)){//check if the iterator variable is not the index of the last row
					
					 $result=mysqli_fetch_assoc($query);	
					 continue;//skip and go to the next iteration
					 
					}
					
				}
				

			    $result=mysqli_fetch_assoc($query);
					
				$bmi= round((($result['weight'])/($result['height']*$result['height'])),2);
				$bmi_array[$index] = $bmi;
				$index++;
				
				echo "<tr><th>" . $result['weight'] . "</th>".
				"<th>" . $result['height'] . "</th>" . 
				"<th>" . $bmi . "</th>". 
                "<th>" . $result['bmi_time_stamp'] . "</th></tr>";	

			}
			echo"<tr><th>BMI Percentage:</th><th>" . calculateChangeBMI($bmi_array) . "%</th><tr>";
     		echo"</tbody>";			
			echo"</table>";
			
		
    
	  }
//used for testing purposes	  
//getLastBmi(3);


function calculateChangeBMI($bmi_array){
	if( sizeof($bmi_array)<2){
		return 0;
	}
	
	$result_bmi = ((($bmi_array[1]-$bmi_array[0])/$bmi_array[1])*100);
	$result_bmi = round($result_bmi, 2);
	return($result_bmi);
	
	}
?>
  