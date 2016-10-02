<?php
	require_once "functions/t_config.php";
	require_once "functions/add_goal_cat.php";
	
	
	function viewCreateGoalCategory(){
		
		if( isset($_POST['category_name']) ){
			$cat_name = $_POST['category_name'];
			$cat_dis = $_POST['category_description'];
			$result = add_goal_cat($cat_name,$cat_dis);
			if($result[0]==-1){
				echo "<div class='errorMessages'>One of the fields is empty</div> ";
			}
			
			if($result[0]==-2){
				echo "<div class='errorMessages'>Category is already existed</div> ";
			}
			if($result[0]==-3){
				echo "<div class='errorMessages'>ERROR Connecting to the database</div> ";
			}
			
			
			
			
			if($result[0]==1){
				echo "<div class='successMessages'>Goal Categroy added succcessfully!</div>";
			}
		
		}
?>
	
    <div class="formWrap">
      	<div id="form">
        
        <fieldset>
           <legend>Create Goal Category  </legend>
        <form action="" method="post" id="ViewCreateGoalCategory">
        
                <!--Category Name-->
            <div class="row">
                <label for="category_name" class="label">Category Name</label>
                <input type="text" id="category_name" name="category_name" maxlength="30" value="" />
            </div><!--end .row-->
            <!--End Category Name-->
            
            <!--Category Description-->
            <div class="row">
                <label for="category_description" class="label">Category Description</label>
                    <textarea id="category_description" name="category_description" ></textarea>
            </div><!--end .row-->
            <!--End Category Description-->
            
            
            <!--Add Category Button-->
            <input type="submit" id="submit" name="submit" class="button" value="Create Category" />
            <!--End Add Category Button-->
            
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
	
    
    
   
	
	

