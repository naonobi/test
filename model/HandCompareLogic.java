package model;

import java.util.List;

public class HandCompareLogic {

	// 親とプレイヤーの手札を比較して、プレイヤーの合計値が大きければ勝ち
	// 小さければ負けをプレイヤーのResultプロパティに付与するメソッド
	public void handCompare(GamePlayer gp, GameMaster gm) {
		// フィールド値
		List<String> playerHand = gp.getHand();
		List<String> gmHand = gm.getHand();
		CalcHandSumLogic chsLogic = new CalcHandSumLogic();

		// 手札の合計
		Integer playerHandSum = chsLogic.calcHandSum(gp);
		Integer gmHandSum = chsLogic.calcHandSum(gm);


		// プレイヤーの合計が大きい場合(プレイヤーの勝ち)はresultに１をセット
		if(playerHandSum> gmHandSum) {
			gp.setResult(1);
		// 親とプレイヤーの合計が等しい場合(引き分け)はresultに0をセット
		}else if(playerHandSum == gmHandSum) {
			gp.setResult(0);
		// プレイヤーの合計が小さい場合(プレイヤーの負け)はresultに１をセット
		}else {
			gp.setResult(-1);
		}
	}
}