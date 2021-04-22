package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterLogic;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher rd
		= request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int wallet = 0;


		RegisterLogic bo = new RegisterLogic();
		boolean result = bo.execute(userId, pass, name, age, wallet);

		//リクエストスコープに結果と名前を保存
		request.setAttribute("result", result);
		request.setAttribute("name", name);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/registerResult.jsp");
		rd.forward(request, response);


	}

}
