package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CalcHandSumLogic;
import model.DealCardsLogic;
import model.Deck;
import model.GameMaster;
import model.GamePlayer;
import model.InfoUpdateLogic;

@WebServlet("/GameStart")
public class GameStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// メインゲーム画面(mainGame.jspにフォワード)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainGame.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//betのパラメータを取得
		request.setCharacterEncoding("UTF-8");
		int bet = Integer.parseInt(request.getParameter("bet"));

		//bet金額をAccountにセット
		HttpSession session = request.getSession();
		GamePlayer gamePlayer = (GamePlayer) session.getAttribute("gamePlayer");
		gamePlayer.setBet(bet);

		//画面の残金表示を書き換え
		InfoUpdateLogic iul = new InfoUpdateLogic();
		iul.betWallet(gamePlayer);

		//親のインスタンスを生成
		GameMaster gameMaster = new GameMaster();

		// 山札を生成
		Deck deck = new Deck();

		//カードを配る処理
		DealCardsLogic dealCardsLogic = new DealCardsLogic();
		dealCardsLogic.firstDeal(deck,gamePlayer, gameMaster);
		//配られたカードの合計点を計算
		CalcHandSumLogic chsLogic = new CalcHandSumLogic();
		gamePlayer.setHandSum(chsLogic.calcHandSum(gamePlayer));
		gameMaster.setHandSum(chsLogic.calcHandSum(gameMaster));


		//セッションスコープに保存
		session.setAttribute("gameMaster", gameMaster);
		session.setAttribute("deck", deck);

		// メインゲーム画面(mainGame.jspにフォワード)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainGame.jsp");
		dispatcher.forward(request, response);
	}

}
