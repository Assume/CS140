package lab06;

import java.util.ArrayList;
import java.util.List;

public class ComposedHand {

	protected List<Card> cards = new ArrayList<Card>();

	private ComputationMethod method;
	
	public ComposedHand(ComputationMethod method){
		this.method = method;
	}
	
	
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
	
	public int value(){
		return method.compute(cards);
	}
	
}
