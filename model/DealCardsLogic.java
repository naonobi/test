package model;

import java.util.List;

public class DealCardsLogic {

	public DealCardsLogic() {}

		List<String> deckList;
	// 山札、プレイヤー、親を引数として受け取り、プレイヤーと親にカードを配布する
	// 初回のみ実行
	public void firstDeal(Deck deck,GamePlayer gp, GameMaster gm) {

		deckList = deck.getDeckList();


		for(int i =0; i < 2; i++) {
			gp.setHand(deckList.get(i));
			deckList.remove(i);
		}
		gm.setHand(deckList.get(2));
		deckList.remove(2);

	}
	// 山札から1枚カードを取り出し配布する
	public void deal(Deck deck,Player player) {

		deckList = deck.getDeckList();
		player.setHand(deckList.get(0));
		deckList.remove(0);
	}

}
