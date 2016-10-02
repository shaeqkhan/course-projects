<?php
	require_once 'functions/t_config.php';
	require_once 'functions/getPatientGoals.php';
	require_once "functions/getScore.php";
	require_once "functions/dateToDayWeekDate.php";
	
	function viewCurrentGoals(){
		//call every for checking..
		global $today;
		$checkingResult = check_patient_id($_GET['id']);
		
		if ( $checkingResult == -2 )
		{
			//معناته بوه مشكله بالكنكشن
			//show error
			return 0;
		}
		if( $checkingResult == -3){
			//no user exist
			return 0;
		}
		
		$result = get_patient_goals( $_GET['id'] , 1 );
		$result = $result[1];
		
		if(mysqli_num_rows($result)==0){
			//no goals
			die();
			return 0;
		}
		//SOMECODE TO BE INSERTED HERE
		?>
        <fieldset>
		<legend>Current Goals</legend>
       	    <table width='650' border='1'>
        	<thead>
      			<tr>  
        	    <th width='150' scope='goalName'>Goal Name</th>
    	  		<th width='100' scope='dateAssigned'>Date Assigned</th>
	            <th width='75' scope='frequency'>Frequency</th>
    	        <th width='100' scope='statedDailyMax'>Stated Daily Max</th>
	            <th width='75' scope='progress'>Progress</th>        
        		</tr>
      		</thead>
            
            <tbody>
            <?php
			while( $row = mysqli_fetch_assoc($result) ){ 
			?>
            <tr>
        	    <td><?php echo $row['goal_name'] ?></td>
        	    <td><?php echo $row['date_assigned']; ?></td>
        	    <td><?php echo $row['frequency']; ?></td>
        	    <td><?php echo $row['stated_daily_max']; ?></td>
        	    <td><?php 
						$weekDate = dateToDayWeekDate($today);
						$weekDate = $weekDate[1];
						$currentWeekScores = getScore($row['assign_id'],$weekDate,7);
						$totalScore = 0;
						for($i=0; $i<sizeof($currentWeekScores) ; $i++){
							$totalScore += $currentWeekScores[$i];
						}
						$progress = $totalScore / ( $row['stated_daily_max'] * $row['frequency'] );
						$progress*=100;
						$progress = round($progress,2);
				echo $progress."%"; ?></td>
      	    </tr>
            <?php
			}
			?>
            </tbody>
      	  </table>
	</fieldset>
		<?php
		
	}
	
?>