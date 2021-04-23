package model;

import java.util.ArrayList;
import java.util.List;

public class GameMaster implements Player{
	private List<String> hand = new ArrayList<>();
	private int handSum;

	public List<String> getHand(){
		return hand;
	}
	public void setHand(String card) {
		hand.add(card);
	}
	public int getHandSum() {
		return handSum;
	}
	public void setHandSum(int handSum) {
		this.handSum = handSum;
	}

}
