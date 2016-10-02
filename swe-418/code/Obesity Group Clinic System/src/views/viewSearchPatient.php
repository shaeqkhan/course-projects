<?php

        require_once "functions/t_config.php";
        require_once "functions/search_patient.php";
        
        function viewSearchPatient()
        {
                        if(isset($_POST['searchButton']))
		{	
                                $result = search_patient($_POST['first_name'], $_POST['last_name'], $_POST['email'], $_POST['mobile_number']);
		}
		
            ?>
            
            
            <div class="formWrap">
      	<div id="form">
      
      	<form action="searchPatients.php" method="post" id="search">
        	
            <fieldset>
            <legend>Enter Information</legend>
            <div class="row">
        		<label for="first_name" class="label">First Name</label>
        		<input type="text" id="first_name" name="first_name" class="input" maxlength="20" value="" />
        	</div><!-- .row-->
            
            <div class="row">
        		<label for="last_name" class="label">Last Name</label>
        		<input type="text" id="last_name" name="last_name" class="input" maxlength="20" value="" />
        	</div><!-- .row-->
            
                        
            <div class="row">
		    	<label for="email" class="label">E-mail</label>
	        	<input type="text" class="input" id="email" name="email" maxlength="50" value="" />
    		</div><!--end .row-->
		<div class="row">
        		<label for="mobile" class="label">Mobile</label>
        		<input type="text" id="mobile_number" name="mobile_number" class="input" maxlength="20" value="" />
        	</div><!-- .row-->
	    	<!--End Email-->
            
            
                                 
            <input type="submit" name ="searchButton" value="Search" class="button" />
            </fieldset>              
        </form>
        
       	</div><!-- .form -->
        </div><!-- .formWrap -->
	<?php
        if(isset($result) && $result[0] == -1)
		{
			echo "<div class = 'errorMessages'>No search results were found. Please refine your search criteria.</div>";
			return 0;
		}
	?>
        <div id="managePatientGoals">
       	  <!-- call displayPatientsForSearch.php to display table -->
          <fieldset>
			<legend>Search Results</legend>
            <?php  if(isset($result)){
				
		?>
                
       	    <table width="730" border="1">
        	<thead>
      			<tr>  
        	    <th width="180" scope="name">Name</th>
                <th width="180" scope="email">Email</th>
    	        <th width="120" scope="edit">My Path</th>      
        		</tr>
      		</thead>
            
            <tbody>
            <?php

                $result = $result[1];
                //$i=0;
                while( $row = mysqli_fetch_assoc($result) )
		{ 
			?>
            <tr>
        	    <td><a href="AccountProfile.php?id=<?php echo $row['id']; ?>"><?php echo $row['name']; ?></a></td>
        	    <td><?php echo $row['email']; ?></td>
        	    <td><a href="myPath.php?id=<?php echo $row['id']; ?>"><div align="center"><img src="images/myPath.png" width="24" height="24" alt="edit" align="middle"></div></a></td>
      	    </tr>
            <?php
                }
            ?>
            </tbody>
      	  </table>
            <?php } ?>
</fieldset>
          
          
        </div>
        
        <?php
        
        }
        ?>