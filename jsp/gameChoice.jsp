<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゲーム選択</title>
<link rel="stylesheet" href="/bj/css/bj.css">
</head>
<body>
	<br><br>
	<div class="select_form">
		<span class="select_form_title">遊びたいゲームを選択しよう</span>
		<form action="/bj/GameChoice" method="post">
		ブラックジャック<input type="radio" name="choice" value="1" checked="checked">&nbsp;&nbsp;<img src="/bj/img/bj.jpg" style="width:45px; height:45px;"><br><br>
		ポーカー<input type="radio" name="choice" value="2">&nbsp;&nbsp;<img src="/bj/img/snoopy2.jpg" style="width:45px; height:45px;"><br><br>
		サバイバルゲーム<input type="radio" name="choice" value="3">&nbsp;&nbsp;<img src="/bj/img/survival_game2.png" style="width:45px; height:45px;"><br><br>
		&nbsp;&nbsp;<input type="submit"value="SELECT" class="button_select">
		</form>
	</div>
</body>
</html>