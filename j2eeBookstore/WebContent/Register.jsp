<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
<script>

function checkUsername(){
	var check = false;
	var username = document.getElementById("userName");
	if(username.length > 10){
		document.getElementById("checktest1").innerHTML = " X username cannot longer than 10";
		check = false;
	}else{
		document.getElementById("checktest1").innerHTML = " ✅ ️";
		check = true;
	}
	return check;
}


</script>
</head>
<body>
<center>
	<form action="RegisterServlet" method="post" onsubmit="return check()">
			<b>User registration</b>
			</br>
			
				<label>Username：</label>
				<input type="text" name="userName" onchange="checkUsername()"/>
				<span id="checktext1"></span>
			</br>
			<label> Password：</label>
			<input type="password" name="password" />
			
			</br>
			<input type="submit" value="Register" />
			<a href="index.jsp">Back</a>
		
			
			
	</form>
	</center>
</body>
</html>