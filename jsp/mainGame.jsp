<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GamePlayer, model.GameMaster" %>
<%@ page import="java.util.*" %>
<%
GamePlayer gamePlayer = (GamePlayer) session.getAttribute("gamePlayer");
GameMaster gameMaster = (GameMaster) session.getAttribute("gameMaster");
List<String> gpHand = gamePlayer.getHand();
List<String> gmHand = gameMaster.getHand();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>

<link rel="stylesheet" type="text/css" href="/bj/css/bj.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body bgcolor="#b22222">

	<div style="display:table; width:100%; margin:5px auto;">
	<div style="display:table-cell; width:25%; background-color:white; text-align:center;">ユーザー名:${gamePlayer.name}</div>
	<div style="display:table-cell; width:50%; color:white; text-align:center;"></div>
	<div style="display:table-cell; width:25%; background-color:white; text-align:center;">残高:${gamePlayer.wallet}コイン</div>
	</div>

    <div style="display:table; width:100%; margin:5px auto;">
    <div class="rule">
	 &nbsp;&nbsp;&nbsp;＜ルール説明＞<br>
	〇親と子で対戦し、手札の合計点が21に近い<br>
     &nbsp;&nbsp;プレイヤーが勝利します。*同点は引き分け<br>
     &nbsp;&nbsp;手札の合計が21を超えたプレイヤーは負け<br>
	〇点数の数え方<br>
	 &nbsp;&nbsp;2~10：カードの数字と同じ点数<br>
	 &nbsp;&nbsp;J,Q,K：絵札は全て10点<br>
	 &nbsp;&nbsp;A：1点もしくは11点の手札が強くなる方<br>
	 〇スタンド<br>
	 &nbsp;&nbsp;現在の手札で親と勝負する<br>
	 〇ヒット<br>
	 &nbsp;&nbsp;カードを一枚引いて手札に加える<br>
	 &nbsp;&nbsp;ダブルとサレンダーはできなくなる<br>
	 〇ダブル<br>
	 &nbsp;&nbsp;カードを一枚引き、ベット金額を２倍に<br>&nbsp;&nbsp;する<br>
	 &nbsp;&nbsp;<br>
	 </div>
	 <div class="board">
	親の手札：合計<%=gameMaster.getHandSum() %><br>
  	<% for(int i = 0; i < gmHand.size(); i++){ %>
  	<img src="/bj/img/<%=gmHand.get(i)%>.gif" width="80" height="120">
   	<% }%><br>あなたの手札：合計<%=gamePlayer.getHandSum() %><br>
   	<% for(int i = 0; i < gpHand.size(); i++){ %>
   	<img src="/bj/img/<%=gpHand.get(i)%>.gif" width="80" height="120">
   	<% } %>
   	</div>
   	<div class="table_right" style="color: white">
   	&nbsp;&nbsp;※親はプレイヤーが手札を確定した後、<br>&nbsp;&nbsp;&nbsp;17以上になるまでカードを引く
  	<img src="/bj/img/whitedealer.png" width="300px" height="300px" >
   	</div>
	</div>

    <div style="text-align: center; color: white">
        [ ベット金額:${gamePlayer.bet}コイン ]</div>
    <div class="div_form">
    	<form action="/bj/Stand" method="post">
    	<input type="submit" value="スタンド" class="button_stand">
    	</form>
    	<form action="/bj/Hit" method="post">
    	<input type="submit" value="ヒット" class="button_hit">
    	</form>
    	<form action="/bj/DoubleDown" method="post">
    	<input type="submit" value="ダブル" class="button_double">
    	</form>
    	<form action="/bj/Surrender" method="post">
    	<input type="submit" value="サレンダー" class="button_surrender">
    	</form>
    </div>
    <div class="logout_form">
    	<form action="/bj/LogoutServlet" method="post">
    	<input type="submit" value="ログアウト" disabled>
    	</form>
    </div>

</body>
</html>