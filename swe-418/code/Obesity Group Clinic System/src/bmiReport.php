 <?php 
 	require_once "functions/t_config.php";
	require_once "functions/login.php";
	require_once "functions/user.class.php";
 	require_once "views/ViewBmi.php";
	require_once "views/renderLayout.php";
	require_once "functions/getPatientInfo2.php"; 
	 $user = initialize_Variables();
	 
	 if(!restrictAccess($user,-1)){
		include "views/pages/forbidden.php";
		die();
	}
	
	$gets = array("id");
	if(!requireGets($gets) ){
		include "views/pages/forbidden.php";
		die();
	}
	$id = $_GET['id'];
	if($user->type_flag == 2){
		if( $user->id != $id ){
			include "views/pages/forbidden.php";
			die();
		}
	}
	$patientInfo = getPatientInfo($id);
	if($patientInfo[0]!=1){
		die();
	}
	$patientInfo = $patientInfo[1];
	$patientInfo = mysqli_fetch_assoc($patientInfo);
	$patientName = 	$patientInfo['first_name'];
	$patientName .= 	"_".$patientInfo['last_name'];
	$patientEmail =$patientInfo['email'];
	$patientMobile =$patientInfo['mobile_number'];
	//$patientAuthor =$patientInfo['last_name'];
	
    $filename =$patientName."_BMI_HISTORY_".$today.".xls";
    header('Content-type: application/ms-excel');
    header('Content-Disposition: attachment; filename='.$filename);
	 
	 ?>
<table> 
<tr>
<td style="background-color:#000; color:#FFF">Patient Name </td>
<td > </td>
<td><?php echo $patientName?></td>
</tr>
<tr>
<td style="background-color:#000; color:#FFF">Mobile Number </td>
<td > </td>
<td><?php echo "#".$patientMobile  ?></td>
</tr>
<tr>
<td style="background-color:#000; color:#FFF">Patient Email </td>
<td > </td>
<td><?php echo $patientEmail?></td>
</tr>
<tr>
<td style="background-color:#000; color:#FFF">File Downloader </td>
<td > </td>
<td><?php echo $user->first_name ."   ".  $user->last_name?></td>
</tr>
<tr>
</tr>
<tr>
	<td style="background-color:#000; color:#FFF">Weight </td>
    <td style="background-color:#000; color:#FFF">Height</td>
    <td style="background-color:#000; color:#FFF">BMI</td>
    <td style="background-color:#000; color:#FFF">Last Updated</td>
</tr>
<tr>
		<?php getBmi($_GET['id']);?>
</tr>


</table>
