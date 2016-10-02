<?php
	$PAGE_TYPE = "HOME";					//{ HOME,PANEL,HELP,ABOUT }	
	$loginStatus = 0;
	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";
	
	$user = initialize_Variables();
	
	if( isset( $_POST['login'] ) ){
		$loginStatus = 1;
		$email = $_POST['login-email'];
		$password = $_POST['login-password'];
		
		//if login successful
		if( loginUser($email,$password)==1 ){
			$user = initialize_Variables();
			header("location:panel.php");
		}
	}
	
	
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<?php
	loadHead($PAGE_TYPE);
?>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Aramco OGC - Home</title>


</head>

<body>

<div class="container">

   <?php
   		viewHeader($user,$PAGE_TYPE,$loginStatus);
   ?>
    
  <div class="content">
  
    <div class="contentBody">
    <div id="gallery">

	<a href="#" class="show">
		<img src="images/food.jpg" alt="Food" width="600" height="400" title="" alt="" rel="<h3>Heathy Food</h3>Healthy eating simply means eating wholesome and balanced food that contributes to good health and eliminating foods that leads to illness, diseases and health problems. Healthy foods are foods and beverages that contain the essential nutrients, are low in saturated and trans-fats, salt and sugar. "/>
	</a>
	
	<a href="#">
		<img src="images/sleeping.jpg" alt="Sleeping" width="600" height="400" title="" alt="" rel="<h3>Sleeping</h3>How might disruption of the body's natural clock, called the circadian rhythm, through sleep deprivation affect metabolic hormones that regulate appetite? Research has shown that sleeping less than 6 hours per night and remaining awake past midnight increased thelikelihood of obesity. "/>
	</a>
	
	<a href="#">
		<img style="font-size:12px;" src="images/walking.jpg" alt="Walking" width="600" height="400" title="" alt="" rel="<h3>Walking</h3>Walking is the most democratic of activities and is great for building fitness. According to the World Health Organisation: A walker loses weight, lowers cholesterol, reduces conditions associated with hypertension, slows aging and the decline of aerobic capacity, increases strength, flexibility and balance, strengthens bones and increases stamina."/>
	</a>

	<a href="#">
		<img src="images/water.jpg" alt="Drinking" width="600" height="330" title="" alt="" rel="<h3>Drinking Water</h3>Drinking a healthy amount of water is vital to your health. You can never imagine just by drinking a healthy amount of water, you gain tremendous health benefits, and sometimes you
can even throw away your migraine medicine or pain killer."/>
	</a>

	<div class="caption" style="width:600px;"><div class="content"></div></div>
</div>
<div class="clear"></div>

<br/><br/>
    </div>
    
  </div>
  
  <div class="accordionBar">
  <!-- Accordion -->
		<div id="accordion">
			<div>
				<h3><a href="#">Home</a></h3>
				<div>
                Welcome to the Obesity Group Clinic! This is an initiative by Dr. Essam Jalal to provide people with an opportunity to take part in his program in 			                an effort to loose weight and make themselves physically fit. This website helps you to keep track of your goals for weight loss and monitor your                progress. Please contact Dr. Essam on more information about this program.
                </div>
			</div>
			<div>
				<h3><a href="#">Bank of Ideas</a></h3>
				<div>
                    
                    <div id="subheading">Walking:</div> gain a point for each set of 10 minutes you walk<p></p>
                    <div id="subheading">Sitting:</div> loose a point each time you sit for more than 10 minutes<p></p>
                    <div id="subheading">Water:</div> gain a point for each glass of water in a day<p></p>
                    <div id="subheading">Sugar:</div> loose a point each time you consume a meal with simple sugar<p></p>
                    <div id="subheading">Sleep:</div> gain a point for each hour you sleep through the night<p></p>
                    <div id="subheading">Fruits and Vegetables:</div> gain a point for each meal you take with fruits and vegetables<p></p>
                    <div id="subheading">Multiple Meals:</div> gain a point for having multiple meals in a day<p></p>
                    <div id="subheading">Healthy Cooking:</div> gain a point for making a healthy meal in a day<p></p>
                    <div id="subheading">Portion Control:</div> gain a point for the number of portions your meal divides to
                    
                </div>
			</div>
			<div>
				<h3><a href="#">Mission</a></h3>
				<div>
                The clinic aims to provide the best service to its patients and customize goals that is 

				best suited to each individual. Your progress will be monitored by the doctor and 

				yourself. You are also given the freedom to add or change your goals in case you feel you 

				can do a lot more than you have been assigned.
                </div>
			</div>
            
            <div>
				<h3><a href="#">About</a></h3>
				<div>
                The Obesity Group Clinic has been started under the supervision of Dr. Essam Jalal with 

				some volunteers to raise awareness amongst the Saudi Aramco community about the side 

				effects of obesity and help them to a change in life style that would reduce this growing 

				problem. 
                </div>
			</div>
            
		</div>
  </div>
  
  <div class="footer">
  	  <?php viewFooter(); ?>
  </div>
</div>

</body>
</html>