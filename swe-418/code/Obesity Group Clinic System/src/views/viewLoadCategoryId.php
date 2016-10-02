

<?php


//This method will pupolate the option value for ViewCreateGoal form 
		require_once "functions/getCategoryInfo.php";		
				function loadCategory(){
				// will retunr all category info 
						$result = getCate();
				
				
				//will check if there is an category exists
				if($result[0]!=1)
				
						{
							echo "<option value='-1' >----------- </option>";
					
						}
				// fill in the option values
				else{
				  		
							echo "<option value='-1'>-----------</option>";
							while ($result_array=mysqli_fetch_row($result[1]))
				  
				    			{
						 			echo "
								
								<option value='$result_array[0]' >$result_array[1]</option>";
					 	 		}
					}
										
										
										
										}
			  ?>