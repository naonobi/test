package model;

public class BurstJudgeLogic {
boolean burst;

	// ユーザーの手札の合計が21を超えているかどうかを判定する(バースト判定)メソッド
	public boolean burstJudge(Player player) {
		CalcHandSumLogic chsLogic = new CalcHandSumLogic();
		int handSum = chsLogic.calcHandSum(player);
		if(handSum > 21) {
			burst = true; // バーストしていたらtrue
		}else {
			burst = false; // バーストしていなかったらfalse
		}
		return burst;
	}
}
