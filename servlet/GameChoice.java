package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GameChoice")
public class GameChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 各ゲーム画面の「ゲーム選択画面へ」からリクエストされた場合
		request.setCharacterEncoding("UTF-8");
		int select = Integer.parseInt(request.getParameter("select"));

		// selectが1の場合、ゲーム選択画面へフォワード
		if(select ==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameChoice.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		int choice = Integer.parseInt(request.getParameter("choice"));

		//choiceが１のとき、BJのGameStartサーブレットへ
		if(choice == 1) {
			//フォワード
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
			rd.forward(request, response);
		}else if(choice == 2){
			//PKのゲーム開始サーブレットへリダイレクト
			response.sendRedirect("/bj/GameStartPK");

		}else {
			//SVのゲーム開始JSPへフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sv_jsp/gameStart.jsp");
			rd.forward(request, response);		}
	}

}
