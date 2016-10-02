<?php

    /*
     * FUNCTION NAME: setScore
     * FUNCTION DESCRIPTION: sets the score for the patient's progress
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
        $query = "SELECT assign_id from patient_daily_record pdr WHERE pdr.assign_id = $assignId AND pdr.date = '$date'";
        $result = mysqli_query($conn,$query) or die("Unexpected error!");
        
        //if no score stored for that dat
        if(mysqli_num_rows($result)<1){
            $query = "INSERT INTO patient_daily_record(assign_id,date,score) VALUES ($assignId , '$date', $score);";
        }
        //otherwise, update existing score
        else{
            $query = "UPDATE patient_daily_record SET score=$score WHERE assign_id=$assignId AND date= '$date';";
        }
        
        if(mysqli_query($conn,$query)){
            return 1;
        }
        return -1;
        
    }
?>