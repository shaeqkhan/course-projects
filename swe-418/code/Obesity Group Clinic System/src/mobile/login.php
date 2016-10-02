<?php
    
    require_once "../includes/mobileFunctions.php";
    
    
    
    if( !isset($_POST['username']) || !isset($_POST['username']) ){
        die("ERROR");
    }
    $username = $_POST["username"];
    $password = $_POST['password'];
    if(loginUser($username,$password)==-1){
        //do something..
        die("ERROR");
    };
	mob_viewPatientGoals();
?>