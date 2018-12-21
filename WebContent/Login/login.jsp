<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>
<link rel="stylesheet" href="assets/css/stylethisinh.css">
</head>

<body>

	<div class="login-box">
		<h1>Login</h1>
		<p style="color: red;">${errorUser}</p>
		<form method="POST"
			action="${pageContext.request.contextPath}/Login">
			<div class="textbox">
				<i class="fa fa-user" ></i> <input type="text"
					placeholder="Username" name="username">
			</div>
			<div class="textbox">
				<i class="fa fa-lock"></i> <input type="password"
					placeholder="Password" name="password">
			</div>
			<br />
			<div class="radio">
				<input type="radio" name="role" value="Thisinh" checked="checked" /><strong>Thí sinh</strong><br /> 
                <input type="radio" name="role" value="QLCH" /><strong>QL câu hỏi </strong><br /> 
                <input type="radio" name="role" value="QLDT" /><strong>QL đề thi</strong><br /> 
                <input type="radio" name="role" value="QLTSL" /><strong>QL thí sinh - lớp</strong>
			</div>
			<input class="btn" type="submit"value="Sign-in">
		</form>
	</div>



</body>

</html>