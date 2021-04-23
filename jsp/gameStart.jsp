<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BJスタート画面</title>
<link rel="stylesheet" type="text/css" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body class="body">
	<div style="display:table; width:100%; margin:5px auto;">
	<div style="display:table-cell; width:25%; background-color:white; text-align:center;">ユーザー名:${gamePlayer.name}</div>
	<div style="display:table-cell; width:50%; color:white; text-align:center;"><a href="/bj/GameChoice?select=1" style="color:white">＜ ゲーム選択画面へ ＞</a></div>
	<div style="display:table-cell; width:25%; background-color:white; text-align:center;">残高:${gamePlayer.wallet}コイン</div>
	</div>
	<br><br>
    <div style="text-align: center; color: gold;"><font size="7" face="メイリオ">ブラックジャック</font></div>
    <div class="blink" style="text-align: center"><font size="6" face="メイリオ" color="white">ベット金額を選んでください</font></div>
	<br>
	<div class="start">
	<form action="/bj/GameStart" method="post">
        【  10】<input type="radio" name="bet" value="10" checked="checked"><br>
        【 100】<input type="radio" name="bet" value="100"><br>
        【 500】<input type="radio" name="bet" value="500"><br>
        【1000】<input type="radio" name="bet" value="1000"><br><br>
         <input type="submit" value="スタート" class="game_start">
    </form>
    </div><br><br>
    <div style="text-align: right; color: white">
    	<form action="/bj/LogoutServlet" method="post">
        <input type="submit" value="ログアウト">
   		 </form>
   	</div>
</body>
</html>