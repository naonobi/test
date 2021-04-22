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
import model.GameMaster;
import model.GamePlayer;
import model.HandCompareLogic;
import model.InfoUpdateLogic;


@WebServlet("/Stand")
public class Stand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BurstJudgeLogic bjLogic = new BurstJudgeLogic();
	InfoUpdateLogic iuLogic = new InfoUpdateLogic();
	CalcHandSumLogic chsLogic = new CalcHandSumLogic();
	boolean burstJudge;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GameMaster gameMaster = (GameMaster) session.getAttribute("gameMaster");
		GamePlayer gamePlayer = (GamePlayer) session.getAttribute("gamePlayer");
		Deck deck = (Deck) session.getAttribute("deck");
		boolean burstJudge = bjLogic.burstJudge(gameMaster);

		do{
		// カードを配るモデル(DealCardsLogic)を実行して親にカードを一枚渡す
		DealCardsLogic dcLogic = new DealCardsLogic();
		dcLogic.deal(deck,gameMaster);

		//親の手札の合計値を計算
		gameMaster.setHandSum(chsLogic.calcHandSum(gameMaster));

		}while(gameMaster.getHandSum() < 17);

		// バースト判定モデル(BurstJudgeLogic)を実行して親がバーストしていないか確認する
		burstJudge = bjLogic.burstJudge(gameMaster);

		if(burstJudge == true) {
		// プレーヤーを勝ちにして残高に対する操作を行う
		gamePlayer.setResult(1);
		iuLogic.infoUpdate(gamePlayer);

		// 勝ちのゲーム結果画面(gameResultWin.jsp)にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameResultWin.jsp");
		dispatcher.forward(request, response);
		}else {
			// 親とプレイヤーの手札の強さを比較するモデル(HandCompareLogic)を実行して勝敗を決める
			HandCompareLogic hcLogic = new HandCompareLogic();
			hcLogic.handCompare(gamePlayer, gameMaster);
			iuLogic.infoUpdate(gamePlayer);

			// ⑤勝敗結果に合致する結果画面のjspにフォワードする
			switch (gamePlayer.getResult()) {
			case -1:
				RequestDispatcher lose = request.getRequestDispatcher("/WEB-INF/jsp/gameResultLose.jsp");
				lose.forward(request, response);
				break;
			case 0:
				RequestDispatcher drow = request.getRequestDispatcher("/WEB-INF/jsp/gameResultDraw.jsp");
				drow.forward(request, response);
				break;
			case 1:
				RequestDispatcher win = request.getRequestDispatcher("/WEB-INF/jsp/gameResultWin.jsp");
				win.forward(request, response);
				break;
			}
		}
	}
}
