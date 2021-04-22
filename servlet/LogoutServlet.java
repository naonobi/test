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
import model.LogoutLogic;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープのwalletを取得して上書き
		HttpSession session = request.getSession();
		GamePlayer gp = (GamePlayer)session.getAttribute("gamePlayer");


		//walletの上書き処理
		LogoutLogic bo = new LogoutLogic();
		bo.execute(gp);

		//セッションスコープのインスタンスを破棄
		session.invalidate();

		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
		rd.forward(request, response);
	}

}
