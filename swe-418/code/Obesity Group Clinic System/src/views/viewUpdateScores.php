<?php

	require_once 'functions/t_config.php';
	require_once 'functions/getPatientGoals.php';
	require_once "functions/getScore.php";
	require_once "functions/dateToDayWeekDate.php";
	require_once "functions/updateProgress.php";
	require_once "functions/calculateProgress.php";


function viewUpdateScores(){
	global $today;
	$weekCount = 0;
	$weekCountInt = 0;
	$currentWeek = 0;
	$showNextWeek = false;
	$showPrevWeek = true;
	
	if( isset($_GET['week']) ){
		$weekCountInt = $_GET['week'];
		$currentWeek = $weekCountInt;
		$weekCount=$weekCountInt*7;
	}
	if($weekCountInt>0){
		$showNextWeek = true;
	}
	$weekCount = "-".$weekCount;
	$weekDate = dateToDayWeekDate($today);
	$weekDate = $weekDate[1];
	$weekDate = incrementDate($weekDate,$weekCount);			//decrement actually :)
	
	
	//get the goals
	$goals = get_patient_goals_before_date($_GET['id'],incrementDate($weekDate,"+6"),1);
	if($goals[0]!=1){
		$showPrevWeek=false;
	}
	
	

	
	
	//ERROR HANDLING
	//if both buttons are not to be shown, this means there are no goals assigned
	if(!$showNextWeek && !$showPrevWeek){
		echo "<div class='errorMessages'>You don't have any goals assigned, get some goals and start losing weight!</div>";
		return 0;
	}
	
	if(!$showPrevWeek){
		echo "<div class='errorMessages'>You have no goals assigned in this week!</div>";
		return 0;
	}
	
	
	
	
	
	
	$sat = 0;
	$sun = 0;
	$mon = 0;
	$tue = 0;
	$wed = 0;
	$thu = 0;
	$fri = 0;
	
	
	$goals = $goals[1];
	//PERFORM THE UPDATE -if any-
	if( isset($_POST['updateScores']) ){
		$numOfGoals = mysqli_num_rows($goals);
		for( $i=0 ; $i<$numOfGoals ; $i++ ){
			$sat = 0;
			$sun = 0;
			$mon = 0;
			$tue = 0;
			$wed = 0;
			$thu = 0;
			$fri = 0;
			
			if( isset($_POST['sat'][$i]) ){
				$sat = $_POST['sat'][$i];
			}
			if( isset($_POST['sun'][$i]) ){
				$sun = $_POST['sun'][$i];
			}
			if( isset($_POST['mon'][$i]) ){
				$mon = $_POST['mon'][$i];
			}
			if( isset($_POST['tue'][$i]) ){
				$tue = $_POST['tue'][$i];
			}
			if( isset($_POST['wed'][$i]) ){
				$wed = $_POST['wed'][$i];
			}
			if( isset($_POST['thu'][$i]) ){
				$thu = $_POST['thu'][$i];
			}
			if( isset($_POST['fri'][$i]) ){
				$fri = $_POST['fri'][$i];
			}
			
			
			$scoresArray = array( $sat,$sun,$mon,$tue,$wed,$thu,$fri );
			
			
			updateProgress($_POST['goal_ass_id'][$i] , $weekDate , $scoresArray );
		}
			
		echo "<div class='successMessages'>Your scores has been updated! Keep it up!</div><div class='clr'></div>";
	}
		//RENDER THE FORM HEADER (WEEKS TOGGLE BUTTONS)
	if($showPrevWeek){
	?>
	<div id="lastWeek"><a href="myPath.php?op=1&id=<?php echo $_GET['id']."&week=".($weekCountInt+1); ?>"><img src="images/left.png" width="32" height="32" alt="lastWeek" /></a></div>
    <?php } ?>
  <div id="message"></div>
  <?php
  	if($showNextWeek){
  ?>
  	<div id="nextWeek"><a href="myPath.php?op=1&id=<?php echo $_GET['id']."&week=".($weekCountInt-1); ?>"><img src="images/right.png" width="32" height="32" alt="nextWeek" /></a></div>
    
    <?php
	}
	echo "<div class='clr'></div>";
	
	$dates = array( $weekDate,
					incrementDate($weekDate,"+1"),
					incrementDate($weekDate,"+2"),
					incrementDate($weekDate,"+3"),
					incrementDate($weekDate,"+4"),
					incrementDate($weekDate,"+5"),
					incrementDate($weekDate,"+6") );
	?>
    <fieldset style="width:710px;">
		<legend>Update Scores</legend>
    
    	<form id="scoresForm" action="myPath.php?op=1&id=<?php echo $_GET['id']."&week=$currentWeek"; ?>" method="post" >
      	<table border="1">
      	<thead>
      	<tr>  <th width="110"></th>
      		<th width="70">Sat</th>
            <th width="70">Sun</th>
            <th width="70">Mon</th>
            <th width="70">Tue</th>
            <th width="70">Wed</th>
            <th width="70">Thu</th>
            <th width="70">Fri</th>
            <th width="110">Progress</th>
        </tr>
      </thead>
      
  	<tbody>
    
    	<tr>
    <th>Goals</th>
    <th><?php echo date(" d/M" , strtotime($dates[0]) ); ?></th>
    <th><?php echo date(" d/M" , strtotime($dates[1]) ); ?></th>
    <th><?php echo date(" d/M" , strtotime($dates[2]) ); ?></th>
    <th><?php echo date(" d/M" , strtotime($dates[3]) ); ?></th>
    <th><?php echo date(" d/M" , strtotime($dates[4]) ); ?></th>
    <th><?php echo date(" d/M" , strtotime($dates[5]) ); ?></th>
    <th><?php echo date(" d/M" , strtotime($dates[6]) ); ?></th>
    <th>&nbsp;</th>
  </tr>
  <?php
	
	while( $goal = mysqli_fetch_assoc($goals) ){
		$currentDate = $weekDate;
		$assignId = $goal['assign_id'];
		
		$scores = getScore($assignId,$weekDate,7);
		?>
		<tr>
    <th scope="col"><?php echo $goal['goal_name']; ?>
    				<input type="hidden" value="<?php echo $goal['assign_id']; ?>" name="goal_ass_id[]" id="updateScores" /></th>
    <th scope="col"><input name="sat[]" size="1" 
    <?php
    	  if(  strtotime($dates[0])  <  strtotime( $goal['date_assigned'] )  ||  strtotime(incrementDate($dates[0],"-1"))  >=  strtotime( $today )  ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[0]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><input name="sun[]" size="1"  
    <?php
    	  if(  strtotime($dates[1])  <  strtotime( $goal['date_assigned'] )  ||   strtotime(incrementDate($dates[1],"-1"))  >=  strtotime( $today )  ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[1]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><input name="mon[]" size="1"  
    <?php
    	  if(  strtotime($dates[2])  <  strtotime( $goal['date_assigned'] )   ||   strtotime(incrementDate($dates[2],"-1"))  >=  strtotime( $today ) ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[2]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><input name="tue[]" size="1"  
    <?php
    	  if(  strtotime($dates[3])  <  strtotime( $goal['date_assigned'] )  ||   strtotime(incrementDate($dates[3],"-1"))  >=  strtotime( $today )  ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[3]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><input name="wed[]" size="1"  
    <?php
    	  if(  strtotime($dates[4])  <  strtotime( $goal['date_assigned'] )  ||   strtotime(incrementDate($dates[4],"-1"))  >=  strtotime( $today )  ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[4]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><input name="thu[]" size="1"  
    <?php
    	  if(  strtotime($dates[5])  <  strtotime( $goal['date_assigned'] ) ||   strtotime(incrementDate($dates[5],"-1"))  >=  strtotime( $today ) ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[5]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><input name="fri[]" size="1"  
    <?php
    	  if(  strtotime($dates[6])  <  strtotime( $goal['date_assigned'] )  ||   strtotime(incrementDate($dates[6],"-1"))  >=  strtotime( $today )   ){?>
			disabled="disabled" 
	<?php }
	?> 
    												maxlength="2" type="text" value="<?php echo $scores[6]; ?>" style="text-align: center; background-color:#fff" /></th>
    <th scope="col"><?php echo calculateProgress($goal['assign_id'],$weekDate,7); ?>%</th>
	  </tr>
	<?php
	}
?>
  </tbody>
</table>
<input type="submit" value="Update Scores" name="updateScores" id="updateScores" />
</form>

</fieldset>

	<?php
	
	
	
}



?>