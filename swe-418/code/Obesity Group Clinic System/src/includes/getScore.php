<?php
    require_once "t_config.php";
    /*
     * FUNCTION NAME: getScore
     * FUNCTION DESCRIPTION: gets the progress of one of the goals for a specific
     * period of time
     * AUTHOR: Rakan Al Ghofaily
     * LAST EDIT: Dec 18, 2011
     *
     * USERS: Admin, HealthTeam members and Patients
     * INPUT: $assignId,$date [of the first day], $number of days
     * RETURN: score(s) or 
     *       -1 if not successful
     */
    function getScore($assignId,$date,$days=1){
	global $conn,$database_conn;
        
        //select the required database
        mysqli_select_db($conn, $database_conn);
        
        $assignId = htmlentities(mysqli_real_escape_string($conn,$assignId));
        $date = htmlentities(mysqli_real_escape_string($conn,$date));
        $days = htmlentities(mysqli_real_escape_string($conn,$days));
        
        //calculate the date of the last day of that period
        $time = strtotime($date);
        $lastDayDate=  date("Y-m-d",strtotime("+ $days days",$time));
        
        //select the score and date for every day between the date and the lastDate date..
        $query = "SELECT score,date FROM patient_daily_record pdr WHERE pdr.assign_id = $assignId AND pdr.date< '$lastDayDate' AND pdr.date>='$date'";
        $result = mysqli_query($conn,$query);
        //die($query);
        //loop through the result and copy values to the result array according to the correct dates in the correct order..
        $i=0;
        $record=array();
        $row = mysqli_fetch_assoc($result);     //get the first record
        $flag=0;
        while( $i < $days ){

            //iterates iDate through the number of days
            $time = strtotime($date);
            $time = strtotime("+ $i days",$time);
            $iDate = date("Y-m-d",$time);
            
            if( $row['date'] == $iDate ){       //if the current Date matches the current iDate iteration
                $record[$i]=$row['score'];
                $i++;
                $row = mysqli_fetch_assoc($result);
            }else{                              //else set current array element to 0; because no entry matches the same date.
                $record[$i]=0;
                $i++;
            }
        }              
            
            
        return $record;
    }
    
    $myGoals = getScore(1,"2011-03-04",0);
    for($i=0 ; $i<sizeof($myGoals) ; $i++){
        echo $myGoals[$i];
        echo "<br>";
    }
?>