<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/form.css" rel="stylesheet" type="text/css" />
<link href="css/patientGoals.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/validate.js"></script>

<script type="text/javascript">

			$(document).ready(function() {

				$('#AccountForm').validate({

					rules: {

				first_name: {
				   required: true,
				   maxlength:20

			    },

				last_name: {
				    required: true,
					maxlength:20
				},
				
				gender: {
				    required: true,
				},
				
				mobile_number: {
					maxlength:15
				},
				
				date_of_birth: {
				    required: true,
					date:true
				},
				
				aramco_id: {
					maxlength:11
				},
				
				email: {
				    required: true,
					email:true,
					maxlength:50
				},
				
				username: {
				    required: true,
					maxlength:10
				},
				
				password: {
				    required: true,
					maxlength:50,
					minlength:4
				},
				
				confirm_password: {
				    required: true,
					maxlength:50,
					minlength:4,
					equalTo: "#password"
				},
				
				weight: {
				    required: true,
					maxlength:6,
					number:true
					
				},
				
				height: {
				    required: true,
					maxlength:4,
					number:true
					
				}
					
		}

	});	
});
</script>

<script type="text/javascript" language="javascript">

function autocalc()
{
	var weight = document.getElementById("weight").value;
	var height = document.getElementById("height").value;
	var bmi = document.getElementById("bmi");
	//if one of the weight or the height are == empty string or null, return immediatly
	
	if(isNaN(weight) || isNaN(height)) //filter input
	{
		alert('Numbers only!');
		bmi.value = '';
		weight.value = '';
		height.value = '';
		return;
	}else{
		if(weight <= 0 && height <= 0)
	{	
		bmi.value = '';
		weight.value = '';
		height.value = '';
		return;
	}else{
				bmi.value = (weight/(height*height)).toFixed(2);
		
	}
	}
	//
	
	
	
}
		

</script>
        
      


</head>

<body>

<div class="formWrap">
      	<div id="form">
      
      	<form action="" method="post" id="AccountForm">
        	
            <fieldset>
            <legend>Personal Information</legend>
            <div class="row">
        		<label for="first_name" class="label">First Name</label>
        		<input type="text" id="first_name" name="first_name" class="input" maxlength="20" value="" />
        	</div><!-- .row-->
            
            <div class="row">
        		<label for="last_name" class="label">Last Name</label>
        		<input type="text" id="last_name" name="last_name" class="input" maxlength="20" value="" />
        	</div><!-- .row-->
            
          <div class="row">
       		<label for="gender" class="label">Gender</label>
                  <label>
                    <input type="radio" name="gender" checked="checked" value="m" id="gender_0" />
                    Male</label>
                  <br />
                  <label>
                    <input type="radio" name="gender" value="f" id="gender_1" />
                    Female</label>
            </div><!-- .row-->
            
            <div class="row">
        		<label for="mobile_number" class="label">Mobile Number</label>
        		<input type="text" id="mobile_number" name="mobile_number" class="input" maxlength="15" value="" />
        	</div><!-- .row-->
            
            <div class="row">
        		<label for="date_of_birth" class="label">Date of Birth</label>
        		<input type="text" id="date_of_birth" placeholder="yyyy-mm-dd"  name="date_of_birth" class="input" value="" />
        	</div><!-- .row-->
            </fieldset>
            
            
           <fieldset><legend>Account Information</legend>
    
		   <!--Aramco ID-->

		   <div class="row">
				<label for="aramco_id" class="label">Aramco ID</label>
				<input type="text" class="input" id="aramco_id" name="aramco_id" maxlength="11" value="" />
    		</div><!--end .row-->
    		<!--Aramco ID-->

		    <!--Email-->

			<div class="row">
		    	<label for="email" class="label">E-mail</label>
	        	<input type="text" class="input" id="email" name="email" maxlength="50" value="" />
    		</div><!--end .row-->
	    	<!--End Email-->

		    <!--Username-->
			<div class="row">
	    		<label for="username" class="label">Username</label>
	        	<input type="text" class="input" id="username" name="username" maxlength="10" value="" />
			    </div><!--end .row-->
		    <!--End Username-->

    		<!--Password-->
				<div class="row">
		    	<label for="password" class="label">Password</label>
	        	<input type="password" class="input" id="password" name="password" maxlength="50" value="" />
			    </div><!--end .row-->
		    <!--End Password-->

		    <!--Confirm Password-->
			<div class="row">
	    		<label for="confirm_password" class="label">Confirm Password</label>
        		<input type="password" class="input" id="confirm_password" name="confirm_password"  maxlength="50" value="" />
			    </div><!--end .row-->
		    <!--End Confirm Password-->

			</fieldset>
            
            
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
                                           
                <div class="row">
        		<label for="medicalHistory" class="label">Medical History</label>
        		<textarea name="medicalHistory" id="medicalHistory"></textarea>
        		</div><!-- .row-->
                </fieldset>
            </div><!-- #patientInformation--> 
                       
                    
       	  <input type="submit" value="Create Account" class="button" />
          <input type="reset" value="Reset Form" class="reset" />
                                     
        </form>
        
       	</div><!-- .form -->
        </div><!-- .formWrap -->
        
        <div id="currentGoals">
        	<!-- call currentGoalsForProfile.php to display table -->
        </div><!-- #currentGoals -->
        
        <div id="pastGoals">
        	<!-- call pastGoalsForProfile.php to display table -->
        </div><!-- #pastGoals -->

</body>
</html>