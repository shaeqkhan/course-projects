<?php
//By Yasir

        require_once "functions/t_config.php";
        require_once "functions/getAllGoals.php";
        require_once "functions/deleteGoal.php";
        require_once "functions/checkDeletedGoal.php";

        
        
        function viewViewGoals()
        {
	    global $user;
            
            if(isset($_GET['del']))
            {
                $checkingResult = checkDeletedGoal($_GET['del']);
                $checkingResult = $checkingResult[0];
		
		
                if($checkingResult == -2)
                {
		    	echo "<div class='errorMessages'> Goal Not Found! </div>";
			return 0;
                }
                    elseif($checkingResult == -1)
                {
		    	echo "<div class='errorMessages'> Hey! You already deleted this goal </div>";
			return 0;
                }
                else
                {
                    deleteGoal($_GET['del']);
                }
            }
            
            $result = getAllGoals();
	    
	    	if($result[0] == -2)
		{
			echo "<div class='errorMessages'> You already deleted all goals </div>";
			return 0;
		}
            
            
            ?>
            <div class="formWrap">
      	<div id="form">
        
     
        <form action="" method="post" id="viewGoalsForm">
        <div id="currentGoalsforPatient">
          <fieldset>
			<legend>Bank of Ideas</legend>
       	    <table width="730" border="1">
        	<thead>
      			<tr>  
    	  		<th width="120" scope="goalName">Goal Name</th>
                <th width="220" scope="goalDescription">Goal Description</th>
                <th width="110" scope="category">Category</th>
                <th width="110" scope="type">Goal Type</th>
	            <th width="60" scope="min">Min</th>
	            <th width="60" scope="max">Max</th>
		    <th width="50" scope="delete"></th>
        		</tr>
      		</thead>
            
            <tbody>
                <?php
                $result = $result[1];
                while( $row = mysqli_fetch_assoc($result) )
		{ 
			?>
            <tr>
        	    <td><a href="viewGoalDetails.php?id=<?php echo $row['goal_id']; ?>"><div align="center"><?php echo $row['goal_name']; ?></div></a></td>
        	    <td><div align="center"><?php echo $row['goal_description']; ?></div></td>
        	    <td><div align="center"><?php 
				
				if($row['category_name']==NULL)
				{
				$row['category_name']= "No Category";
				}
				echo $row['category_name']; 
				
				
				?></div></td>
        	    <td><div align="center"><?php if($row['goal_type']==0)
				{
				$row['goal_type']= "Incriminatory";
				}
				if($row['goal_type']==1)
				{
				$row['goal_type']= "Decrementory";
				}
				
				 echo $row['goal_type']; ?></div></td>
                <td><div align="center"><?php echo $row['min_point_on_scale']; ?></div></td>
                <td><div align="center"><?php echo $row['max_point_on_scale']; ?></div></td>
		<td><a onclick = "return confirm('Please be aware that <?php echo $row['goal_name'];?> will be permanently deleted. Are you sure?')" href=" listGoals.php?<?php echo '&del=' .$row['goal_id']; ?>"><div align="center"><img src="images/delete.png" width="24" height="24" alt="delete" align="middle"></div></a></td>
      	    </tr>
            <?php
                }
            ?>
            </tbody>
      	  </table>
          </fieldset>
          
          
        </div>
        </form>
        </div>
        </div>
        <?php
        }
?>