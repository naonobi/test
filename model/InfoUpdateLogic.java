package model;

public class InfoUpdateLogic {

	// 勝敗とベット金額に応じてプレイヤーの情報を操作する
	// プレイヤーの残高からベット金額分を減算
	public void betWallet(GamePlayer gp) {
		int sum = (gp.getWallet()) - (gp.getBet());
		gp.setWallet(sum);
	}

	// GamePlayerを引数として受け取る（勝敗結果、ベット金額）
	public void infoUpdate(GamePlayer gp) {

		int result = gp.getResult(); // 勝敗結果
		int bet = gp.getBet(); // ベット金額
		int wallet = gp.getWallet();

		// 勝ちの場合
		switch(result) {
		case 1:
			// ベット金額を倍にしてwalletに追加する
			gp.setWallet(wallet + bet * 2);
			break;

		// 引き分けの場合
		case 0:
			// ベット金額をそのまま返す
			gp.setWallet(wallet + bet);
			break;

		// 負けの場合
			// ベットされた金額は返されない(処理なし）

		}

	}

}