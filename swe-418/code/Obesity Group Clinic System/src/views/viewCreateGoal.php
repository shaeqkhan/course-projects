<?php
	require_once "functions/t_config.php";
	require_once "functions/create_goal.php";
	require_once"viewLoadCategoryId.php";
	
	function viewCreateGoal(){

		//echo "hello world<br />";
		if( isset($_POST['goal_name']) ){
			$goal_name = $_POST['goal_name'];
			$goal_desc = $_POST['goal_description'];
			$goal_cat_id = $_POST['goal_category'];
			$goal_type = $_POST['goal_type'];
			$min_point_on_scale = $_POST['min_point_on_scale'];
			$max_point_on_scale = $_POST['max_point_on_scale'];
	
			$result = create_goal($goal_cat_id, $goal_name, $goal_desc, $goal_type, $min_point_on_scale, $max_point_on_scale);

			if($result[0]!=1){
				echo "<div class='errorMessages'>Error Connecting DataBase</div>";
			}
			
			
			if($result[0]==1){
				echo "<div class='successMessages'>Goal  added succcessfully!</div>";
			}
		
		}
		?>
        
        <div class="formWrap">
      	<div id="form">
               
                <fieldset>

      <legend>Create Goal </legend>
        <form action="" method="post" id="createNewGoalForm">
            
        <!--Goal Name-->
        <div class="row">
            <label for="goal_name" class="label">Goal Name</label>
            <input type="text" id="goal_name" name="goal_name" class="input" maxlength="30" value="" />
        </div><!--end .row-->
        <!--End Goal Name-->
        
        <!--Goal Description-->
        <div class="row">
            <label for="goal_description" class="label">Goal Description</label>
            <textarea id="goal_description" name="goal_description" ></textarea>
        </div><!--end .row-->
        <!--End Goal Description-->
        
        <!--Goal Category-->

        <div class="row">
                <label for="goal_category" class="label">Goal Category</label>
               <select name='goal_category' id='goal_category' maxlength='30'> 
        
        <?php
			loadCategory();
		?>
        
					  </select>
		   
			 
           
           
        </div><!--end .row-->
        <!--End Goal Category-->
        
        <!--Goal Type-->
        <div class="row">
            <label for="goal_type" class="label">Goal Type</label>
                  <label>
                    <input type="radio" name="goal_type" checked="checked" value="0" id="goal_type_0" />
                    Incremental</label>
                  <br />
                  <label>
                    <input type="radio" name="goal_type" value="1" id="goal_type_1" />
                    Decremental</label>
        </div><!--end .row-->
         <!--End Goal Type-->
         
         <!--Goal Minimum Point on Scale-->
        <div class="row">
            <label for="min_point_on_scale" class="label">Min. Point on Scale</label>
            <input type="text" class="input" id="min_point_on_scale" name="min_point_on_scale" value="" />
        </div><!--end .row-->
        <!--End Goal Minimum Point on Scale-->
        
        <!--Goal Maximum Point on Scale-->
        <div class="row">
            <label for="max_point_on_scale" class="label">Max. Point on Scale</label>
            <input type="text" class="input" id="max_point_on_scale" name="max_point_on_scale" value="" />
        </div><!--end .row-->
        <!--End Goal Maximum Point on Scale-->
        
        <!--Add Goal Button-->
        <input type="submit" id="submit" name="submit" class="button" value="Create Goal" />
        <!--End Add Goal Button-->
        
        <!--Reset Form Button-->
        <input id="reset" name="reset" type="reset" class="reset" value="Reset Form">
        <!--End Reset Form Button-->
    
    </form>
                       </fieldset>
 
        
        </div>
</div>

        
        
        <?php
	}

	
?>