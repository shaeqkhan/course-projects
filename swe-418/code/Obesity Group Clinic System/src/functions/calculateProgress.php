<?php
	require_once "t_config.php";
	require_once "getScore.php";
	require_once "getPatientGoals.php";
	require_once "getPatientGoalsBeforeDate.php";
	require_once "getAssignedGoalDetails.php";
	
    /*
     * FUNCTION NAME: calculateProgress
     * FUNCTION DESCRIPTION: calculate the progress for a period of time
     * AUTHOR: Rakan Al Ghofaily
     * LAST EDIT: Dec 24, 2011
     *
     * USERS: Admin, HealthTeam members and Patients
     * INPUT: $assignId,$date [of the first day], $number of days
     * RETURN: progress % or 
     *       -1 if not successful
     */
    function calculateProgress($assignId,$date,$days=7)
	{
		$scores = getScore($assignId,$date,$days);
		if(sizeof($scores)==0){
			return 0;
		}
		$sum = 0;
		for($i=0 ; $i<$days ; $i++){
			$sum+=$scores[$i];
		}
		$goalDetails = getAssignedGoalDetails($assignId);
		
		
		if( $goalDetails[0]==-1 || mysqli_num_rows($goalDetails[1])==0 ){
			return -1;
		}else{
			$goalDetails = $goalDetails[1];
			$row = mysqli_fetch_assoc( $goalDetails );
			$div = $row['stated_daily_max']*$row['frequency']*($days/7);
			//echo "div = " . $div;
			$sum /=$div;
			$sum *= 100;
			$sum = round($sum,2);
			return $sum;
		}
	}
	
	//die(calculateProgress(23,"2011-3-3",150));

?>