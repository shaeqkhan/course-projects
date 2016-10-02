<?php

require_once("functions/t_config.php");
require_once("functions/getAccountInfo.php");
require_once "functions/checkActivationOfPatient.php";
require_once "functions/activate_patient.php";
require_once "functions/modifyAccount.php";


      function loadPersonalInformation()
	     
		 
		 {

			 global   $patietn_info,  $patietn_info_result;
			
			if($patietn_info_result[7]=="m")
			{
				$patietn_info_result[7]="Male";
			}
			if($patietn_info_result[7]=="f")
			{
				$patietn_info_result[7]="female";
			}

		   echo"<div class='row'>
        		<label for='first_name' class='label'>First Name:   </label>       		
				<div class='input'>$patietn_info_result[5]</div>
        	</div>
            
            <div class='row'>
        		<label for='last_name' class='label'>Last Name: </label>
        		<div class='input'>$patietn_info_result[6]</div>
        	</div><!-- .row-->
            
          <div class='row'>
       		<label for='gender' class='label'>Gender: </label>
                  <div class='input'>$patietn_info_result[7]</div>
            </div><!-- .row-->
            
            <div class='row'>
        		<label for='mobile_number' class='label'>Mobile Number: </label>
        		<div class='input'>$patietn_info_result[8]</div>
        	</div><!-- .row-->
            
            <div class='row'>
        		<label for='date_of_birth' class='label'>Date of Birth: </label>
        		<div class='input'>$patietn_info_result[9]</div>
        	</div><!-- .row-->
            </fieldset>";
            
		  
		  } 
		  
		  function loadAccountDetial()
		  
		  {
			  
			   global   $patietn_info, $patietn_info_result;
			 echo "  <div class='row'>
				<label for='aramco_id' class='label'>Aramco ID: </label>
				<div class='input'>$patietn_info_result[4]</div>
    		</div><!--end .row-->
    		<!--Aramco ID-->

		    <!--Email-->

			<div class='row'>
		    	<label for='email' class='label'>E-mail: </label>
	        	<div class='input'>$patietn_info_result[1]</div>
    		</div><!--end .row-->
	    	<!--End Email-->

		    <!--Username-->
			<div class='row'>
	    		<label for='username' class='label'>Username: </label>
	        	<div class='input'>$patietn_info_result[2]</div>
			    </div><!--end .row-->
		    <!--End Username-->

    		

			</fieldset>";
			  
			
			  }
		  
		  function loadPatientInformation()
		  {
			  global   $wieght,$hieght,$bmi,$MidHis;
			 
			  
			 echo" <div class='row'>
        		<label for='weight' class='label'>Weight (in kgs): </label>
        		<div class='input'>$wieght</div>
        		</div><!-- .row-->
                
                <div class='row'>
        		<label for='height' class='label'>Height (in meters): </label>
        		<div class='input'>$hieght</div>
        		</div><!-- .row-->
                
                <div class='row'>
        		<label for='bmi' class='label'>Your bmi is: </label>
        		<div class='input'>$bmi</div>
        		</div><!-- .row-->
                                           
                <div class='row'>
        		
				<label for='medicalHistory' class='label'>Medical History: </label>";
				echo"<div class='input'>";
				while ($resulth=mysqli_fetch_row($MidHis))
				{
					
					echo " <li>$resulth[0]</li>";
					}
					
        		 echo "</div></div><!-- .row--></fieldset>
            </div><!-- #accountInformation--> ";
			  
		  }

function viewAccountProfileInfo($user,$id){
	 global   $patien_id,$array,$bmi_result,$wieght,$hieght,$bmi,$patietn_info,
  $patietn_info_result,$MidHis;
	
	  $patien_id=$id;
	  
	  	
		$isAllowedToModify = isAllowedToModify($id,$user->id,$user->type_flag);
		$isAllowedToModify = ($isAllowedToModify==1);
		
	   	$id = $_GET['id'];

	if($isAllowedToModify && isset($_GET['del']))
	{
		deactivatePatient($id);
		echo("<div class='successMessages'>This account has been successfully deactivated. You can activate it again by searching for it.</div>");

	}elseif($isAllowedToModify && isset($_GET['act'])){
		activatePatient($id);
		echo("<div class='successMessages'>This account has been successfully activated. You can activate it again by searching for it.</div>");
	
	}
	if($isAllowedToModify){
	$checkingResult = checkActivationOfPatient($_GET['id']);
						 
echo("<div style='float: right; padding-right: 50px'>");
if($checkingResult == 1)
{

	echo("<a onclick=\"return confirm('Are you sure you want to activate this user? All his goals will be unassigned!')\" href = 'AccountProfile.php?id=$id&del=1'><img src='images/deactivate.png' /></a>");
}
if($checkingResult == -1)
{
	echo("<a href = 'AccountProfile.php?id=$id&act=1'><img src='images/activate.png' /></a>");
}
echo("<a href='modifyAccount.php?id=$id'><img src='images/edit.png' /></a>");
echo("</div>");
echo "<div class='clr'></div>";
	}
		
	  
	 //$array = getAccounttInfo($patien_id);
	 	 $array = getAccountInfo($id);

  //get the bmi info 
 
  
 
 
  
  //get account info
  $patietn_info= $array[1];
  if(!$patietn_info){
	   echo("<div>no such record exist</div>");
	  }
	  else{
  $patietn_info_result= mysqli_fetch_row($array[1]);
  
if($patietn_info_result[10] == 2){
  	$MidHis= getMedicalHistory ($id);
	$bmi_result = getLastBmi($id);
  	$wieght= $bmi_result[0];
  	$hieght=$bmi_result[1];
   	$bmi= round((($wieght)/($hieght*$hieght)),2);
}
	  }
?>
	<div class="formWrap">
      	<div id="form">
      
      	<form action="" method="post" id="viewAccountProfileForm">
        	
       
            
            
            <fieldset>
            <legend>Personal Information</legend>
            <?php loadPersonalInformation(); ?>
            </fieldset>
            
            
           <fieldset><legend>Account Information</legend>
    
		   <!--Aramco ID-->

		  
		  <?php loadAccountDetial(); ?>
			</fieldset>
            
            <?php if($patietn_info_result[10] == 2){?>
            <div id="accountInformation">
           	  <fieldset><legend>Patient Information</legend>
            	
        		 <?php loadPatientInformation(); }?>
              
        </form>
        
       	</div><!-- .form -->
        </div><!-- .formWrap -->
        
        <div id="currentGoals">
        	<!-- call currentGoalsForProfile.php to display table -->
        </div><!-- #currentGoals -->
        
        <div id="pastGoals">
        	<!-- call pastGoalsForProfile.php to display table -->
        </div><!-- #pastGoals -->
<?php
} 
//viewAccountProfileInfo($_GET['user->id'],$_GET['id']);

?>


