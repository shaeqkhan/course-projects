<?php

function dateToDayWeekDate($date){
    $time = strtotime($date);
    $weekDay = date("D",$time);
    switch($weekDay){
        case "Sat": $time = strtotime("-0 days", $time);
                    break;
        case "Sun": $time = strtotime("-1 days", $time);
                    break;
        case "Mon": $time = strtotime("-2 days", $time);
                    break;
        case "Tue": $time = strtotime("-3 days", $time);
                    break;
        case "Wed": $time = strtotime("-4 days", $time);
                    break;
        case "Thu": $time = strtotime("-5 days", $time);
                    break;
        case "Fri": $time = strtotime("-6 days", $time);
                    break;
        default: break;
        
    }
    return array($weekDay,date("Y-m-d",$time));
}
?>