<?php

 /*
 Created by Shaeq Khan
 Edited by Abdulaziz Alamoudi
 */

?>
<?php
  //requires the "get_all_goals_for_ctgry.php" to get the goals that belong to a certain category
  //require_once("../functions/get_all_goals_for_ctgry.php");
    //require_once "renderLayout.php";
    require_once("functions/get_all_goals_for_ctgry.php");

  
  //gets the category id that is mentioned in the address bar
  
  
  //this function displays the goals that belong to the category mentioned
  function viewGoalsByCtgry($ctgry_id){
	  	
	  
	  //this variables gets the query returned by "get_all_goals_for_ctgry.php" 
	  $fetched_query = getAllGoalsForCtgry($ctgry_id);
	  
	  if($fetched_query[0] == -1){
		 echo("<div class='errorMessages'>Database Error</div>");			  
	  }
	  
	  elseif($fetched_query[0] == -2){
		 echo("<div class='errorMessages'>No goals belong to this category</div>");			  
	  }
	  
	  else{
		  $ctgry_info_query = getCategoryInfoById($ctgry_id);
		  $ctgry_info = mysqli_fetch_assoc($ctgry_info_query);

?>


<fieldset>
    <legend>Goal Category</legend>
    <div class="row">
        <label for="category_name" class="label"><strong>Category Name</strong></label>
        <div class="input"><?php echo $ctgry_info['category_name']; ?></div>
    </div><!-- .row-->
    
    <div class="row">
        <label for="category_description" class="label"><strong>Category</strong> Description</label>
        <div class="input"><?php echo $ctgry_info['category_description']; ?></div>
    </div><!-- .row-->
    

</fieldset>              

        
<div id="viewGoalsForCategory">
       	  
<fieldset>
			<legend>Goal Information</legend>
       	    <table border="1">
        	<thead>
      			<tr>  
        	    <th width="100" scope="goal_name">Goal Name</th>                
                <th width="200" scope="goal_description">Goal Description</th>
                <th width="100" scope="goal_type">Goal Type</th>
	            <th width="100" scope="min_points">Min Points</th>
    	        <th width="100" scope="max_points">Max Points</th>
	            <th width="100" scope="number_of_patients">Patients Count</th>        
        		</tr>
      		</thead>
            
            <tbody>
            
			<?php 
			    //the following while loop fetches the required goals that belong to a certain category
			    while($fetched_goals = mysqli_fetch_assoc($fetched_query[1])){
				
				$re=$fetched_goals['goal_type'];
				
				if($re==0){
					$re="Incremental";
				}
				
				if($re==1){
					$re="Decremental";
				}
			 ?>

            <tr><!--print the required goal information-->
        	    <td><a href="viewGoalDetails.php?id=<?php echo($fetched_goals['goal_id']); ?>"><?php echo($fetched_goals['goal_name']); ?></a></td>
        	    <td><?php echo($fetched_goals['goal_description']); ?></td>
        	    <td><?php echo($re); ?></td>
        	    <td><?php echo($fetched_goals['min_point_on_scale']); ?></td>
        	    <td><?php echo($fetched_goals['max_point_on_scale']); ?></td>
                <td><?php echo(getNumOfPatients($fetched_goals['goal_id'])); ?></td>
                <!--gets the number of patients assigned to a goal-->
      	    </tr>
            
            <?php } ?>
            
            </tbody>
      	  </table>
</fieldset>
          
          
</div><!-- #viewGoalsForCategory-->

<?php }} ?>