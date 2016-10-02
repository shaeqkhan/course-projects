<?php
	$PAGE_TYPE = "PANEL";						//{ HOME,PANEL,HELP,ABOUT }	
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";
	require_once "views/viewUpdateScores.php";
	require_once "views/viewPastGoals.php";
	require_once "views/viewGoalsAssigned.php";
	require_once "views/viewLastTwoBmi.php";
	require_once "functions/getName.php";
	
	$user = initialize_Variables();
	$operation = 0;	//check the selected operation, default is progress..
	if( isset($_GET['op']) ){
		$operation = $_GET['op'];
		if($operation > 3){
			$operation = 0;
		}
	}
	
	//check the user group
	if(!restrictAccess($user,-1)){
		include "views/pages/forbidden.php";
		die();
	}
	
	//check the gets provided
	$gets = array("id");
	if(!requireGets($gets) ){
		include "views/pages/forbidden.php";
		die();
	}
	
	//check authorization
	if($user->type_flag ==2){	//he is a patient
		if( $user->id != $_GET['id'] ){	//his id not the same as the get id
			include "views/pages/forbidden.php";
			die();
		}
	}
	
	
	
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Aramco OGC - Path</title>
<link rel="stylesheet" media="print" title="Printer-Friendly Style"  />
<link href="css/afterLogin.css" rel="stylesheet" type="text/css" />
<link href="menu/css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/formAccordion.css" rel="stylesheet" type="text/css" />
<link href="css/patientMenuStyle.css" rel="stylesheet" type="text/css" />
<link href="css/scores.css" rel="stylesheet" type="text/css" />
<link href="css/patientGoals.css" rel="stylesheet" type="text/css" />
<link href="css/patientMenuStyle.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>

<script type="text/javascript">
			$(function(){
				// Accordion
				$("#bigAccordion").accordion({ 
				header: "h3",
				autoHeight: false,
				navigation: true,
				event: "click",
				active: <?php
						echo $operation;
						?>
						,
				animated: 'bounceslide'
				
				
				});
				
			});
			
			$(function(){
				// Accordion
				$("#healthSideBar").accordion({ 
				header: "h3",
				autoHeight: false,
				navigation: true,
				event: "click",
				active: 1,
				animated: 'bounceslide'
				
				
				});
				
			});
			
		</script>
        
   

</head>

<body>

<div class="container">

   <?php
   		viewHeader($user,$PAGE_TYPE,$loginStatus);
   ?>
  <div class="sidebar"><?php viewSideBar($user); ?></div>
  
  <div class="content">
     <br />
<br />

<div class="heading">
  <?php if($user->type_flag==2){
			echo "My ";
}		else{
		 	echo getPatientName($_GET['id'])."'s";
}?>			
  Path</div>
    
    <div class="contentBody">
    <!-- Accordion -->
		<div id="bigAccordion">
        
        
			<div id="content1">
				<h3><a href="#">My Current Goals</a></h3>
				<div >
                <?php viewGoalsAssigned(); ?>
              </div>
			</div>
            <div id="content2">
				<h3><a href="#">My Progress</a></h3>
				<div >
                <?php viewUpdateScores(); ?>
                </div>
			</div>
            <div id="content3">
				<h3><a href="#">My Past Goals</a></h3>
				<div >
                <?php viewPastGoals(); ?>
                </div>
			</div>
            <div id="content4">
				<h3><a href="#">My BMI History</a></h3>
				<div>
                	<div align="center"><img src="bmiTrend.php?id=<?php echo $_GET['id']; ?>" alt="My Recent Change">
                    </br>
                    <?php getLastBmi($_GET['id']); ?>
                    
                	</div>
                    <div align="right"><a href="bmiReport.php?id=<?php echo $_GET['id']; ?>" target="_blank"><img src="images/exportExcel.png" alt="Export Detailed Report To Excel"/></a></div>
                </div>
			</div>
            
            
		</div><!--End accordion-->
  </div><!--End accordionBar-->
    <br />
    
  </div>
  <div class="footer">
  	  <?php viewFooter(); ?>
  </div>
  
  

</body>
</html>