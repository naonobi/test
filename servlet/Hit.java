package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BurstJudgeLogic;
import model.CalcHandSumLogic;
import model.DealCardsLogic;
import model.Deck;
import model.GamePlayer;

@WebServlet("/Hit")
public class Hit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GamePlayer gamePlayer = (GamePlayer) session.getAttribute("gamePlayer");
		Deck deck = (Deck) session.getAttribute("deck");

		// カードを1枚追加
		DealCardsLogic logic = new DealCardsLogic();
		logic.deal(deck,gamePlayer);

		//手札の合計値を求める処理
		CalcHandSumLogic chsLogic = new CalcHandSumLogic();
		gamePlayer.setHandSum(chsLogic.calcHandSum(gamePlayer));

		// バースト判定モデル(BurstJudgeLogic)を実行してプレイヤーがバーストしていないか確認する
		BurstJudgeLogic bjLogic = new BurstJudgeLogic();
		boolean burstJudge = bjLogic.burstJudge(gamePlayer);

		// バースト判定により分岐
		if(burstJudge) {
			//負け
			gamePlayer.setResult(-1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameResultLose.jsp");
			dispatcher.forward(request, response);
		}else {
			//続行
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hit.jsp");
		dispatcher.forward(request, response);
		}
	}

}
