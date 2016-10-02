<?php
    require_once "functions.php";
    
    print_r( mysqli_fetch_assoc(view_patient_goals(2)) );
?>