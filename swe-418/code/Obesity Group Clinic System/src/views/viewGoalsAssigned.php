
<?php
        require_once "functions/t_config.php";
        require_once "functions/getPatientGoals.php";
	require_once "functions/remove_goal_from_patient.php";
	require_once "functions/updatePatientGoal.php";
        
        
        function viewGoalsAssigned()
        {
		if(isset($_POST['goal']))
		{
			foreach($_POST['goal'] as $count)
			{	
				updatePateintGoal($_POST['goal_ass_id'][$count], $_POST['freq'][$count],$_POST['std'][$count]);
			}
		}
		
		
	
            if( isset($_GET['del']) )
	    {
		$delCheckingResult = remove_patient_goal($_GET['del']);
		/*
				if($delCheckingResult[0] == -4)
		{
			echo "<div class='errorMessages'> You're trying to delete the same goals twice. Please don't do that. Its not logical! </div>";
			return 0;
		}
		*/
	    }
		$checkingResult = check_patient_id($_GET['id']);
	
            if ( $checkingResult == -2 )
		{
			echo "<div class='errorMessages'> Error connecting to the database. Please try again later </div>";
			return 0;
		}
		if( $checkingResult == -3){
			echo "<div class = 'errorMessages'> Invalid operation. Patient doesn't exist </div>";
			return 0;
		}
                
                $result = get_patient_goals( $_GET['id'] , 1 );
			
			if($result[0] != 1)
			{?>
				<div align="right"><a href = "listGoalsNotAssigned.php?id=<?php echo $_GET['id'];?>"><img src = "images/addGoal.png"/></a></div>
				<?php
				echo "<div class = 'errorMessages'> You don't have any goals yet. Get yours now by clicking the above button.</div>";?>
				<?php
				return 0;
			}
		
                
                //SOMECODE TO BE INSERTED HERE
                ?>
                
            <div class="formWrap">
      	<div id="form">
        
     
        <form action="myPath.php?op=0&id=<?php echo $_GET['id']; ?>" method="post" id="modifyGoalforPatientForm">
        <div id="currentGoalsforPatient">
          <fieldset>
			<legend>My Current Goals</legend>
	<div align="right"><a href = "assignGoal.php?id=<?php echo $_GET['id'];?>"><img src = "images/addGoal.png"/></a></div>
       	    <table width="730" border="1">
        	<thead>
      			<tr>  
        	    <th width="50" scope="check"></th>
    	  		<th width="180" scope="goalName">Goal Name</th>
	            <th width="180" scope="stated_daily_max">Stated Daily Max</th>
	            <th width="180" scope="frequency">Frequency</th>
    	        <th width="50" scope="delete"></th>
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
        	    <td><div align="center"><input name="goal[]" type="checkbox" value="<?php echo $i; ?>" />
						<input name="goal_ass_id[]" type="hidden" value="<?php echo $row['assign_id']; ?>" /></div></td>
        	    <td><div align="center"><?php echo $row['goal_name'] ?></div></td>
        	    <td><div align="center"><input id="" name="std[]" type="text" size="2" value = "<?php echo $row['stated_daily_max']; ?>"/></div></td>
        	    <td><div align="center"><input id="" name="freq[]" type="text" size="2" value = "<?php echo $row['frequency']; ?>"/></div></td>
        	    <td><a onclick = "return confirm('You will not be able to score any more for this goal. Are you sure?')" href=" myPath.php?op=0&id=<?php echo $_GET['id'] . '&del=' .$row['assign_id']; ?>"><div align="center"><img src="images/delete.png" width="24" height="24" alt="delete" align="middle"></div></a></td>
      	    </tr>
            <?php
		$i++;
		}
		?>
            </tbody>
      	  </table>
          <div class="row" style="padding-right:15px;" align="right"><input style="height:30px; width: 70px; " id="update" name="update" type="submit" value="Update" /></div>
</fieldset>
          
          
        </div>
        </form>
        </div>
        </div>


                
                
                
        <?php        
        }
?>


