package assignment05;

public class Pepperoni extends PizzaTopping {

	public Pepperoni(Pizza on) {
		super(on);
	}

	@Override
	public double getCost() {
		return .50 + getOn().getCost();
	}

}
