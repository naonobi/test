package model;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer implements Player{

	private String id;
	private String pass;
	private String name;
	private int age;
	private int wallet;
	private List<String> hand = new ArrayList<>();
	private int result;
	private int bet;
	private int handSum;
	private int baseBet;

	public GamePlayer() {}
	public GamePlayer(String id,String pass,String name,int age,int wallet) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.wallet = wallet;
	}
	public String getId() {return id;}
	public String getPass() {return pass;}
	public String getName() {return name;}
	public int getAge() {return age;}
	public int getWallet() {return wallet;}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public List<String> getHand(){return hand;}
	public void setHand(String card) {
		this.hand.add(card);;
	}
	public int getResult() {return result;}
	public void setResult(int result) {
		this.result = result;
	}
	public int getBet(){return bet;}
	public void setBet(int bet) {
		this.bet = bet;
	}
	public void setHandSum(int handSum) {
		this.handSum = handSum;
	}
	public int getHandSum() {
		return handSum;
	}
	public int getBaseBet() {return baseBet;}
	public void setBaseBet(int baseBet) {
		this.baseBet = baseBet;
	}

}
