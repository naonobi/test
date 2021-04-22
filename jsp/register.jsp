<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errMsg = (String)request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
<link rel="stylesheet" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body style="text-align:center">
    <br><br>
	<div style="text-align:center"><h2>新規ユーザー登録</h2></div>
	<div class="div_form">
	<form action="/bj/RegisterServlet"method="post">
	<input type="text" name = "userId" style= "font-size:1em; width: 200px; height: 30px;" placeholder="ユーザーID(10文字以内)" required><br><br>
	<input type="password" name = "pass" style= "font-size:1em; width: 200px; height: 30px;" placeholder="パスワード(10文字以内)" required><br><br>
	<input type="text" name = "name" style= "font-size:1em; width: 200px; height: 30px;" placeholder="氏名" required><br><br>
	<input type="number" name = "age" style= "font-size:1em; width: 200px; height: 30px;" placeholder="年齢" required><br><br>
	<input type="submit" value="登録" class="button_register"><br><br>
	</form>
	</div>
</body>
</html>