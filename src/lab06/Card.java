package lab06;

public class Card {

	public static void main(String[] args) {
		Card c1 = new Card(Suit.Hearts, 5);
		Card c2 = new Card(Suit.Diamonds, 10);
		Card c3 = new Card(Suit.Clubs, 11);
		Card c4 = new Card(Suit.Spades, 9);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}
	
	
	public static enum Suit {
		Hearts, Diamonds, Clubs, Spades;
	}

	private Suit suit;
	private int value;

	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Card))
			return false;
		Card c = (Card) other;
		return c.value == value && c.suit == suit;
	}

	@Override
	public String toString() {
		return (value == 11 ? "Ace" : value) + " of " + suit.toString();
	}

	@Override
	public int hashCode() {
		return 31 * suit.hashCode() + value;
	}
	
	

}
