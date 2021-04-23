package model;

import java.util.ArrayList;
import java.util.List;
public class HandConversionLogic {

	// 手札のカードを点数に変換する処理を行うモデル
	// プレイヤーor親の手札を受け取り処理する

	/* カードと点数の対応例
	*  カード名 02, 03, 04, 05, 06, 07, 08, 09, 0T, 0J, 0Q, 0K, 0A
	* 	   点数  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 1or11
	*/

	// 変換後の点数を格納するﾘｽﾄを用意
	List<Integer> scoreList = new ArrayList<Integer>();

	// 引数に手札を受け取り、点数のリストに変換して返すﾒｿｯﾄﾞ
	public List<Integer> handConversion(List<String> hand) {

		// 手札を1枚ずつconvertToNum()で点数に変換しscoreListに追加
		for(int i = 0; i< hand.size(); i++) {
			scoreList.add(convertToNum(hand.get(i)));
		}
		/* 手札中のAは全て11で変換されているため、下記条件で11→1に変更する。
		 *  ①手札にAが1枚だけの時、手札の合計が22以上の場合にAは11→1となる
		 *  ➁手札にAが2枚以上の時（例：手札に最大4枚のAが含まれる場合：0A、1A、2A、3A）
		 *    Aは1枚のみ11をとり(0A:11)、残りのAは1となる。(1A:1 2A:1 3A:1)
		 *    手札の合計が22を超える場合に、全てのAが11→1となる
		 */

		// 手札にｴｰｽが含まれている場合
		if(scoreList.indexOf(11)!= -1) {

			int aceCount = 0;		//ｴｰｽの数（11の個数）をｶｳﾝﾄ
			int sum = 0; 		// 手札の合計
			for(int i= 0; i < scoreList.size(); i++) {
				if(scoreList.get(i) == 11)
					aceCount++;
			}

		// ①ｴｰｽが1枚のみ含まれている場合
			if(aceCount ==1) {
				// 手札合計が22以上の場合ｴｰｽ：11→1
				for(int num : scoreList) {
					sum += num;
				}
				if(sum >= 22) {
					scoreList.set(scoreList.indexOf(11),1);
				}
			}
		//	➁ｴｰｽが複数枚含まれている場合
		// aceCount-1枚のｴｰｽを1にセットし合計点を確認
		// 合計点が22以上の場合残り1枚のｴｰｽも1にセット
			if(aceCount > 1) {
				sum=0;
				// aceCount-1枚のエースを11→1に書き換え
				for(int i=0; i<aceCount -1; i++) {
					scoreList.set(scoreList.indexOf(11),1);
					}
				// 合計点が22以上なら残りのエースも11→1に変更
				for(int num : scoreList) {
					sum += num;
				}
				 if(sum >= 22) {
					 scoreList.set(scoreList.indexOf(11), 1);
				}
			}
		}

		return scoreList;
	}

	// カードを点数に変換するメソッド
	public Integer convertToNum (String card) {
		// 文字列cardの2番目の文字を取り出しint型に変換
		// 2番目の文字が数値なら数字に変換


		Integer num = 0; // 点数
		// 絵札でない場合
		if(card.charAt(1)!= 'T'
				&& card.charAt(1)!= 'J'
				&& card.charAt(1)!= 'Q'
				&& card.charAt(1)!= 'K'
				&& card.charAt(1)!= 'A') {

		 num = Character.getNumericValue(card.charAt(1));

		 // 絵札（T、J、Q、K）の場合は10に変換
		}else if(card.charAt(1) == 'T'
				|| card.charAt(1) == 'J'
				|| card.charAt(1) == 'Q'
				|| card.charAt(1) == 'K'){
		num = 10;

		// Aの場合は11に変換
		}else if(card.charAt(1) == 'A') {

		num = 11;

		}
		return num;

	}

}
