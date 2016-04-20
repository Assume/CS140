package lab06;

import java.util.ArrayList;
import java.util.List;

public abstract class CardHand {

	protected List<Card> cards = new ArrayList<Card>();

	public void addCard(Card c) {
		cards.add(c);
	}

	public void clear() {
		cards.clear();
	}
	
	@Override
	public String toString(){
		return cards.toString();
	}
	
	public abstract int value();
	
	
	
	

}
