package model;

import dao.AccountDAO;

public class RegisterLogic {

	public boolean execute(String id,String pass,String name,int age,int wallet) {
		GamePlayer account = new GamePlayer(id,pass,name,age,wallet);
		AccountDAO dao = new AccountDAO();
		boolean result = dao.userRegister(account);
		return result;
	}

}
