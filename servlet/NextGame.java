package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GameMaster;
import model.GamePlayer;


@WebServlet("/NextGame")
public class NextGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープにあるインスタンスのhandをリセット
		HttpSession session = request.getSession();
		GamePlayer gp = (GamePlayer) session.getAttribute("gamePlayer");
		GameMaster gm = (GameMaster) session.getAttribute("gameMaster");
		gp.getHand().clear();
		gm.getHand().clear();

		//セッションスコープ上の山札も削除
		session.removeAttribute("deck");

		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
		rd.forward(request, response);
	}

}
