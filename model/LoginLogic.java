package model;

import dao.AccountDAO;

public class LoginLogic {

	public GamePlayer execute(Login login) {
		AccountDAO dao = new AccountDAO();
		GamePlayer account = dao.findByLogin(login);

		return account;
	}

}
