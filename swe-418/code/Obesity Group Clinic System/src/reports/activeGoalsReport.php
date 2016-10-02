<?php
	require_once ("functions/t_config.php");
	require_once "functions/login.php";
	require_once "functions/user.class.php";
	require_once "views/renderLayout.php";


	$user = initialize_Variables();
	
	//check the user group
	if(!restrictAccess($user,1)){
		include "../views/pages/forbidden.php";
		die();
	}
	
	

	
	
	function generateAvtiveGoalsReport() {
		
	global $goal,$count,$conn,$database_conn;
        
        //select the required database
        mysqli_select_db($conn, $database_conn);
		$select_st= "
						SELECT goal_name, num
						FROM (
						
						SELECT DISTINCT (
						goal_id
						), COUNT( patient_id ) AS num
						FROM patient_goals
						GROUP BY goal_id
						) AS a
						LEFT JOIN goal ON ( a.goal_id = goal.goal_id ) 
					";

$goals_count_table= mysqli_query($conn, $select_st);



$it = 0;
while ($result=mysqli_fetch_row($goals_count_table))
{
	$goal[$it]=$result[0];
	
	$count[$it]=$result[1];
	$it++;
	
	}
	  
	return array($goal,$count);
	
	}
	
	
	
	$res=generateAvtiveGoalsReport();
	$data_names=$res[0];
    $first_data=$res[1];
	
	
	
	

	
	//-------------------------------------------
	
$x_title="Number Of Patient";
$y_title="Goals";
$title="Active Goals";
$total_width=600;
$total_height=500; 


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

$datasets=1;
if (isset($second_data)) { $datasets=2; }
if (isset($third_data)) { $datasets=3; }

	$version="Aramco - OGC";	

	$fontdetails="arial.ttf";
	// create image
	$image = imagecreate($total_width, $total_height);

	if (!$x_title) { $x_title=" "; }
	if (!$y_title) { $y_title=" "; }
	if (!$title) { $title="BarChart"; }
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
	$fromleft=70;
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
	ImageTTFText($image, 22, 0, ($total_width/2)-(textwidthcheck(14,$title)/2),$fromtop/2, $orange,$fontdetails, $title);
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
	if (isset($second_data))
		{	$highestnumbertwo=gethighestnumber($second_data);
		}
	if (isset($third_data))
		{	$highestnumberthree=gethighestnumber($third_data);
		}
	if (($highestnumbertwo>$highestnumberzero) and ($highestnumbertwo>$highestnumberthree))
		{
		$highestnumber=$highestnumbertwo;
		}
	if (($highestnumberthree>$highestnumberzero) and ($highestnumberthree>$highestnumbertwo))
		{
		$highestnumber=$highestnumberthree;
		}		
	if (($highestnumberzero>$highestnumbertwo) and ($highestnumberzero>$highestnumberthree))
		{
		$highestnumber=$highestnumberzero;
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
		ImageTTFText($image, 14, 0, $fromleft-(strlen($i*10)*3),($total_height-$frombottom)-($division*$i)+3-$offsetvalue, $black,$fontdetails, $i*$thedivider);
// Draw horizontal ticks
		imageline ($image,$fromleft+$offsetvalue,$fromtop+($division*$i)-$offsetvalue,$total_width-$fromright+$offsetvalue,$fromtop+($division*$i)-$offsetvalue,$gray22);
		}
// Display Y title
	ImageTTFText($image, 14, 0, ($total_width/2)-(textwidthcheck(12,$y_title)/2),$total_height-$frombottom/5, $black,$fontdetails, $y_title);
// Draw Vertical Ticks
	$division=($total_width-($fromleft+$fromright)) / (count($data_names));
	for ($i=0; $i<count($data_names)+1; $i++)
		{
		imageline ($image,$fromleft+($division*$i)+$offsetvalue,$fromtop-$offsetvalue,$fromleft+($division*$i)+$offsetvalue,$total_height-($frombottom)-$offsetvalue,$gray22);
		}
// Display X title
	ImageTTFText($image, 14, 90, ($fromleft/3),($total_height/2)-(strlen($x_title)/2), $black,$fontdetails, $x_title);
// END ********************    DRAW HORITONTAL AND VERTICAL TICKS   ************************


// START ************************************************************************************
// *****************************    Draw Line Graph third data   ***************************
// ******************************************************************************************
if (isset($third_data))
	{
	$division=($total_width-($fromleft+$fromright)) / (count($data_names));
	$actualstart=$total_height-$frombottom;
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	for ($i=0; $i<count($data_names); $i++)
		{
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($third_data[$i]*$thesize);

		ImageFilledRectangle($image, $lastx+$offsetvalue+($division/$datasets*2),($actualstart-($third_data[$i]*$thesize))-$offsetvalue,$lastx+$offsetvalue+($division/$datasets*3),$actualstart-$offsetvalue,$yellow);
		ImageRectangle($image, $lastx+$offsetvalue+($division/$datasets*2),($actualstart-($third_data[$i]*$thesize))-$offsetvalue,$lastx+$offsetvalue+($division/$datasets*3),$actualstart-$offsetvalue,$darkyellow);
		
		}
	}
// END ************************    Draw Line Graph third data   ****************************



// START ************************************************************************************
// *****************************    Draw Line Graph second data   ***************************
// ******************************************************************************************
if (isset($second_data))
	{
	$division=($total_width-($fromleft+$fromright)) / (count($data_names));
	$actualstart=$total_height-$frombottom;
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	for ($i=0; $i<count($data_names); $i++)
		{
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($second_data[$i]*$thesize);

		ImageFilledRectangle($image, $lastx+$offsetvalue+($division/$datasets),($actualstart-($second_data[$i]*$thesize))-$offsetvalue,$lastx+$offsetvalue+($division/$datasets*2),$actualstart-$offsetvalue,$red);
		ImageRectangle($image, $lastx+$offsetvalue+($division/$datasets),($actualstart-($second_data[$i]*$thesize))-$offsetvalue,$lastx+$offsetvalue+($division/$datasets*2),$actualstart-$offsetvalue,$darkred);
		
		}
	}
// END ************************    Draw Line Graph second data   ****************************


// START ************************************************************************************
// *****************************    Draw Line Graph first data   ****************************
// ******************************************************************************************
	$division=($total_width-($fromleft+$fromright)) / (count($data_names));
	$actualstart=$total_height-$frombottom;
	$thesize=($actualstart-$fromtop)/$actualhighestnumber;
	for ($i=0; $i<count($data_names); $i++)
		{
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($first_data[$i]*$thesize);
		ImageFilledRectangle($image, $lastx+$offsetvalue,($actualstart-($first_data[$i]*$thesize))-$offsetvalue,$lastx+$offsetvalue+($division/$datasets),$actualstart-$offsetvalue,$green);
		ImageRectangle($image, $lastx+$offsetvalue,($actualstart-($first_data[$i]*$thesize))-$offsetvalue,$lastx+$offsetvalue+($division/$datasets),$actualstart-$offsetvalue,$darkgreen);
		
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
		ImageTTFText($image, 10, 40, $fromleft+($division*$i)-(strlen($data_names[$i])*2),$total_height-($frombottom/4)-($frombottom/4), $black,$fontdetails, $data_names[$i]);
		$lastx=$fromleft+($division*$i);
		$lasty=$actualstart-($first_data[$i]*$thesize);
		}
//    
// START ************************************************************************************
// ***************************    Print any additional messages   ***************************
// ******************************************************************************************
// Version
	ImageTTFText($image, 8, 0, $total_width-$fromright-strlen($version)-70,$total_height-6, $orange,$fontdetails, $version);
// Debug text
//		ImageTTFText($image, 10, 0, $total_width-100,20, $gray,$fontdetails, "Debug-".$second_data[3]);

// END ***********************    Print any additional messages   ***************************

// flush image
	header('Content-type: image/png');
	imagepng($image);
	imagedestroy($image);
?>