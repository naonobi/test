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
import model.InfoUpdateLogic;

@WebServlet("/DoubleDown")
public class DoubleDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean burstJudge;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GamePlayer gamePlayer = (GamePlayer) session.getAttribute("gamePlayer");
		Deck deck = (Deck) session.getAttribute("deck");

		// プレイヤーの残高から元の金額分を追加で減額し、ベット金額を2倍にする処理
		int bet = gamePlayer.getBet();
		gamePlayer.setWallet(gamePlayer.getWallet() - bet);
		bet *= 2;
		gamePlayer.setBet(bet);

		// ①カードを配るモデル(DealCardsLogic)を実行してプレイヤーににカードを一枚渡す
		DealCardsLogic dcLogic = new DealCardsLogic();
		dcLogic.deal(deck,gamePlayer);

		// バースト判定モデル(BurstJudgeLogic)を実行してプレイヤーがバーストしていないか確認する
		CalcHandSumLogic chsLogic = new CalcHandSumLogic();
		gamePlayer.setHandSum(chsLogic.calcHandSum(gamePlayer));
		BurstJudgeLogic bjLogic = new BurstJudgeLogic();
		boolean burstJudge = bjLogic.burstJudge(gamePlayer);

		// バーストしていた場合
		if(burstJudge == true) {
		    // プレイヤーを負けにして残高に対する操作を行う
			gamePlayer.setResult(1);
			InfoUpdateLogic iuLogic = new InfoUpdateLogic();
			iuLogic.infoUpdate(gamePlayer);

			// 負けのゲーム結果画面(gameResultLose.jsp)にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameResultLose.jsp");
			dispatcher.forward(request, response);
	    }else {
	    	// バーストしていない場合
	    	// スタンドサーブレット(Stand)にフォワード
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Stand");
	    	dispatcher.forward(request, response);

	    }
	}
}
