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
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errMsg;

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		//ログイン処理の実行
		Login login = new Login(userId,pass);
		LoginLogic bo = new LoginLogic();
		GamePlayer gamePlayer = bo.execute(login);
		boolean result = false;
		if(gamePlayer != null) {
			result = true;
		}


		//
		if(result) {
			//セッションスコープにアカウントを保存
			HttpSession session = request.getSession();
			session.setAttribute("gamePlayer", gamePlayer);

			//フォワード
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/gameChoice.jsp");
			rd.forward(request, response);
		}else {
			//エラーメッセージを表示
			errMsg = "ユーザーIDまたはパスワードが異なります";
			request.setAttribute("errMsg", errMsg);
			//ログイン画面へフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

}
