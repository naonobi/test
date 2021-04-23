package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CancelLogic;
import model.GamePlayer;
import model.Login;
import model.LoginLogic;


@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cancel.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// cancelConfirm.jspから退会リクエストがある場合
		if(request.getParameter("value") != null) {
			HttpSession session = request.getSession();
			GamePlayer gamePlayer =(GamePlayer)session.getAttribute("gamePlayer");

			// 退会（アカウント削除）を実行
			CancelLogic bo = new CancelLogic();
			boolean result = bo.execute(gamePlayer);

			// 退会処理結果をリクエストスコープに保存
			request.setAttribute("result", result);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cancelResult.jsp");
			rd.forward(request, response);

		}else {

			String errMsg;
			String userId = request.getParameter("userId");
			String pass = request.getParameter("pass");

			// 登録されているアカウントか確認
			Login login = new Login(userId,pass);
			LoginLogic bo = new LoginLogic();
			GamePlayer gamePlayer = bo.execute(login);
			boolean result = false;
				if(gamePlayer != null) {
					result = true;
				}
				if(result) {
					//セッションスコープにアカウントを保存
					HttpSession session = request.getSession();
					session.setAttribute("gamePlayer", gamePlayer);

					//フォワード
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cancelConfirm.jsp");
					rd.forward(request, response);
				}else {
					//エラーメッセージを表示
					errMsg = "ユーザーIDまたはパスワードが異なります";
					request.setAttribute("errMsg", errMsg);
					//ログイン画面へフォワード
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cancel.jsp");
					rd.forward(request, response);
				}
		}
	}
}
