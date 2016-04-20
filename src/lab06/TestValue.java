package lab06;

import static org.junit.Assert.*;
import lab06.Card.Suit;

import org.junit.Test;

public class TestValue {

	@Test
	public void test(){
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
		
		BlackjackHand h1 = new BlackjackHand();
		h1.addCard(c3);
		h1.addCard(c1);
		
		BlackjackHand h2 = new BlackjackHand();
		h2.addCard(c9);
		h2.addCard(c10);
		
		BlackjackHand h3 = new BlackjackHand();
		h3.addCard(c10);
		h3.addCard(c10);
		
		BlackjackHand h4 = new BlackjackHand();
		h4.addCard(c10);
		h4.addCard(c10);
		h4.addCard(c10);
		
		BlackjackHand h5 = new BlackjackHand();
		h5.addCard(c9);
		h5.addCard(c9);
		h5.addCard(c1);
		
		BlackjackHand h6 = new BlackjackHand();
		h6.addCard(c9);
		h6.addCard(c9);
		h6.addCard(c10);
		
		assertEquals(h1.value(), 6);
		assertEquals(h2.value(), 21);
		assertEquals(h3.value(), 12);
		assertEquals(h4.value(), 13);
		assertEquals(h5.value(), 22);
		assertEquals(h6.value(), 21);
	}
	
}
