<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errMsg = (String)request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body style="text-align:center">

	■webアプリ開発演習で製作■<br>
	4名チームにて作成　工数:48h/人<br>
	ソースコード<br>

	<h2>カジノへようこそ</h2>
	<div class="div_form">
	<form action="/bj/LoginServlet" method="post">
	<input type="text" name = "userId" style= "font-size:1em; width: 200px; height: 30px;" placeholder="ユーザーID" required><br><br>
	<input type="password" name = "pass" style= "font-size:1em; width: 200px; height: 30px;" placeholder="パスワード" required><br><br>
	<input type="submit" value="ログイン" class="button_login"><br><br>
	<% if( errMsg != null){ %>
	<font color="red"><%= errMsg %></font><br>
	<% } %>
	新規ユーザー登録は<a href="/bj/RegisterServlet" style="color: green">こちら</a>
	</form>
	</div>
	退会は<a href="/bj/CancelServlet" style="color: gray">こちら</a>
</body>
</html>