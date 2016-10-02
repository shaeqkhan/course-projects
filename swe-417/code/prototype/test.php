<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<script language="javascript">
	
	function setValue(){
		var checkBoxes = document.getElementsByTagName("input");
		
		var size= checkBoxes.length-2;
		var i;
		var value=0;
		for(i=0 ; i<size ; i++){
			if(checkBoxes[i].checked){
				value+=(+checkBoxes[i].value);
			}
		}
		
		document.getElementById("hiddenField").value = value;
	}

</script>
</head>

<body>
<form id="form1" name="form1" method="get" action="">
  <p>
  <label for="textfield"></label>
  <input name="checkbox" type="checkbox" id="checkbox" value="1" />
  <label for="checkbox"></label>
  </p>
  <p>
    <input name="checkbox2" type="checkbox" id="checkbox2" value="10" />
  </p>
  <p>
    <input name="checkbox3" type="checkbox" id="checkbox3" value="100" />
  </p>
  <p>
    <input name="checkbox4" type="checkbox" id="checkbox4" value="1000" />
  </p>
  <p>
    <input name="checkbox5" type="checkbox" id="checkbox5" value="10000" />
  </p>
  <p>
    <input name="checkbox6" type="checkbox" id="checkbox6" value="100000" />
  </p>
  <p>
    <input type="hidden" name="hiddenField" id="hiddenField" value="getValue()" />
  </p>
  <p>
    <input type="submit" onclick="setValue()" name="button" id="button" value="Submit" />
  </p>
  <p><?php echo $_GET['hiddenField']; ?></p>
</form>
</body>
</html>