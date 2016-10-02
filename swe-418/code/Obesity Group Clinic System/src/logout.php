<?php

require_once "functions/t_config.php";
require_once "functions/login.php";
require_once "functions/user.class.php";
$user = initialize_Variables();
logoutUser();
header("location:index.php");
?>