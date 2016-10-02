<?php
    
    require_once "../includes/mobileFunctions.php";
    
    
    
    if( !isset($_POST['assID']) || !isset($_POST['score']) ){
        die("ERROR");
    }
    $assID = $_POST["assID"];
    $score = $_POST['score'];

	mob_updateScore($assID,$score);
?>