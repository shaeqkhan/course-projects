<?php

        require_once "functions/t_config.php";
        require_once "functions/search_account.php";
        
        function viewSearchPatient()
        {
                        if(isset($_POST['searchButton']))
		{	
                                $result = search_patient($_POST['first_name'], $_POST['last_name'], $_POST['email'], $_POST['mobile_number']);
		}
		
            ?>
            
            
            <div class="formWrap">
      	<div id="form">
      
      	<form action="SearchAccounts.php" method="post" id="search">
        	
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
            
            
                                 
            <input type="submit" name = "searchButton" value="Search" class="button" />
            </fieldset>              
        </form>
        
       	</div><!-- .form -->
        </div><!-- .formWrap -->
	<?php
        if(isset($result) && $result[0] == -1)
		{
			echo "<div class = 'errorMessages'>No search results were found. Please redfine your search criteria.</div>";
			return 0;
		}
	?>
        <div id="managePatientGoals">
       	  <!-- call displayPatientsForSearch.php to display table -->
          <fieldset>
			<legend>Search Results</legend>
            <?php
            if(isset($result)){
				
		?>
                
       	    <table width="730" border="1">
        	<thead>
      			<tr>  
        	    <th width="180" scope="name">Name</th>
                    <th width="180" scope="name">Role</th>
                <th width="180" scope="email">Email</th>
	            <th width="100" scope="edit">Modify Account</th>
        		</tr>
      		</thead>
            
            <tbody>
            <?php

                $result = $result[1];
                //$i=0;
                $user_type;
                while( $row = mysqli_fetch_assoc($result) )
		{
                    //0 = Admin, 1 = Health Team, 2 = Patient
                    if($row['type_flag'] == 0)
                    {
                        $user_type = "Admin";
                    }
                    if($row['type_flag'] == 1)
                    {
                        $user_type = "Health Team";
                    }
                    if($row['type_flag'] == 2)
                    {
                        $user_type = "Patient";
                    }
			?>
                    
            <tr>
        	    <td><a href="AccountProfile.php?id=<?php echo $row['id']; ?>"><?php echo $row['name']; ?></a></td>
                    <td><?php echo $user_type; ?></td>
        	    <td><?php echo $row['email']; ?></td>
        	    <td><a href="modifyAccount.php?id=<?php echo $row['id']; ?>"><div align="center"><img src="images/edit.png" width="24" height="24" alt="addGoal" align="middle"></div></a></td>
        	   
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