<?php

require_once("t_config.php");
require_once "getAccountInfo.php";
/*
 * FUNCTION NAME: modifyAccount
 * FUNCTION DESCRIPTION: Check whether a user can perform an update to a profile 
 *						 according to the following rules
 * 					ADMIN:		 can update everyone
 *					HEALTHTEAM:	 can update himself and patinets
 *					PATINET:  	 can update himself only
 *
 * AUTHOR: Rakan Al-Ghofaily
 * LAST EDIT: Dec 27, 2011
 * LAST TESTED: Dec 28, 2011
 * Users: OGCT Member
 * returns   1 : modified
 			-1 : unknown updater 
			-2 : invalidPassword
			-3 : query/ connection error
 *			
 * FLAG 0 -> don't update password
 		1 -> update password
 */
 
function modifyAccount($account_id, $newPassword, $aramco_id, $first_name, $last_name, $gender, $mobile_number, $date_of_birth, $updaterId, $updaterPassword, $flag){
	
	global $conn,$database_conn;

	$newPassword = md5($newPassword);
	$updaterPassword = md5($updaterPassword);
	
	$account_id = htmlentities(mysqli_real_escape_string($conn,$account_id));
	$newPassword = htmlentities(mysqli_real_escape_string($conn,$newPassword));
	$aramco_id = htmlentities(mysqli_real_escape_string($conn,$aramco_id));
	$first_name = htmlentities(mysqli_real_escape_string($conn,$first_name));
	$last_name = 	htmlentities(mysqli_real_escape_string($conn,$last_name));
	$gender = htmlentities(mysqli_real_escape_string($conn,$gender));
	$mobile_number = htmlentities(mysqli_real_escape_string($conn,$mobile_number));
	$date_of_birth = htmlentities(mysqli_real_escape_string($conn,$date_of_birth));
	$updaterId = htmlentities(mysqli_real_escape_string($conn,$updaterId));
	$updatrePassword = htmlentities(mysqli_real_escape_string($conn,$updaterPassword));

	
	$updaterDetails = getAccountInfo($updaterId);
	if($updaterDetails[0] != 1){

		return -1;
	}
	$updaterDetails = $updaterDetails[1];
	$updaterDetails = mysqli_fetch_assoc($updaterDetails);

	if($updaterPassword != $updaterDetails['password']){
		return -2;
	}
	
	$query="UPDATE account_details
				SET first_name='$first_name' 
				, last_name='$last_name' 
				, aramco_id='$aramco_id' 
				, mobile_number='$mobile_number' 
				, gender='$gender' 
				, date_of_birth='$date_of_birth' ";
				
		
	if($flag==1){
		$query.=", password='$newPassword' ";
	}
	$query.= " WHERE id = '$account_id';";
	
	if(!mysqli_query($conn,$query)){

		return -3;
	}

	return 1;
	
}




 /*
 * FUNCTION NAME: isAllowedToModify
 * FUNCTION DESCRIPTION: Check whether a user can perform an update to a profile 
 *						 according to the following rules
 * 					ADMIN:		 can update everyone
 *					HEALTHTEAM:	 can update himself and patinets
 *					PATINET:  	 can update himself only
 *
 * AUTHOR: Rakan Al-Ghofaily
 * LAST EDIT: Dec 26, 2011
 * LAST TESTED: Dec 28, 2011
 * Users: OGCT Member
 * Input: accountId,  updaterId , updaterType (type_flag)
 * returns   1 : allowed to modify
 			-1 : NOT allowed to modify 
			-2 : no such patient
			-3 : query/ connection error
 */
function isAllowedToModify($accountId,$updaterId,$updaterType){
	global $conn,$database_conn;
	if( $accountId == $updaterId ){
		return 1;
	}
	if( $updaterType == 0 ){
		return 1;
	}
	$targetAccountDetails = getAccountInfo($accountId);
	
	if( $targetAccountDetails[0] != 1 ){
		return -2;
	}
	$targetAccountDetails = $targetAccountDetails[1];
	$targetAccountDetails = mysqli_fetch_assoc($targetAccountDetails);
	
	if( $targetAccountDetails['type_flag'] > $updaterType){
		return 1;
	}
	return -1;
}

?>