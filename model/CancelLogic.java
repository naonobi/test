package model;

import dao.AccountDAO;

public class CancelLogic {

	public boolean execute(GamePlayer gamePlayer) {
		AccountDAO dao = new AccountDAO();
		return dao.cancelMembership(gamePlayer);
	}
}
