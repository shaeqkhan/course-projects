<?php

require_once "t_config.php";
require_once "setScore.php";
require_once "dateToDayWeekDate.php";

function updateProgress( $assign_id , $startDate , $arrayOfScores ){
	$numOfDays = sizeof($arrayOfScores);
	for($i=0 ; $i<$numOfDays ; $i++){
		$date = incrementDate($startDate,"+".$i);
		setScore($assign_id,$date,$arrayOfScores[$i]);
	}
}
	
?>