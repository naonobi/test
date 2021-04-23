package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<String> deckList;

	public Deck() {
		deckList = new ArrayList<>();
		deckList.add("02");
		deckList.add("03");
		deckList.add("04");
		deckList.add("05");
		deckList.add("06");
		deckList.add("07");
		deckList.add("08");
		deckList.add("09");
		deckList.add("0T");
		deckList.add("0J");
		deckList.add("0Q");
		deckList.add("0K");
		deckList.add("0A");
		deckList.add("12");
		deckList.add("13");
		deckList.add("14");
		deckList.add("15");
		deckList.add("16");
		deckList.add("17");
		deckList.add("18");
		deckList.add("19");
		deckList.add("1T");
		deckList.add("1J");
		deckList.add("1Q");
		deckList.add("1K");
		deckList.add("1A");
		deckList.add("22");
		deckList.add("23");
		deckList.add("24");
		deckList.add("25");
		deckList.add("26");
		deckList.add("27");
		deckList.add("28");
		deckList.add("29");
		deckList.add("2T");
		deckList.add("2J");
		deckList.add("2Q");
		deckList.add("2K");
		deckList.add("2A");
		deckList.add("32");
		deckList.add("33");
		deckList.add("34");
		deckList.add("35");
		deckList.add("36");
		deckList.add("37");
		deckList.add("38");
		deckList.add("39");
		deckList.add("3T");
		deckList.add("3J");
		deckList.add("3Q");
		deckList.add("3K");
		deckList.add("3A");

		Collections.shuffle(deckList);

	}

	public List<String> getDeckList(){
		return deckList;
	}




}
