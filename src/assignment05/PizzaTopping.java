package assignment05;

public class PizzaTopping implements Pizza {

	private Pizza on;

	public PizzaTopping(Pizza on) {
		this.on = on;
	}

	public void setOn(Pizza on) {
		this.on = on;
	}

	public Pizza getOn() {
		return this.on;
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName()
				+ (on instanceof PizzaTopping ? ", " : " on ")
				+ on.getDescription();
	}

	@Override
	public int compareTo(Pizza p) {
		if (p instanceof PizzaTopping)
			return getClass().getSimpleName().compareTo(
					p.getClass().getSimpleName());
		return -1;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
