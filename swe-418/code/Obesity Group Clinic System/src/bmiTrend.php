<?php

	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";


	$user = initialize_Variables();
	
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
	
  	function getWightHigthBMIDateForPatient($id)


      {
	
    global $conn, $database_conn;
	 mysqli_select_db($conn, $database_conn);
	 
	 $id = htmlentities(mysqli_real_escape_string($conn,$id));
	
	 $select_stmt = "SELECT weight, height, bmi_time_stamp
						FROM patient_bmi_history
						WHERE patient_id =$id
						ORDER BY bmi_time_stamp DESC 
						LIMIT 0 , 10";
     $query = mysqli_query($conn, $select_stmt);
	   $weightarray=array();
	   $hieghtarray=array();
	   $BMIarray=array();
	   $Datearray=array();
	 
		   
		   if(mysqli_num_rows($query)<2)
	       {
           // no enugh bmi
		   return -1;

           }
	
			$it=0;
	  while ( $result=mysqli_fetch_row($query))
	      {
			  
			   $weightarray[$it]=$result[0] ;
			   $hieghtarray[$it]=$result[1] ;
			   $BMIarray[$it]=(round(($result[0])/($result[1]*$result[1]),2));
			   $timestamp = $result[2];
			   $timestamp=strtotime($timestamp);
		       $Datearray[$it]= date("Y-m-d",$timestamp);
		  	$it++;
		  
	       }
	

	             return array($weightarray,$hieghtarray,$BMIarray,$Datearray);
	                 
	  }


//--------------------------------------------------------------------------
	
	$res=getWightHigthBMIDateForPatient($_GET['id']);

	$data_names=$res[3];
    $first_data=$res[2];
	//print_r($first_data);
	

$x_title="BMI";
$y_title="Date";
$title="Patient BMI Trend";
/*
$data_names = array('Hole 1','Hole 2','Hole 3','Hole 4','Hole 5','Hole 6','Hole 7','Hole 8','Hole 9','Hole 10','Hole 11','Hole 12','Hole 13','Hole 14','Hole 15','Hole 16','Hole 17','Hole 18');
$first_data = array(6,3,5,6,5,3,5,5,5,5,6,6,3,6,6,4,4,6);
*/
$third_data = array(7,6,6,6,5,5,5,5,5,5,6,6,5,8,6,4,4,7);
$second_data = array(4,3,5,5,4,4,4,4,4,3,4,4,4,5,4,4,3,4);
	
/*
History
17th November 2003
Added support for 3 data sets
Added the draw function so items are on a 3 dimension 3 space z axis so they don't overlap
Added x axis name function so if over 20 it only shows every other name (spacing is a problem)
Checks if the data sets exist, if not uses the default data set to work out sizes.
January 2004
Changed the display of the X axis names, didn't look right before.
*/


// ******************************************************************************************
// **************************************    INITIALISE   ***********************************
// ******************************************************************************************
function textwidthcheck($fontsize,$thetext)
	{
	$bbox=imagettfbbox($fontsize,0,"arial.ttf",$thetext);
	$textleft=($bbox[0]>$bbox[6])?$bbox[6]:$bbox[0]; // determine most far points
    $textright=($bbox[2]>$bbox[4])?$bbox[2]:$bbox[4]; // idem
	return $textright-$textleft;
	}
	$total_width=500; 
	$total_height=400;
	$linewidth=4.5;
	$version="Aramco - OGC";

	$fontdetails="arial.ttf";
	// create image
	$image = imagecreate($total_width, $total_height);

	if (!$x_title) { $x_title=" "; }
	if (!$y_title) { $y_title=" "; }
	if (!$title) { $title="LineChart"; }
// Colours
	$white    = ImageColorAllocate ($image, 0xFF, 0xFF, 0xFF); $darkgreen= ImageColorAllocate ($image, 0x00, 0x50, 0x00);
	$gray77   = ImageColorAllocate ($image, 0x77, 0x77, 0x77); $gray88   = ImageColorAllocate ($image, 0x88, 0x88, 0x88);
	$gray22   = ImageColorAllocate ($image, 0x22, 0x22, 0x22); $gray33   = ImageColorAllocate ($image, 0x33, 0x33, 0x33);
	$gray66   = ImageColorAllocate ($image, 0x66, 0x66, 0x66); $black    = ImageColorAllocate ($image, 0x00, 0x00, 0x00);   
	$maroon   = ImageColorAllocate ($image, 0x80, 0x00, 0x00); $green    = ImageColorAllocate ($image, 0x08, 0x82, 0x00);   
	$olive    = ImageColorAllocate ($image, 0x80, 0x80, 0x00); $navy     = ImageColorAllocate ($image, 0x00, 0x00, 0x80);   
	$purple   = ImageColorAllocate ($image, 0x80, 0x00, 0x80); $gray     = ImageColorAllocate ($image, 0x80, 0x80, 0x80);   
	$red      = ImageColorAllocate ($image, 0xFF, 0x00, 0x00); $lime     = ImageColorAllocate ($image, 0x00, 0xFF, 0x00);   
	$yellow   = ImageColorAllocate ($image, 0xFF, 0xFF, 0x00); $blue     = ImageColorAllocate ($image, 0x00, 0x00, 0xFF);   
	$fuchsia  = ImageColorAllocate ($image, 0xFF, 0x00, 0xFF); $aqua     = ImageColorAllocate ($image, 0x00, 0xFF, 0xFF); 
	$darkred  = ImageColorAllocate ($image, 0x95, 0x00, 0x00); $darkyellow   = ImageColorAllocate ($image, 0x55, 0x55, 0x00);
	$sidegreen = ImageColorAllocate ($image, 0x08, 0x5D, 0x00); $orange = ImageColorAllocate ($image, 0xFF, 0x93, 0x00);
	$lightGray = ImageColorAllocate ($image, 0xE1, 0xE1, 0xE1);
// Set up grid positions
	$fromleft=60;
	$fromright=40;
	$fromtop=50;
	$frombottom=70;
	$offsetvalue=15;
	// Fill the image (background colour)
	ImageFill($image, 0, 0, $white);
// Border around entire image (border colour)
	ImageRectangle($image, 0, 0, $total_width-1, $total_height-1, $white);
// END **********************************    INITIALISE   ***********************************
	
	
// ******************************************************************************************
// **********************************    DRAW BACKGROUND   **********************************
// ******************************************************************************************
// Print Chart Title
	ImageTTFText($image, 14, 0, ($total_width/2)-(textwidthcheck(14,$title)/2),$fromtop/2, $orange,$fontdetails, $title);
// Draw the background for the chart.
	ImageFill($image, 0, 0, $white);
	ImageFilledRectangle($image, $fromleft+$offsetvalue, $fromtop-$offsetvalue, $total_width-$fromright+$offsetvalue, $total_height-$frombottom-$offsetvalue, $lightGray);
// END ******************************    DRAW BACKGROUND   **********************************

// ******************************************************************************************
// *************************    DRAW HORITONTAL AND VERTICAL TICKS   ************************
// ******************************************************************************************
	function gethighestnumber($somedata)
		{
			$thehighestnumber=0;
		for ($i=0; $i<count($somedata); $i++)
			{
			if ($somedata[$i]>$thehighestnumber)
				{
				$thehighestnumber=$somedata[$i];
				}
			}
		return $thehighestnumber;
		}
// Calculate highest number
$highestnumberzero=0;
$highestnumbertwo=0;
$highestnumberthree=0;
	$highestnumber=gethighestnumber($first_data);
	$highestnumberzero=gethighestnumber($first_data);
	if (($second_data))
		{	$highestnumbertwo=gethighestnumber($second_data);
		}
	if (($third_data))
		{	$highestnumberthree=gethighestnumber($third_data);
		}
	if (($highestnumbertwo>$highestnumberzero) and ($highestnumbertwo>$highestnumberthree))
		{	$highestnumber=$highestnumbertwo;
		}
	if (($highestnumberthree>$highestnumberzero) and ($highestnumberthree>$highestnumbertwo))
		{	$highestnumber=$highestnumberthree;
		}		
	if (($highestnumberzero>$highestnumbertwo) and ($highestnumberzero>$highestnumberthree))
		{	$highestnumber=$highestnumberzero;
		}		
		
// Calculate the increments of the X-Ticks Numbers.
	if ($highestnumber>49)
		{
		$thedivider=10;
		}
	if ($highestnumber<50)
		{
		$thedivider=5;
		}
	if ($highestnumber<20)
		{
		$thedivider=1;
		}	
	if ($highestnumber<10)
		{
		$thedivider=1;
		}
	$totalnumber=sprintf("%01.0f", $highestnumber/$thedivider);
	$actualhighestnumber=$thedivider*($totalnumber+1);
	$division=($total_height-($fromtop+$frombottom)) / ($totalnumber+1);
	for ($i=0; $i<$totalnumber+2; $i++)
		{
		ImageTTFText($image, 9, 0, $fromleft-(strlen($i*10)*3),($total_height-$frombottom)-($division*$i)+3-$offsetvalue, $black,$fontdetails, $i*$thedivider);
// Draw horizontal ticks
		imageline ($image,$fromleft+$offsetvalue,$fromtop+($division*$i)-$offsetvalue,$total_width-$fromright+$offsetvalue,$fromtop+($division*$i)-$offsetvalue,$gray22);
		}
// Display Y title
	ImageTTFText($image, 12, 0, ($total_width/2)-(textwidthcheck(12,$y_title)/2),$total_height-$frombottom/5, $black,$fontdetails, $y_title);
// Draw Vertical Ticks
	$division=($total_width-($fromleft+$fromright)) / (count($data_names)-1);
	for ($i=0; $i<count($data_names); $i++)
		{
		imageline ($image,$fromleft+($division*$i)+$offsetvalue,$fromtop-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,$total_height-($frombottom)-$offsetvalue,$gray22);
		}
// Display X title
	ImageTTFText($image, 12, 90, ($fromleft/3),($total_height/2)-(strlen($x_title)/2), $black,$fontdetails, $x_title);
// END ********************    DRAW HORITONTAL AND VERTICAL TICKS   ************************

// START ************************************************************************************
// *****************************    Draw Line Graph third data   ***************************
// ******************************************************************************************
/*
if (isset($third_data))
	{
	$division=($total_width-($fromleft+$fromright)) / (count($data_names)-1);
	$actualstart=$total_height-$frombottom;
	$lastx=$fromleft+($division*0);
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	$lasty=$actualstart-($third_data[0]*$thesize);
	for ($i=0; $i<count($data_names); $i++)
		{
// Draw the Dark line according to linewidth (loops through incrementing the line
		for ($thelinewidth=-1; $thelinewidth<=$linewidth; $thelinewidth++)
			{
			imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($third_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$darkyellow);
			}
// Draw the normal coloured line according to offsett value making the line look isometrical (3d)
		for ($thelinewidth=1; $thelinewidth<=$linewidth; $thelinewidth++)
			{
			imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($third_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$yellow);
			}
// Grab last co-ordinates before looping back
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($third_data[$i]*$thesize);
		}
//	imageline ($image,$lastx+$lineoffsetvalue+$lineoffsetvalue,$lasty-$lineoffsetvalue-$lineoffsetvalue,$lastx+$offsetvalue+$offsetvalue,$lasty-$offsetvalue-$offsetvalue,$gray33);
	}
// END ************************    Draw Line Graph third data   ****************************
*/

// START ************************************************************************************
// *****************************    Draw Line Graph second data   ***************************
// ******************************************************************************************
/*
if (isset($second_data))
	{
	$division=($total_width-($fromleft+$fromright)) / (count($data_names)-1);
	$actualstart=$total_height-$frombottom;
	$lastx=$fromleft+($division*0);
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	$lasty=$actualstart-($second_data[0]*$thesize);
	for ($i=0; $i<count($data_names); $i++)
		{
// Draw the Dark line according to linewidth (loops through incrementing the line
		for ($thelinewidth=-1; $thelinewidth<=$linewidth; $thelinewidth++)
			{
			imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($second_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$darkred);
			}
// Draw the normal coloured line according to offsett value making the line look isometrical (3d)
		for ($thelinewidth=1; $thelinewidth<=$linewidth; $thelinewidth++)
			{
			imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($second_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$red);
			}
// Grab last co-ordinates before looping back
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($second_data[$i]*$thesize);
		}
//	imageline ($image,$lastx+$lineoffsetvalue,$lasty-$lineoffsetvalue,$lastx+$offsetvalue+$lineoffsetvalue,$lasty-$offsetvalue-$lineoffsetvalue,$gray33);
	}
// END ************************    Draw Line Graph second data   ****************************/


// START ************************************************************************************
// *****************************    Draw Line Graph first data   ****************************
// ******************************************************************************************
	$division=($total_width-($fromleft+$fromright)) / (count($data_names)-1);
	$actualstart=$total_height-$frombottom;
	$lastx=$fromleft+($division*0);
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	$lasty=$actualstart-($first_data[0]*$thesize);
	for ($i=0; $i<count($data_names); $i++)
		{
// Draw the Dark line according to linewidth (loops through incrementing the line
		for ($thelinewidth=-1; $thelinewidth<=$linewidth; $thelinewidth++)
			{
			imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($first_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$red);
			}
// Draw the normal coloured line according to offsett value making the line look isometrical (3d)
		for ($thelinewidth=1; $thelinewidth<=$linewidth; $thelinewidth++)
			{
			imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($first_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$red);
			}
// Display X Axis names
// Grab last co-ordinates before looping back
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($first_data[$i]*$thesize);
		}
// END *************************    Draw Line Graph first data   ****************************


$increment_variable=1;
if (count($data_names)>18)
	{
	$increment_variable=2;
	}
if (count($data_names)>25)
	{
	$increment_variable=3;
	}	
if (count($data_names)>40)
	{
	$increment_variable=4;
	}	
	
	$division=($total_width-($fromleft+$fromright)) / (count($data_names)-1);
	$actualstart=$total_height-$frombottom;
	$lastx=$fromleft+($division*0);
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	$lasty=$actualstart-($first_data[0]*$thesize);
	for ($i=0; $i<count($data_names); $i=$i+$increment_variable)
		{
		ImageTTFText($image, 9, 40, $fromleft+($division*$i)-(strlen($data_names[$i])*2),$total_height-($frombottom/4)-($frombottom/3), $black,$fontdetails, $data_names[$i]);
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($first_data[$i]*$thesize);
		}


// START ************************************************************************************
// ********************************    Draw Numbers for Data   ******************************
// ******************************************************************************************
$drawnumbers = false;
if ($drawnumbers==true)
	{
	$division=($total_width-($fromleft+$fromright)) / (count($data_names)-1);
	$actualstart=$total_height-$frombottom;
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	for ($i=0; $i<count($data_names); $i++)
		{
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($first_data[$i]*$thesize);
		imagefilledellipse($image, $lastx+$offsetvalue+1,$lasty+$thelinewidth-$offsetvalue-7, 14, 14, $darkgreen);

		imagefilledellipse($image, $lastx+$offsetvalue+2,$lasty+$thelinewidth-$offsetvalue-5, 14, 14, $green);
		$largernumberoffset=0;
		if ($first_data[$i]>9)
			{
			$largernumberoffset=3;
			}
		ImageTTFText($image, 8, 0, $lastx+$offsetvalue-$largernumberoffset,$lasty+$thelinewidth-$offsetvalue, $white,$fontdetails, $first_data[$i]);
		//imageline ($image,$lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,($actualstart-($first_data[$i]*$thesize))+$thelinewidth-$offsetvalue,$darkgreen);
		}
//		ImageTTFText($image, 8, 45, $lastx+$offsetvalue,$lasty+$thelinewidth-$offsetvalue, $white,$fontdetails, $first_data[$i]);
	}
// END ***************************    Draw Numbers for Data   *******************************


// START ************************************************************************************
// ***************************    Print any additional messages   ***************************
// ******************************************************************************************

// Version
	ImageTTFText($image, 8, 0, $total_width-$fromright-strlen($version)-30,$total_height-6, $orange,$fontdetails, $version);
// Debug text
//		ImageTTFText($image, 10, 0, $total_width-100,20, $gray,$fontdetails, "Debug-".$second_data[3]);

// END ***********************    Print any additional messages   ***************************

// flush image
	header('Content-type: image/png');
    imagepng($image);
	imagedestroy($image);
?>