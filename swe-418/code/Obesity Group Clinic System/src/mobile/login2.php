<?php
    require_once "../includes/login.php";
    require_once "../includes/functions.php";
    require_once "../includes/mobileFunctions.php";
    
    function getGoalsDummy(){
        
    }
	function getRandomMessage(){
		$messages = array("What did you acheive today?",
							"You are another step closer to a healthier life!",
							"The first wealth is health; keep going!");	
		$randomMessage = $messages[rand(0,sizeof($messages)-1)];
		return $randomMessage;
		
	}
    
    if( !isset($_POST['username']) || !isset($_POST['username']) ){
        die("ERROR");
    }
    $username = $_POST["username"];
    $password = $_POST['password'];
    if(loginUser($username,$password)==-1){
        //do something..
        die("ERROR");
    };
    $user = initialize_Variables();
    if($user->type_flag!=2){
        die("ERROR");
    }
    
    $result = getGoalsDummy();
    
    if(sizeof($result) == 0){
        die("<ul class='info'><h3>No goals, yet!</h3>It's never too late to be healthy, don't worry!<br />
				Login to the full system and choose your goals.<br />
				<li> For more information, logout and press the 'about' button.</li></ul>");
    }
    $message = getRandomMessage();
	echo "<ul class='info'>Welcome $user->first_name $user->last_name, $message <br />
			Provide your score for each goal to update your progress.</ul>";
    for($i=0 ; $i<sizeof($result) ; $i++){
        $temp = $result[$i];
        echo "<ul class='rounded'>";
        echo "<li>$temp[0]</li>";
        echo "<li> <input type='text' value='$temp[1]' name='score' class='score_input' autocapitalize='off' autocorrect='off' autocomplete='off'/></li>";
        echo "</ul>";
    }
    echo "<ul> <li><a href='#' onclick='updateScores();' class='greenButton' id='updateButton'> Update your scores! </a></li> </ul>";
    
    
?>