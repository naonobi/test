package model;

import dao.AccountDAO;

public class LogoutLogic {

	public boolean execute(GamePlayer account) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.logout(account);
		return result;
	}

}
