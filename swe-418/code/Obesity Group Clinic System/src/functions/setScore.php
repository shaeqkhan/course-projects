<?php
require_once("t_config.php");
    /*
     * FUNCTION NAME: setScore
     * FUNCTION DESCRIPTION: Sets the score for the patient's progress to
	 * 					minimize the storage on the db side, the following
	 					table will illustrate the function's behaviour based
						on the values in the database:
						
						LEGEND
						- P = no existing record
						- 0 = zero value
						- x = non zero value
												
						
						|input|				|DB|
							0				P		nothing
							x				P		insert
							o				x		delete
							x				x		update				
						
						
     * AUTHOR: Rakan Al Ghofaily
     * LAST EDIT: Dec 18, 2011
     *
     * USERS: Admin, HealthTeam members and Patients
     * INPUT: $assignId,$date,$score
     * RETURN: 1 if set successfully
     *       -1 if not set successfully
     */
    function setScore($assignId,$date,$score){
	global $conn,$database_conn;
        
        //select the required database
        mysqli_select_db($conn, $database_conn);
        
        $assignId = htmlentities(mysqli_real_escape_string($conn,$assignId));
        $date = htmlentities(mysqli_real_escape_string($conn,$date));
        $score = htmlentities(mysqli_real_escape_string($conn,$score));
        
        
        //check if there is a scored stored for that day alreadys
        $query = "SELECT score from patient_daily_record pdr WHERE pdr.assign_id = $assignId AND pdr.date = '$date'";
        $result = mysqli_query($conn,$query) or die("Unexpected error!");
        
        //if no score stored for that date
        if(mysqli_num_rows($result)<1){
			//And the score is zero, don't add it to the db
			if($score==0){
				return 1;
			}
			//otherwise add it
            $query = "INSERT INTO patient_daily_record(assign_id,date,score) VALUES ($assignId , '$date', $score);";
        }
        //else
        else{
			//if the new score is zero, delete the old score..
			if($score ==0){
				$query = "DELETE FROM patient_daily_record WHERE assign_id=$assignId AND date= '$date';";
			//else update existing score..
			}else{
	            $query = "UPDATE patient_daily_record SET score=$score WHERE assign_id=$assignId AND date= '$date';";
			}
        }
        
        if(mysqli_query($conn,$query)){
            return 1;
        }
        return -1;
        
    }
	
	setScore(5 , '2011-12-08', 1)
?>