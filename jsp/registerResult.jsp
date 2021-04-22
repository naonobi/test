<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean kekka = (boolean)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録成功画面</title>
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body style="text-align:center">
<% if(kekka){%>
ユーザー登録が完了しました！<br>
<p>ようこそ、${name }さん</p><br>
<a href="/bj/login.jsp">トップへ</a>
<%}else{ %>
ユーザー登録に失敗しました。
<a href="/bj/login.jsp">トップへ</a>
<%} %>
</body>
</html>