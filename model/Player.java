package model;

import java.util.ArrayList;
import java.util.List;

public interface Player {
	List<String> hand = new ArrayList();

	List<String> getHand();
	void setHand(String string);

}
