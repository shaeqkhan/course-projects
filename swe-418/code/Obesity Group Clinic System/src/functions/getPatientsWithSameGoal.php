<?php

//yasir
//3/01/2012
//return -1 if an error connection to db
//return -2 if no goal id was given
//returns -3 if no results were found
require_once("t_config.php");
        
        
        
        function getPatientsWithSameGoal($goal_id=-1)
        {
                global $conn, $database_conn;
                
                mysqli_select_db($conn, $database_conn);
                
                $goal_id = htmlentities(mysqli_real_escape_string($conn, $goal_id));
                
                if($goal_id == -1)
                {
                        return array(-2, null);
                }
                
                
$select_stm = "SELECT DISTINCT (patient_goals.patient_id), CONCAT(account_details.first_name, ' ', account_details.last_name) AS name, account_details.gender, account_details.email, account_details.date_of_birth, account_details.mobile_number, account_details.start_date FROM patient_goals, account_details WHERE patient_goals.goal_id = $goal_id AND  patient_goals.patient_id = account_details.id AND patient_goals.current_flag = 1";
                
                $query = mysqli_query($conn, $select_stm);
                
                
                if(!$query)
                {
                        return array(-1, null);
                }
                
                if(mysqli_num_rows($query) == 0)
                {
                        return array (-3, null);
                }
                
                return array(1, $query);
                
                
               
        }
        
 ?>

