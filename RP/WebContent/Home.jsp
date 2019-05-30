<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File upload</title>
</head>
<body>
    <h1>Uploading files</h1>
    <input type="file" name="file"  id="file" width="100" multiple>
    <input type="button" name="Submit" onclick="upload()" value="submit" multiple>
<script>
function upload()
{
	var data = document.getElementById("file").value;
	$.ajax({
		  method: "post",
		  url: "HomeController",
		  data: {data:data},
		  success: function(data){
		        window.location.href=data;

		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			     alert("some error");

		  }
		});
}
</script>
</body>
</html>