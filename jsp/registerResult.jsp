<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean result = (boolean)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録成功画面</title>
<link rel="stylesheet" type="text/css" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body style="text-align:center">
	<% if(result){%>
		ユーザー登録が完了しました！<br>
	<p>ようこそ、${name}さん</p><br>
	<p>ゲームに利用可能な1000コインがチャージされました</p><br>
	<a href="/bj/login.jsp">トップへ</a>
	<%}else{ %>
		ユーザー登録に失敗しました。
	<a href="/bj/login.jsp">トップへ</a>
	<%} %>
</body>
</html>