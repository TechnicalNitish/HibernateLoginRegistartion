<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="resetservlet" method="post">
			New Password:<input type="password" name="newpassword">
			Confirm Password:<input type="cpassword" name="confirmpassword">
			<input type="submit" value="Reset"> 
	</form>

</body>
</html>