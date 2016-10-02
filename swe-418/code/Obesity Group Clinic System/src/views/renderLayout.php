<?php
//RaKaN

	require_once "functions/t_config.php";
	require_once "functions/user.class.php";
	
	//load the head of the page
	function loadHead($PAGE_TYPE){
		if($PAGE_TYPE=="PANEL"){
			?>
            <link href="css/afterLogin.css" rel="stylesheet" type="text/css" />
			<link href="menu/css/stylesheet.css" rel="stylesheet" type="text/css" />
			
            <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
			<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
            <style type="text/css">
            	@import url("css/patientGoals.css");
				@import url("css/style.css");
				@import url("css/form.css");
				@import url("css/scores.css");
				@import url("css/patientMenuStyle.css");
				
            </style>
            <script type="text/javascript">
			$(function(){

				// Accordion
				$("#healthSideBar").accordion({ 
				header: "h3",
				autoHeight: false,
				navigation: true,
				});
	
			});
		</script>            
        <script type="text/javascript">
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
			
			<?php
		}else{
			?>
			<link href="css/beforeLogin.css" rel="stylesheet" type="text/css" />
			<link href="menu/css/stylesheet.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="js/jquery-1.3.1.min.js"></script>
			<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
			<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
			<script type="text/javascript" src="js/scripts.js"></script>
			<link href="css/slider.css" rel="stylesheet" type="text/css" />
			<link href="css/accordionBar.css" rel="stylesheet" type="text/css" />
            
            <?php
		}
	}
	
	
	//loginStatus = 1 => failed Login
	//loginStatus = 0 => no failed login
	function viewHeader($user,$PAGE_TYPE,$loginStatus=0){
		//die( " ".$user->type_flag );
		if($PAGE_TYPE=="HOME"){
			?>
			<div class="menu">
				<ul class="menubar">
                <li><a href="index.php" class="active"><span>Home</span></a></li>
                <?php if($user->type_flag != -1){ ?>
				<li><a href="panel.php"><span>Panel</span></a></li>
                <?php } ?>
				<li><a href="about.php"><span>About</span></a></li>
                <li><a href="mailto:essam.jalal@aramco.com"><span>Contact Us</span></a></li>
				<li><a href="help.php"><span>Help</span></a></li>
				</ul>
			</div>
			
			<div class="header">
				<div class="logo"><img src="images/header-logo.gif" height="150"  alt="logo" /></div>
				<?php
					if( $user->type_flag == -1 ){
					?>	
					<div id="loginArea">
                  <form id="loginForm" name="loginForm" action="" method="post">
                    
                    <table width="350" border="0">
                      <tr>
                        <td>Email</td>
                        <td>Password</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td><input id="email" name="login-email" type="text" /></td>
                        <td><input id="password" name="login-password" type="password" /></td>
                        <td><input type="submit" name="login" id="login" value="Login" /></td>
                      </tr>
                      <tr>
                        <td></td>
                        <td colspan="2"><div class="loginError" align="center">
                        	<?php
							if($loginStatus==1){
							?>
                        			Authentication Failed!
                                    
                            <?php
							}
							?>
                            </div></td>	
                        </tr>
                    </table>
                    
                  </form>
                </div>
                    <?php
					}else{
					?>	
                    
					<div class="welcomeMessage">Welcome <?php echo $user->first_name." ".$user->last_name; ?>, <a href="logout.php">Logout</a></div>
                    
                    <?php
					}
				?>
			</div>
            <?php
			
			
			
			
		}elseif($PAGE_TYPE=="PANEL"){
			?>
			<div class="menu">
				<ul class="menubar">
                <li><a href="index.php"><span>Home</span></a></li>
				<li><a href="panel.php" class="active"><span>Panel</span></a></li>
				<li><a href="about.php"><span>About</span></a></li>
                <li><a href="mailto:essam.jalal@aramco.com"><span>Contact Us</span></a></li>
				<li><a href="help.php"><span>Help</span></a></li>
				</ul>
			</div>
			
			<div class="header">
				<div class="logo"><img src="images/header-logo.gif" height="150"  alt="logo" /></div>
				<div class="welcomeMessage">Welcome <?php echo $user->first_name." ".$user->last_name; ?>, <a href="logout.php">Logout</a></div>
			</div>
			
           	<?php
			
			
			
		}elseif($PAGE_TYPE=="ABOUT"){
			?>
			<div class="menu">
				<ul class="menubar">
                <li><a href="index.php"><span>Home</span></a></li>
                <?php if($user->type_flag != -1){ ?>
				<li><a href="panel.php"><span>Panel</span></a></li>
                <?php } ?>
				<li><a href="about.php" class="active"><span>About</span></a></li>
                <li><a href="mailto:essam.jalal@aramco.com"><span>Contact Us</span></a></li>
				<li><a href="help.php"><span>Help</span></a></li>
				</ul>
			</div>
			
			<div class="header">
				<div class="logo"><img src="images/header-logo.gif" height="150"  alt="logo" /></div>
				<?php
					if( $user->type_flag == -1 ){
					?>	
					<div id="loginArea">
                  <form id="loginForm" name="loginForm" action="" method="post">
                    
                    <table width="350" border="0">
                      <tr>
                        <td>Email</td>
                        <td>Password</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td><input id="email" name="login-email" type="text" /></td>
                        <td><input id="password" name="login-password" type="password" /></td>
                        <td><input type="submit" name="login" id="login" value="Login" /></td>
                      </tr>
                      <tr>
                        <td></td>
                        <td colspan="2"><div class="loginError" align="center">
                        	<?php
							if($loginStatus==1){
							?>
                        			Authentication Failed!
                                    
                            <?php
							}
							?>
                            </div></td>	
                        </tr>
                    </table>
                    
                  </form>
                </div>
                    <?php
					}else{
					?>	
                    
					<div class="welcomeMessage">Welcome <?php echo $user->first_name." ".$user->last_name; ?>, <a href="logout.php">Logout</a></div>
                    
                    <?php
					}
				?>
			</div>
            <?php
			
			
			
		}elseif($PAGE_TYPE=="HELP"){
			?>
			<div class="menu">
				<ul class="menubar">
                <li><a href="index.php"><span>Home</span></a></li>
                <?php if($user->type_flag != -1){ ?>
				<li><a href="panel.php"><span>Panel</span></a></li>
                <?php } ?>
				<li><a href="about.php"><span>About</span></a></li>
                <li><a href="mailto:essam.jalal@aramco.com"><span>Contact Us</span></a></li>
				<li><a href="help.php" class="active"><span>Help</span></a></li>
				</ul>
			</div>
			
			<div class="header">
				<div class="logo"><img src="images/header-logo.gif" height="150"  alt="logo" /></div>
				<?php
					if( $user->type_flag == -1 ){
					?>	
					<div id="loginArea">
                  <form id="loginForm" name="loginForm" action="" method="post">
                    
                    <table width="350" border="0">
                      <tr>
                        <td>Email</td>
                        <td>Password</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td><input id="email" name="login-email" type="text" /></td>
                        <td><input id="password" name="login-password" type="password" /></td>
                        <td><input type="submit" name="login" id="login" value="Login" /></td>
                      </tr>
                      <tr>
                        <td></td>
                        <td colspan="2"><div class="loginError" align="center">
                        	<?php
							if($loginStatus==1){
							?>
                        			Authentication Failed!
                                    
                            <?php
							}
							?>
                            </div></td>	
                        </tr>
                    </table>
                    
                  </form>
                </div>
                    <?php
					}else{
					?>	
                    
					<div class="welcomeMessage">Welcome <?php echo $user->first_name." ".$user->last_name; ?>, <a href="logout.php">Logout</a></div>
                    
                    <?php
					}
				?>
			</div>
            <?php
			
			
		}
	}
	
	//flag = -1 require logged in (patient, healthteam or admin)
	//flag = 0 require admin
	//flag = 1 require healthteam or admin
	//flag = 2 require patient
	function restrictAccess($user,$flag=-1){
		
		if($flag==-1 && $user->type_flag==-1){
			return false;
		}
		if( $flag==1 && ($user->type_flag!=0 && $user->type_flag!=1)){
			return false;
		}
		if( $flag==0 && $user->type_flag!=0 ){
			return false;
		}
		if($flag == 2 && $user->type_flag != 2){
			return false;
		}
		
		return true;
	}
	
	function viewSideBar($user){
		if( $user->type_flag == 2 ){
			include "views/pages/p_sidebar.html";
		}else{
			include "views/pages/ht_sidebar.html";
		}
	}
	
	function requireGets($arrayOfGets){

		$size = sizeof($arrayOfGets);
		for($i=0 ; $i<$size ; $i++){
			$currentGet = $arrayOfGets[$i];
			if(!isset($_GET[$currentGet]) ){
				return false;
			}
		}
		
		return true;
	}
	
	function viewFooter(){
		?>
	        <div class="footer-logo"><img src="images/footer-logo-white.gif" height="120"  alt="logo" /></div>
        <?php
	}
	
?>