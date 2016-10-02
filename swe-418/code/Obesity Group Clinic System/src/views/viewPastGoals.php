
<?php
        require_once "functions/t_config.php";
        require_once "functions/getPastGoals.php";
        require_once "functions/calculateProgress.php";
        require_once "functions/diffrenceBetweenDates.php";
        
        
        function viewPastGoals()
        { 
                $result = getPastGoals( $_GET['id']);
			
			if($result[0] == -2)
			{
				echo "<div class = 'successMessages'> Well done! You have never quit a goal, yet. When you do so, it will appear here.</div>";
				return 0;
			}
                        if($result[0] == -1)
			{
				echo "<div class = 'errorMessages'> Error connecting to the database. Please try again later.</div>";
				return 0;
			}
                ?>
                
            <div class="formWrap">
      	<div id="form">
        
     
        <form action="" method="post" id="getPastGoals">
        <div id="currentGoalsforPatient">
          <fieldset>
			<legend>My Past Goals</legend>
       	    
            <table width="730" border="1">
        	<thead>
      			<tr>  
                            <th width="180" scope="goalName">Goal Name</th>
                            <th width="180" scope="stated_daily_max">Date Assigned</th>
                            <th width="180" scope="frequency">Goal Released</th>
                            <th width="180" scope="frequency">Progress</th>
        		</tr>
      		</thead>
            
            <tbody>

                <?php
		$result = $result[1];
                while( $row = mysqli_fetch_assoc($result))
		{
                    $dateDeactivated = $row['time_stamp'];
                    $startingDate = $row['date_assigned'];
                    $assignId = $row['assign_id'];
		    $numDays= dateDiff($startingDate, $dateDeactivated);
			//echo "-".$assignId." & ".$startingDate ." & ". $dateDeactivated ." & ". $numDays."</br>";
                    $progress = calculateProgress($assignId, $startingDate, $numDays);
			?>
             <tr>
        	    <td><div align="center"><?php echo $row['goal_name'] ?></div></td>
        	    <td><div align="center"><?php echo $row['date_assigned']; ?></div></td>
        	    <td><div align="center"><?php echo $row['time_stamp']; ?></div></td>
        	    <td><div align="center"><?php echo $progress; ?> %</div></td>
      	    </tr>
            <?php
		}
		?>
                
            </tbody>
      	  </table>
</fieldset>
          
        
          
          
        </div>
        </form>
        </div>
        </div>


                
                
                
        <?php        
        }
        
?>


