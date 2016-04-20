package assignment05;

public class ExtraCheese extends PizzaTopping {

	public ExtraCheese(Pizza on) {
		super(on);
	}

	@Override
	public double getCost() {
		return .25 + getOn().getCost();
	}

}
