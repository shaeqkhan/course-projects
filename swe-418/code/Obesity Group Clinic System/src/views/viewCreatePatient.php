<?php
	require_once "functions/t_config.php";
	require_once "functions/create_user.php";
	
	
	function viewCreatePatient($array){
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
			$weight = $array['weight'];
			$height = $array['height'];
			$type_flag = 2;
			
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
					echo "<li>Unexpected values, please contact system administrator.</li>";
				}
    			echo "</ul>
					</div>";
			}else{
				echo "<div class='successMessages'>Patient added succcessfully! Maybe you would like to <a href='assignGoal.php?id=$result[1]'>assign him some goals?</a></div>";
			}
		}
		
		include "pages/createPatientForm.php";
	}
?>