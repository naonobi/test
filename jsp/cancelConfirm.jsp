<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認画面</title>
<link rel="stylesheet" type="text/css" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body style="text-align:center">
    <br><br>
	<div style="text-align:center"><h2>退会確認</h2></div>
	<div class="div_form">
	${gamePlayer.name}さん<br>
	保有コイン数：${gamePlayer.wallet}<br>
	本当に退会しますか？<br><br>
	<form action="/bj/LoginServlet" method="get">
	<input type="submit" value="キャンセル" class="button_register"><br><br>
	</form>
	<form action="/bj/CancelServlet?value=1" method="post">
	<input type="submit" value="退会" class="button_register"><br><br>
	</form>
	</div>
</body></html>