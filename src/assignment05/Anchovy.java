package assignment05;

public class Anchovy extends PizzaTopping {

	public Anchovy(Pizza on) {
		super(on);
	}

	@Override
	public double getCost() {
		return .75 + getOn().getCost();
	}

}
