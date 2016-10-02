<?php

    require_once "functions/t_config.php";
    //require_once "functions/getGoalDetails.php";
	require_once "functions/getSpecificGoalDetails.php";
    require_once "functions/getPatientsWithSameGoal.php";
    
    function viewViewGoalDetails ()
    {
	if(isset($_GET['id']))
	{
	    $hasPatient = true;
	    $goal_details_checking_result = getSpecificGoalDetails($_GET['id']);
	    $goal_details_checking_result  = $goal_details_checking_result [0];
	    
	    $patient_details_checking_result = getPatientsWithSameGoal($_GET['id']);
	    $patient_details_checking_result  = $patient_details_checking_result[0];
	    
	    if($goal_details_checking_result  == -4)
	    {
		echo "<div class='errorMessages'> You haven't provided a goal to view! </div>";
		return 0;
	    }
	    
	    if($goal_details_checking_result  == -1)
	    {
		echo "<div class='errorMessages'> Hmmm something fishy is going on. Did you try to perform an invalid operations? </div>";
		return 0;
	    }
	    
	    if($goal_details_checking_result  == -1)
	    {
		echo "<div class='errorMessages'> The specified goal wasn't found! </div>";
		return 0;
	    }
	    
	    //checking patients
	    	    if($patient_details_checking_result  == -3)
	    {
		
		$hasPatient = false;
	    }
	    
	    if($patient_details_checking_result  == -2)
	    {
		echo "<div class='errorMessages'> You haven't specified any goals to view patients associated with it! </div>";
		return 0;
	    }
	    
	    if($patient_details_checking_result  == -1)
	    {
		echo "<div class='errorMessages'> Error connecting to the database. Please try again later! </div>";
		return 0;
	    }
	    
	    
	}
	
	    $goal_details_result = getSpecificGoalDetails($_GET['id']);
	    $goal_details_result = $goal_details_result[1];
	    $goal_details_result = mysqli_fetch_assoc($goal_details_result);
	    
	    $patient_details_result = getPatientsWithSameGoal($_GET['id']);
	    $patient_details_result = $patient_details_result[1];

	    ?>
	    
	    
<div class="formWrap">
<div id="form">
<fieldset>
    <legend>Goal</legend>
    <div class="row">
        <label for="goal_name" class="label"><B>Goal Name</B></label>
        <div class="input"><?php echo $goal_details_result['goal_name'];?></div>
    </div><!-- .row-->
    
        <div class="row">
        <label for="goal_name" class="label"><B>Goal Type</B></label>
        <div class="input"><?php if($goal_details_result['goal_type']==0)
				{
				$goal_details_result['goal_type']= "Incriminatory";
				}
				if($goal_details_result['goal_type']==1)
				{
				$goal_details_result['goal_type']= "Decrementory";
				}
				
				 echo $goal_details_result['goal_type']; ?></div>
    </div>
    
        <div class="row">
        <label for="goal_name" class="label"><B>Goal Category</B></label>
        <div class="input"><?php 
				
				if($goal_details_result['category_name']!=NULL)
				{?>
<a href="viewCategoryDetails.php?id=<?php echo $goal_details_result['category_id'];?>"><?php echo $goal_details_result['category_name'];?></a>

				<?php
				}
				else{echo $goal_details_result['category_name']= "Not Assigned";}
				 
				
				
				?></div>
    </div>
    
    <div class="row">
        <label for="goal_description" class="label"><B>Goal Description</B></label>
        <div class="input"><?php 
						if($goal_details_result['goal_description']==NULL)
				{
				$goal_details_result['goal_description']= "No Description Available";
				}
				echo $goal_details_result['goal_description']; 
				
				 ?></div>
    </div><!-- .row-->
    

    

            

</fieldset>              
</div>
</div>
        
<div id="viewPatientForGoals">
       	  
<fieldset>
			<legend>Goal's Patients</legend>
			<?php
			if(!$hasPatient)
			{
			    echo "<div class='errorMessages'> No patients were assigned to this goal </div>";
			    return 0;
			}	
			?>
       	    <table border="1">
        	<thead>
      			<tr>  
        	    <th width="150" scope="patient_name">Patient Name</th>                
                <th width="50" scope="gender">Gender</th>
                <th width="100" scope="email">Email</th> 
                <th width="100" scope="dob">Date of birth</th>
	            <th width="100" scope="mobile">Mobile Number</th>
    	        <th width="100" scope="startDate">Start date</th>
        		</tr>
      		</thead>
            
            <tbody>
		
		<?php
	
		    while( $row = mysqli_fetch_assoc($patient_details_result) )
		{
		    $gender = '';
		    if($row['gender'] == 'm'){$gender = 'Male';}
		    else{$gender = 'Female';}
		
		?>
            <tr>
        	    <td><a href="AccountProfile.php?id=<?php echo $row['patient_id']; ?>"><?php echo $row['name'];?></a></td>
        	    <td><?php echo $gender ?></td>
        	    <td><?php echo $row['email'];?></td>
        	    <td><?php echo $row['date_of_birth'];?></td>
        	    <td><?php echo $row['mobile_number'];?></td>
                <td><?php echo $row['start_date'];?></td>
      	    </tr>
	    <?php
		}
		?>
            </tbody>
      	  </table>
</fieldset>
          
          
</div><!-- #viewPatientForGoals-->
        <?php
        }
?>