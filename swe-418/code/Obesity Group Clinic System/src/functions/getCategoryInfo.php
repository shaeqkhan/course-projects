<?php 

require_once("t_config.php");


           // return cateogry info
		   //return 1, if success
		   //return -1, if no categroy
		function getCate() 
			{
								 global $conn, $database_conn;
					
   					//Establoish connection with the database server and check if the connection is established or not.
   
  					 //select the required database
 				  mysqli_select_db($conn,$database_conn);
				  $select_stmt= "SELECT * FROM category WHERE deleted_flag=0";
				  $query= mysqli_query($conn,$select_stmt);
				  $query_result= mysqli_num_rows($query);
				  if($query_result==0)
				  {
					  return array(-1,NULL);
				  }
				  
				  else {
					  return array(1,$query);
					  
					  }	
	}
	
	?>