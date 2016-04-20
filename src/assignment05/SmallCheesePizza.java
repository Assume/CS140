package assignment05;

public class SmallCheesePizza implements Pizza {

	@Override
	public int compareTo(Pizza arg0) {
		if (arg0 instanceof MediumCheesePizza)
			return -1;
		else if (arg0 instanceof LargeCheesePizza)
			return 1;
		return 0;
	}

	@Override
	public String getDescription() {
		return "Small cheese pizza";
	}

	@Override
	public double getCost() {
		return 8;
	}

}
