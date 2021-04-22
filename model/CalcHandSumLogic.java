package model;

import java.util.List;

public class CalcHandSumLogic {

	// 現在持っている手札の合計を求めるメソッド
	public int calcHandSum(Player player) {

		int handSum = 0;
		List<String> hand = player.getHand();
		HandConversionLogic hcLogic = new HandConversionLogic();
		List<Integer> handInt = hcLogic.handConversion(hand);

		// リストから取り出したカードを数値化した後足し合わせる
		for(int i = 0; i < hand.size(); i++) {
			handSum += handInt.get(i);
			} return handSum;
		}
	}
