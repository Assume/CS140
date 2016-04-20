package assignment07;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class Tester {

	Piece[] piece;
	Subassembly[] assembly;

	@Before
	public void setup() {
		piece = new Piece[11];
		assembly = new Subassembly[5];
		piece[0] = new Piece("Piece ", 25, 100);
		piece[1] = new Piece("Piece ", 50, 100);
		piece[2] = new Piece("Piece ", 20, 75);
		piece[3] = new Piece("Piece ", 35, 50);
		for (int i = 4; i < 11; i++) {
			Random rand = new Random();
			Piece p1 = new Piece("Piece ", rand.nextDouble() * 25, rand.nextDouble() * 100);
			piece[i] = p1;
		}
		for (int i = 1; i < 5; i++) {
			assembly[i] = new Subassembly("Assembly ");
			Random rand = new Random();
			assembly[i].add(piece[rand.nextInt(10)]);
		}
		assembly[0] = new Subassembly("Assembly ");
		assembly[0].add(piece[0]);
		assembly[0].add(piece[1]);
		assembly[0].add(piece[2]);
		assembly[0].add(piece[3]);
		assembly[2].add(assembly[1]);
		assembly[3].add(assembly[4]);
		assembly[3].add(assembly[1]);
	}

	@Test
	public void testGetCost() {
		assertEquals(assembly[0].getCost(), 130, .0000001);
	}

	@Test
	public void testGetTime() {
		assertEquals(assembly[0].getManufactureTime(), 100, .00001);
	}

	@Test
	public void testCostIncrease() {
		Visitor v = new CostIncreaseVisitor(50);
		for (Product p : assembly[0])
			p.accept(v);
		assertEquals(assembly[0].getCost(), 195, .0000001);
	}

	@Test
	public void testTimeIncrease() {
		Visitor v = new ManufactureTimeIncreaseVisitor(-25);
		for (Product p : assembly[0])
			p.accept(v);
		assertEquals(assembly[0].getManufactureTime(), 75, .0000001);
	}

	@Test
	public void testSort() {
		Visitor v = new Sorter();
		for (Product p : assembly[0])
			p.accept(v);
	}

}
