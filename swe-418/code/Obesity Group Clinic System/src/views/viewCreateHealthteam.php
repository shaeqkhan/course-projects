<?php
	require_once "functions/t_config.php";
	require_once "functions/create_user.php";
	
	function viewCreateHealthteam($array){
		global $today;
		if( isset($array['email']) )
		{
			$email = $array['email'];
			$username = $array['username'];
			$password = md5($array['password']);
			$aramco_id = $array['aramco_id'];
			$first_name = $array['first_name'];
			$last_name = $array['last_name'];
			$gender = $array['gender'];
			$mobile_number = $array['mobile_number'];
			$date_of_birth = $array['date_of_birth'];
			$assigned_group = NULL;
			$weight = NULL;
			$height = NULL;
			$type_flag = 1;
			$result = create_user($email, $username, $password, $aramco_id, $first_name, $last_name,$gender,$mobile_number,$date_of_birth,$type_flag,$today,1,$assigned_group,$weight,$height);
			if($result[0]!=1){
				echo "<div class='errorMessages'>Check the following error message(s).
    					<ul>";
				if($result[0]==-2){
					echo "<li>Email address already registered!</li>";
				}
				elseif($result[0]==-3){
					echo "<li>Username address already registered!</li>";				}
				else{
					$errorCode = $result[0];
					echo "<li>Unexpected values, please contact system administrator. $errorCode </li>";
				}
    			echo "</ul>
					</div>";
			}else{
				echo "<div class='successMessages'>Healthteam added succcessfully!</div>";
			}
		}
		
		include "pages/createHealthteamForm.php";
	}
?>