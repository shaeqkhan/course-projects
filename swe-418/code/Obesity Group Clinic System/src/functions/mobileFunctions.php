<?php
require_once("t_config.php");
require_once "getScore.php";
require_once "setScore.php";
require_once "getPatientGoals.php";


function mob_getRandomMessage(){
	$messages = array("What did you acheive today?",
						"You are another step closer to a healthier life!",
						"The first wealth is health; keep going!");	
	$randomMessage = $messages[rand(0,sizeof($messages)-1)];
	return $randomMessage;
	
	
	
}

function mob_viewPatientGoals(){
	global $today;
	if(!isLoggedIn()){
		echo "ERROR1";
	}else{
		$user = initialize_Variables();
		$goals = get_patient_goals($user->id,1);
		
		//handle $goals errors
		//
		//
		//
		
		if($goals[0]!=1){
			die("<ul class='info'><h3>No goals, yet!</h3>It's never too late to be healthy, don't worry!<br />
				Login to the full system and choose your goals.<br />
				<li> For more information, logout and press the 'about' button.</li></ul>");
		}
		
		//Display a nice welcoming message
		$message = mob_getRandomMessage();
		echo "<ul class='info'>Welcome $user->first_name $user->last_name, $message <br />
			Provide your score for each goal to update your progress.</ul>";
			$goals=$goals[1];
		while($row = mysqli_fetch_assoc($goals)){
			$goalName = $row['goal_name'];
			$goalScore = getScore($row['assign_id'],$today,1);
			$goalScore = $goalScore[0];
			$assignId = $row['assign_id'];
			echo "<ul class='rounded'>";
			echo "<li> $goalName";
			echo "<span name='assignID' class='assignID'> $assignId </span> </li>";
			echo "<li> <input type='text' value='$goalScore' name='score' class='score_input' autocapitalize='off' autocorrect='off' autocomplete='off'/></li>";
			echo "</ul>";
			
		}
		echo "<ul> <li><a href='#' onclick='updateScores();' class='greenButton' id='updateButton'> Update your scores! </a></li> </ul>";	
    }
    
}

//SECURITY ISSUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
function mob_updateScore($assID, $score){
	global $today;
	if(!isLoggedIn()){
		echo "ERROR2";
	}else{
		//CHECK WHETHER THE ASSIGNID IS HIS OR NOT!!!!!!!!!!!!!!!!!!
		
		return setScore($assID,$today,$score);
	}
}

function isLoggedIn(){
	$user = initialize_Variables();
	if($user->id==-1 || $user->type_flag != 2){
		return -1;
	}else{
		return 1;
	}
}

?>