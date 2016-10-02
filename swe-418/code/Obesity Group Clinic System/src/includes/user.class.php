<?php

require_once ("t_config.php");
/*
 * CLASS NAME: User
 * CLASS DESCRIPTION: Holds information about a specific user.
 * ClASS USAGE: Construct the object defining the id of the account in the db
 *              and all account variables will be loaded from the database. To
 *              create object for anounymous users just use default constructor.
 * AUTHOR: Rakan Al Ghofaily
 * LAST EDIT: Dec 15, 2011
 *
 * CONSTRUCTOR INPUT: void or {$id [the id of the user]}
 * PROPERTIES: {id, email, username, aramco_id, first_name, last_name, gender,
 *              mobile_number, date_of_birth, type_flag, active_flag AND
 *              assigned group}
 */

class User{
    
    // DECLARE PROEPRTIES
    public $id;                 //-1 for anounymous users
    public $email;
    public $username;
    public $aramco_id;
    public $first_name;
    public $last_name;
    public $gender;
    public $mobile_number;
    public $date_of_birth;
    public $type_flag;          //Range [-1,2]
    public $active_flag;        //Range [0,1]
    public $assigned_group;     //null if no group is assigned.

    

    //DEFINE CONSTRUCTOR - default returns an anounymous user representation.
    function User($id=-1){
        if($id==-1){
            $this->id = -1;
            $this->first_name="Guest";
            $this->type_flag=-1;
            return $this;
        }
        
        global $conn,$database_conn;
        mysqli_select_db($conn, $database_conn);
        
        //Query to load details
        $query = "SELECT * from account_details ad WHERE ad.id = '$id'";
        $result = mysqli_query($conn,$query) or die();
        $user = mysqli_fetch_assoc($result);
        
        //If invalid user id was provided, die and terminate the progoram
        //Otherwise, initialize all properties
        if(mysqli_num_rows($result)<1){
            die("Unexpected error occurred! Please contact system administrator!");
        }else{
            $this->id = $id;
            $this->email = $user['email'];
            $this->username = $user['username'];
            $this->aramcoId = $user['aramco_id'];
            $this->first_name = $user['first_name'];
            $this->last_name = $user['last_name'];
            $this->gender = $user['gender'];
            $this->mobile_number = $user['mobile_number'];
            $this->date_of_birth = $user['date_of_birth'];
            $this->type_flag = $user['type_flag'];
            $this->active_flag = $user['active_flag'];
            $this->assigned_group = $user['assigned_group'];
        }
    }
    
    /*
     * FUNCTION NAME: authenticateUser
     * FUNCTION DESCRIPTION: Static function that will validate the
     * username/email and password against the database.
     * AUTHOR: Rakan Al Ghofaily
     * LAST EDIT: Dec 15, 2011
        *
     * USERS: Anounymous users, Admin, HealthTeam members and Patients
     * INPUT: $username [username or email] and the non hashed password
     * RETURN: 1 if credentials are valid
     *       -1 if credentials are invalid
     */
    public static function authenticateUser($username,$password){
        global $conn,$database_conn;   
	
        //select the required database
        mysqli_select_db($conn, $database_conn);
        $username = htmlentities(mysqli_real_escape_string($conn,$username));
        $password = htmlentities(mysqli_real_escape_string($conn,md5($password)));
        
        if(checkEmail($username)){
            $query = "SELECT id from account_details ad WHERE ad.email = '$username' AND ad.password = '$password' AND active_flag=1";
        }else{
            $query = "SELECT id from account_details ad WHERE ad.username = '$username' AND ad.password = '$password' AND active_flag=1";
        }
        

        $result = mysqli_query($conn,$query) or die();
        $account = mysqli_fetch_assoc($result);
        
        if(mysqli_num_rows($result)<1){
            return -1;
        }else{
            return $account['id'];
        }
}
    
    
}
?>