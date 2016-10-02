<?php
	require_once "functions/t_config.php";
	require_once "functions/modifyAccount.php";
	require_once "functions/getAccountInfo.php";
	require_once "functions/add_patient_to_bmi_history.php";
	require_once "functions/createMedicalHistory.php";
	
	
	
	function viewModifyAccount($user,$array){
		global $today;
		
		if( isset($array['updaterPassword']) )
		{
			$type_flag = $array['type_flag'];
			//expect additional fields for a patient..
			if($type_flag==2){
				//$weight = $array['weight'];
				//$height = $array['height'];
				//create_patient_bmi();
				if($user->type_flag!=2){
					//$medHistory = $array['history'];
					//insert_patient_MedicalHistory($patient_id, $descrption);
				
				}
			}
			$account_id = $_GET['id'];
			$newPassword = NULL;
			if(isset($array['password'])){
				$newPassword = $array['password'];
			}
			
			$aramco_id = $array['aramco_id'];
			$first_name = $array['first_name'];
			$last_name = $array['last_name'];
			$gender = $array['gender'];
			$mobile_number = $array['mobile_number'];
			$date_of_birth = $array['date_of_birth'];
			$updaterId = $user->id;
			$updaterPassword = $array['updaterPassword'];
			$assigned_group = NULL;
			$weight = NULL;
			$height = NULL;
			$isPatient = false;
			if( isset($array['weight']) ){
				$isPatient = true;
				$weight = $array['weight'];
				$height = $array['height'];
			}
			$medicalHistory = NULL;
			if( isset($array['medicalHistory']) ){
				
				$medicalHistory = $array['height'];
				
			}
			
			if( isset($array['changePassword']) ){
				$flag = 1;
			}else{
				$flag = 0;
			}
			
			$isAllowed = isAllowedToModify($account_id,$user->id,$user->type_flag);
			
			if( $isAllowed != 1 ){
				echo "<div class='errorMessages'>You are not allowed to perform this operation!</div>";
				return 0;
			}
			
			//perform the modification...
			$result = modifyAccount($account_id, $newPassword, $aramco_id, $first_name, $last_name, $gender, $mobile_number, $date_of_birth, $updaterId, $updaterPassword, $flag);
			$success = false;
			if($result!=1){
				if($result==-2){
					if($account_id!=$updaterId){
						echo "<div class='errorMessages'>Invalid password provided! Please make sure you enter YOUR password!!</div>";
					}else{
						echo "<div class='errorMessages'>Invalid password provided!</div>";
					}
				}else{
					echo "<div class='errorMessages'>Error updating account. $result</div>";
				}
			}else{
				echo "<div class='successMessages'>Account updated succcessfully!</div>";
				$success = true;
			}
			
			
			if($success && $type_flag == 2){
				
			}
				if(isset($array['weight'],$array['height']) && $array['weight']!="" && $array['height'] !=""){
					

					
					$updateBMI = create_patient_bmi($account_id,$weight,$height);
			
				}
				if(isset($array['medicalHistory']) && $array['medicalHistory']!=""){
					$medicalHistory = $array['medicalHistory'];
					$updateMedicalHistory = insert_patient_MedicalHistory($account_id, $medicalHistory);
				}
				
			}
		
		loadModifyAccountForm($user,$array);
		
	}
	
	
	function loadModifyAccountForm($user,$array){
		//load the account info
		$account_id = $_GET['id'];
		$isAllowed = isAllowedToModify($account_id,$user->id,$user->type_flag);
			
		if( $isAllowed != 1 ){
			echo "<div class='errorMessages'>You are not allowed to perform this operation!</div>";
			return 0;
		}
		
		$AccountDetails = getAccountInfo($account_id);
		
		if( $AccountDetails[0] != 1 ){
			echo "<div class='errorMessages'>Error loading account information!</div>";
			return 0;
		}
		
		$AccountDetails = $AccountDetails[1];
		$AccountDetails = mysqli_fetch_assoc($AccountDetails);
		
		
		//VIEW THE UPDATE FORM
		?>
       <div class="formWrap">
      	<div id="form">
      
      	<form action="" method="post" name="updateAccountForm" id="updateAccountForm">
        	<input name="type_flag" type="hidden" value="<?php echo $AccountDetails['type_flag'] ?>"/>
            <fieldset>
            <legend>Personal Information</legend>
            <div class="row">
        		<label for="first_name" class="label">First Name</label>
        		<input type="text" id="first_name" name="first_name" class="input" maxlength="20" value="<?php echo $AccountDetails['first_name']; ?>" />
        	</div><!-- .row-->
            
            <div class="row">
        		<label for="last_name" class="label">Last Name</label>
        		<input type="text" id="last_name" name="last_name" class="input" maxlength="20" value="<?php echo $AccountDetails['last_name']; ?>" />
        	</div><!-- .row-->
            
          <div class="row">
       		<label for="gender" class="label">Gender</label>
                  <label>
                  <?php $isMale = ($AccountDetails['gender']=="m"); ?>
                    <input type="radio" name="gender" <?php if($isMale){ ?>checked="checked" <?php } ?> value="m" id="gender_0" />
                    Male</label>
                  <br />
                  <label>
                    <input type="radio" name="gender" <?php if(!$isMale){ ?>checked="checked" <?php } ?> id="gender_1" />
                    Female</label>
            </div><!-- .row-->
            
            <div class="row">
        		<label for="mobile_number" class="label">Mobile Number</label>
        		<input type="text" id="mobile_number" name="mobile_number" class="input" maxlength="15" value="<?php echo $AccountDetails['mobile_number']; ?>" />
        	</div><!-- .row-->
            
            <div class="row">
        		<label for="date_of_birth" class="label">Date of Birth</label>
        		<input type="text" id="date_of_birth" placeholder="yyyy-mm-dd"  name="date_of_birth" class="input" value="<?php echo $AccountDetails['date_of_birth']; ?>" />
        	</div><!-- .row-->
            </fieldset>
            
            
           <fieldset><legend>Account Information</legend>
    
		   <!--Aramco ID-->

		   <div class="row">
				<label for="aramco_id" class="label">Aramco ID</label>
				<input type="text" class="input" id="aramco_id" name="aramco_id" maxlength="11" value="<?php echo $AccountDetails['aramco_id']; ?>" />
    		</div><!--end .row-->
    		<!--Aramco ID-->

		    <!--Email-->

			<div class="row">
		    	<label for="email" class="label">E-mail</label>
	        	<input type="text" class="input" disabled="disabled" id="email" name="email" maxlength="50" value="<?php echo $AccountDetails['email']; ?>" />
    		</div><!--end .row-->
	    	<!--End Email-->

		    <!--Username-->
			<div class="row">
	    		<label for="username" class="label">Username</label>
	        	<input type="text" class="input" id="username" name="username" disabled="disabled" maxlength="10" value="<?php echo $AccountDetails['username']; ?>" />
			    </div><!--end .row-->
		    <!--End Username-->
			
            </fieldset>
            
            <fieldset><legend>Password</legend>
			<!--updaterPassword-->
				<div class="row">
		    	<label for="changePassword" class="label">YOUR Password</label>
	        	<input type="password" class="input" id="updaterPassword" name="updaterPassword" maxlength="50" value="" />
			    </div><!--end .row-->
		    <!--End updaterPassword-->
            
            <!--checkChangePassword-->
				<div class="row">
		    	<label for="changePassword" class="label">Change Password?</label>
	        	<input type="checkBox"  id="changePassword" onclick="togglePasswordFields()" name="changePassword" maxlength="50" value="change" />
			    </div><!--end .row-->
		    <!--End checkChangePassword-->
            
    		<!--Password-->
				<div class="row">
		    	<label for="password" class="label">New Password</label>
	        	<input type="password" disabled="disabled" class="input" id="password" name="password" maxlength="50" value="" />
			    </div><!--end .row-->
		    <!--End Password-->

		    <!--Confirm Password-->
			<div class="row">
	    		<label for="confirm_password" class="label">Confirm Password</label>
        		<input type="password" disabled="disabled" class="input" id="confirm_password" name="confirm_password"  maxlength="50" value="" />
			    </div><!--end .row-->
		    <!--End Confirm Password-->

			</fieldset>
            
            <?php
				if($AccountDetails['type_flag'] == 2){
					//$PatientDetails = get
			?>
            
            
             <div id="patientInformation">
                <fieldset><legend>Patient Information</legend>
                  <div class="row">
                  <label for="weight" class="label">Weight (in kgs)</label>
                  <input type="text" id="weight" name="weight" class="input" maxlength="6" value="" onkeyup="return autocalc()" />
                  </div><!-- .row-->
                  
                  <div class="row">
                  <label for="height" class="label">Height (in meters)</label>
                  <input type="text" id="height" name="height" class="input" maxlength="4" value="" onkeyup="return autocalc()" />
                  </div><!-- .row-->
                  
                  <div class="row">
                  <label for="bmi" class="label">Your bmi is</label>
                  <input type="text" id="bmi" name="bmi" class="input" maxlength="4" readonly="readonly" value="" />
                  </div><!-- .row-->
            
        	    <?php
					if($user->type_flag<2){
				?>
            	<div class="row">
        		<label for="medicalHistory" class="label">Medical History</label>
        		<textarea name="medicalHistory" id="medicalHistory"></textarea>
        		</div><!-- .row-->
    	        <?php
					}
				?>
            </fieldset>
           	<?php
				}
			?>
            
            
            
            
            
            
            
                                 
                    
       	  <br>
			<input name="update" type="submit" value="Update Account" class="button" />
          <input type="reset" value="Reset Form" class="reset" />
                                     
        </form>
        
       	</div><!-- .form -->
        </div><!-- .formWrap --> 
        
        
        
        
        
        
        
               
        
        
        
        <?php
	}
?>