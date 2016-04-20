package assignment05;

import static org.junit.Assert.*;

import org.junit.Test;

public class PizzaTester {

	@Test
	public void test1() {
		Pizza pizza = new MediumCheesePizza();
		pizza = new Mushroom(pizza);
		pizza = new Anchovy(pizza);
		pizza = new ExtraCheese(pizza);
		System.out.println(pizza.getCost());
		assertEquals(pizza.getCost(), 11.25, 0.000001);
	}
	
	@Test
	public void test2(){
		Pizza pizza = new SmallCheesePizza();
		pizza = new Mushroom(pizza);
		pizza = new Anchovy(pizza);
		pizza = new ExtraCheese(pizza);
		System.out.println(pizza.getCost());
		assertEquals(pizza.getCost(), 9.25, 0.000001);
	}

}
