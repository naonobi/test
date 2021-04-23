<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean result = (boolean)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body style="text-align:center">
	<% if(result){%>
		退会処理が完了しました<br>
	<p>ご利用ありがとうございました</p><br>
	<a href="/bj/login.jsp">トップへ</a>
	<%}else{ %>
		退会処理に失敗しました。
	<a href="/bj/login.jsp">トップへ</a>
	<%} %>
</body>
</html>