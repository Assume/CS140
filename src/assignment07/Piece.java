package assignment07;

import java.util.List;

public class Piece extends Product {

	private double cost;
	private double manufacture_time;

	/*
	 * @param description the description of the product
	 * 
	 * @param cost the cost of the product
	 * 
	 * @param manufacture_time the manufacture time of the product
	 */
	public Piece(String description, double cost, double manufacture_time) {
		super(description);
		this.cost = cost;
		this.manufacture_time = manufacture_time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see assignment07.Product#getCost()
	 */
	@Override
	public double getCost() {
		return cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see assignment07.Product#getManufactureTime()
	 */
	@Override
	public double getManufactureTime() {
		return manufacture_time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see assignment07.Product#setCost(double)
	 */
	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see assignment07.Product#setManufactureTime(double)
	 */
	@Override
	public void setManufactureTime(double time) {
		this.manufacture_time = time;
	}

	/*
	 * @param indent the indent to be set
	 * 
	 * @param list unused
	 */
	@Override
	protected void addAllParts(int indent, List<Product> list) {
		setIndent(indent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see assignment07.Product#accept(assignment07.Visitor)
	 */
	@Override
	void accept(Visitor v) {
		v.visit(this);
	}

}
