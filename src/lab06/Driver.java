package lab06;

import lab06.Card.Suit;

public class Driver {

	public static void main(String[] args) {

		Card c1 = new Card(Suit.Hearts, 2);
		Card c2 = new Card(Suit.Hearts, 3);
		Card c3 = new Card(Suit.Hearts, 4);
		Card c4 = new Card(Suit.Hearts, 5);
		Card c5 = new Card(Suit.Hearts, 6);
		Card c6 = new Card(Suit.Hearts, 7);
		Card c7 = new Card(Suit.Hearts, 9);
		Card c8 = new Card(Suit.Hearts, 9);
		Card c9 = new Card(Suit.Hearts, 10);
		Card c10 = new Card(Suit.Hearts, 11);

		BlackjackMethod method = new BlackjackMethod();

		ComposedHand h1 = new ComposedHand(method);
		h1.addCard(c3);
		h1.addCard(c1);
		System.out.println(h1.value());

		ComposedHand h2 = new ComposedHand(method);
		h2.addCard(c9);
		h2.addCard(c10);
		System.out.println(h2.value());

		ComposedHand h3 = new ComposedHand(method);
		h3.addCard(c10);
		h3.addCard(c10);
		System.out.println(h3.value());

		ComposedHand h4 = new ComposedHand(method);
		h4.addCard(c10);
		h4.addCard(c10);
		h4.addCard(c10);
		System.out.println(h4.value());

		ComposedHand h5 = new ComposedHand(method);
		h5.addCard(c9);
		h5.addCard(c9);
		h5.addCard(c1);
		System.out.println(h5.value());
		
		ComposedHand h6 = new ComposedHand(method);
		h6.addCard(c9);
		h6.addCard(c9);
		h6.addCard(c10);
		System.out.println(h6.value());

	}

}
