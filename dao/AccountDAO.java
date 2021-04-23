package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.GamePlayer;
import model.Login;

public class AccountDAO {
	//データベース接続の情報
	private final String URL = "jdbc:postgresql://localhost:5432/customer";
	private final String USER = "postgres";
	private final String PASS ="ok";

	// DBに登録されているユーザーか確認
	public GamePlayer findByLogin(Login login) {
		GamePlayer account = null;

		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,USER,PASS);
			String sql = "select id,pass,name,age,wallet from account where id = ? and pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getId());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーがいた場合、そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
				String userId = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int wallet = rs.getInt("wallet");
				account = new GamePlayer(userId,pass,name,age,wallet);
			}

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return account;
	}
	// DBにユーザー登録情報を書き込み
	public boolean userRegister(GamePlayer account) {

		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,USER,PASS);
			String sql = "insert into account(id,pass,name,age) values(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());
			pStmt.setInt(4, account.getAge());

			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// ログアウト時にコイン残高を上書きする
	public boolean logout(GamePlayer account) {

		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,USER,PASS);
			String sql = "update account set wallet = ? where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, account.getWallet());
			pStmt.setString(2, account.getId());

			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean cancelMembership(GamePlayer gamePlayer) {

		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,USER,PASS);
			String sql = "delete from account where id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, gamePlayer.getId());

			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
