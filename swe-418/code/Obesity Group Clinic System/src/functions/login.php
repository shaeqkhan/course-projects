<?php

require_once("t_config.php");
require_once ("user.class.php");


/*
 * FUNCTION NAME: loginUser
 * FUNCTION DESCRIPTION: uses pattern to detect wether an email is valid or not.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 * USERS: Anounymous, Admin, HealthTeam members and Patients
 * INPUT: $email to validate.
 * RETURN: true if email valid, false if not
 */
function loginUser($username,$password){
    $userId = User::authenticateUser($username,$password);
    if($userId!=-1){
        $_SESSION['user_id']=$userId;
        return 1;
    }else{
        $_SESSION['user_id']=-1;
        return -1;
    }
}



/*
 * FUNCTION NAME: logoutUser
 * FUNCTION DESCRIPTION: Destroy all session variables, remember to re-initialize the variables afterwards.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 * USERS: Admin, HealthTeam members and Patients
 * INPUT: None
 * OUTPUT: true if logging out is success, false otherwise
 */
function logoutUser(){
    if(isset($_SESSION)){
        return session_destroy();
    }else{
        return false;
    }
}

/*
 * FUNCTION NAME: initializeVariables
 * FUNCTION DESCRIPTION: Initializes the session and the object $user to be used throughout the code. THIS FUNCTION MUST BE ON TOP OF ANY PAGE!
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 * USERS: Anounymous users, Admin, HealthTeam members and Patients
 * INPUT: None
 * RETURN: Object of type $user represents the current logged in user, with all variables set.
 */

function initialize_Variables(){
    if(!isset($_SESSION)){
		//echo "starting...";
        session_start();
		//die(" ".$_SESSION['user_id']);
    }
    if(isset($_SESSION['user_id']) && $_SESSION['user_id'] != -1){
		//die("DIED ".$_SESSION['user_id']);
        $user = new User($_SESSION['user_id']);
    }else{
		//die("OH NO!!");
        $_SESSION['user_id']=-1;
        $user = new User();
    }
    return $user;
    
}


/*
 * FUNCTION NAME: checkEmail
 * FUNCTION DESCRIPTION: uses pattern to detect wether an email is valid or not.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 14, 2011
 *
 *Users: System
 *Input: $email to validate.
 *Return: true if email valid, false if not
 */
function checkEmail($email) {
  if(preg_match("/^([a-zA-Z0-9])+([a-zA-Z0-9\._-]) *@([a-zA-Z0-9_-])+([a-zA-Z0-9\._-]+)+$/",
               $email)){
    return true;
  }
  return false;
}


?>