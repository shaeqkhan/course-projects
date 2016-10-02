 <?php
        //created by Abdulaziz Alamoudi
     
        require_once("functions/getGoalCategory.php");
	    require_once "renderLayout.php";
		function viewGoalCategory(){
			 
		$row = array();
		$rtrn_query = getGoalCatgry();
		
        if($rtrn_query[0] == -1){
		 echo("<div class='errorMessages'>Database Error</div>");	
	    }
		
		elseif($rtrn_query[0] == -2){
		 echo("<div class='errorMessages'>No Categories in the database.</div>");	
	    }
		
		else{
 
?>			 

<div class="formWrap">
      	<div id="form">
        
     
        <div id="currentGoalsforPatient">
          <fieldset>
			<legend>Goal Categories</legend>
       	    <table width="730" border="1">
        	<thead>
      			<tr>  
    	  		<th width="200" scope="goalName">Category Name</th>
                <th width="480" scope="goalDescription">Category Description</th>
    	        <th width="50" scope="">Category ID</th>
                <th width="50" scope=""># Goals</th>
                <!--th width="50" scope="delete"></th-->
        		</tr>
      		</thead>
            
            <tbody>
            <?php
			 $row = array();
			 $rtrn_query = getGoalCatgry();
			 for($i = 0; $i < mysqli_num_rows($rtrn_query[1]); $i++){
				 while($row = mysqli_fetch_row($rtrn_query[1])){
			?>
            <tr>
        	    <td><div align="center"><a href="viewCategoryDetails.php?id=<?php echo $row['0']; ?>">
				<?php echo $row['1']; //ctgry name ?></a></div>
        	    <td><div align="center"><?php echo $row['2']; //ctgry description ?></div></td>
                <td><div align="center"><?php echo $row['0']; //ctgry id ?></div></td>
                <td><div align="center"><?php echo countCatgryGoals($row['0']); ?></div></td>
      	    </tr>
            <?php }} ?>
            </tbody>
      	  </table>
          </fieldset>
          
          
        </div>
        </div>
        </div>
        
      <?php
	  
		}}
		
		?>
<?php

/*     	    <td><!--a href=""><div align="center"><button type="submit" name="deleteButton" id="deleteButton"><img src="images/delete.png" width="24" height="24" alt="delete" align="middle"></button></div></a--><input name="<?php echo($row['2']); ?>" type="submit" value="Delete Category <?php echo($row['2']); ?>" /></td>*/

?>