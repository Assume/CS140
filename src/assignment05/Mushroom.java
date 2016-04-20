package assignment05;

public class Mushroom extends PizzaTopping {

	public Mushroom(Pizza on) {
		super(on);
	}

	@Override
	public double getCost() {
		return .25 + getOn().getCost();
	}
	
	

}
