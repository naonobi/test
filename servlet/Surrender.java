package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GamePlayer;


@WebServlet("/Surrender")
public class Surrender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// GamePlayerｲﾝｽﾀﾝｽをｾｯｼｮﾝｽｺｰﾌﾟから取得
		HttpSession session = request.getSession();
		GamePlayer gamePlayer = (GamePlayer)session.getAttribute("gamePlayer");

		// GamePlayerのベット金額の半額をwalletへ充当
		gamePlayer.setWallet(gamePlayer.getWallet() + gamePlayer.getBet()/2);


		// GamePlayerのresultに負け-1をｾｯﾄ
		gamePlayer.setResult(-1);

		// ｾｯｼｮﾝｽｺｰﾌﾟにGamePlayerｲﾝｽﾀﾝｽを保存
		session.setAttribute("gamePlayer", gamePlayer);

		// 負け結果画面(gameResultLose.jsp)にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameResultLose.jsp");
		dispatcher.forward(request, response);
	}

}
