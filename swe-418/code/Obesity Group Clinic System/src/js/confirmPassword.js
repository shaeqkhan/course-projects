// JavaScript Document

function togglePasswordFields(){
	var change = document.getElementById("changePassword").checked;
	
	if(change){
		
		document.getElementById("password").disabled = false;
		document.getElementById("confirm_password").disabled = false;
	}else{
		document.getElementById("password").disabled = true;
		document.getElementById("confirm_password").disabled = true;
	}
}