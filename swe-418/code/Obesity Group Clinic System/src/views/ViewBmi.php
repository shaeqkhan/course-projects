<?php

require_once("functions/t_config.php");

  function getBmi($id)


      {
	
    global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));
	
	 $select_stmt = "SELECT weight, height, bmi_time_stamp
FROM patient_bmi_history 
WHERE patient_id =$id
ORDER BY bmi_time_stamp DESC ";
     $query = mysqli_query($conn, $select_stmt);
	 
	 if(mysqli_num_rows($query)==0)
	       {
           
		   return -1;

           }
		  	  
	  
	 while( $result=mysqli_fetch_row($query)){
	     $bmi= round((($result[0])/($result[1]*$result[1])),2);
		echo"<tr>";
		echo "   <td>$result[0]</td>
    <td>$result[1]</td>
    <td> $bmi</td>
    <td>$result[2]</td>
";
echo"</tr>";  
	 }
	  }
	  

?>
  