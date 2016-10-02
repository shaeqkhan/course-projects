<?php
        require_once "functions/t_config.php";
        require_once "functions/getPatientGoals.php";
        require_once "functions/add_goal_to_patient.php";
        
        function viewGoalsNotAssigned()
        {
            
            if(isset($_POST['goal']))
		{
			foreach($_POST['goal'] as $count)
			{	
                                add_goal_to_patient($_POST['goal_id'][$count], $_GET['id'], $_POST['freq'][$count], $_POST['std'][$count], 1);
			}
		}
            
            $checkingResult = check_patient_id($_GET['id']);
            if ( $checkingResult == -2 )
		{
			echo "<div class='errorMessages'> Error connecting to the database. Please try again later </div>";
			return 0;
		}
		if( $checkingResult == -3)
                {
			echo "<div class = 'errorMessages'> Invalid operation. Patient doesn't exist </div>";
			return 0;
		}
                
                $result = view_patient_goals_not_assigned( $_GET['id']);
                
		if($result[0] != 1)
		{
			echo "<div class='errorMessages'> You already have all the goals. Don't you think it's too much? please consult your doctor. </div>";
			return 0;
		}
		
                
                //SOMECODE TO BE INSERTED HERE
                ?>
        <div class="formWrap">
      	<div id="form">
        <form action="" method="post" id="assignNewGoalForm">
        <div id="currentGoalsforPatient">
          <fieldset>
			<legend>Add New Goals</legend>
       	    <table width="730" border="1">
        	<thead>
      			<tr>  
        	    <th width="50" scope="check"></th>
    	  		<th width="180" scope="goalName">Goal Name</th>
			<th width="180" scope="max">Max</th>
			<th width="180" scope="min">Min</th>
	            <th width="180" scope="stated_daily_max">Stated Daily Max</th>
	            <th width="180" scope="frequency">Frequency</th>
        		</tr>
      		</thead>
            
            <tbody>
                <?php

                $result = $result[1];
                $i=0;
                while( $row = mysqli_fetch_assoc($result) )
		{ 
			?>
            <tr>
        	    <td><div align="center"><input name="goal[]" type="checkbox" value="<?php echo $i; ?>" /></div></td>
		    <input name="goal_id[]" type="hidden" value="<?php echo $row['goal_id']; ?>" /></div></td>
		    
        	    <td><div align="center"><?php echo $row['goal_name'] ?></div></td>
		    <td><div align="center"><?php echo $row['min_point_on_scale'] ?></div></td>
		    <td><div align="center"><?php echo $row['max_point_on_scale'] ?></div></td>
        	    <td><div align="center"><input id="" name="std[]" type="text" size="2" /></div></td>
        	    <td><div align="center"><input id="" name="freq[]" type="text" size="2" /></div></td>
            </tr>
            <?php
            $i++;
                }   
		?>
            </tbody>
      	  </table>
          <input id="add" name="add" type="submit" value="Add Goal" />
</fieldset>
          
          
        </div>
        </form>
        </div>
        </div>
        
        <?php        
        }
?>

