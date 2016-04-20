package assignment07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subassembly extends Product {

	/*
	 * @param description the descripion of the product
	 */
	public Subassembly(String description) {
		super(description);
	}

	private List<Product> parts = new ArrayList<Product>();

	/*
	 * @return the total cost of all Products in parts
	 */
	@Override
	public double getCost() {
		double tot = 0;
		for (Product x : parts)
			tot += x.getCost();
		return tot;
	}

	/*
	 * @return the longest manufacture time of part in parts
	 * 
	 * @see assignment07.Product#getManufactureTime()
	 */
	@Override
	public double getManufactureTime() {
		double largest = 0;
		for (Product x : parts)
			if (x.getManufactureTime() > largest)
				largest = x.getManufactureTime();

		return largest;
	}

	/*
	 * adds a product to parts
	 */
	public void add(Product p) {
		parts.add(p);
	}

	/*
	 * adds all products to all products in parts
	 * 
	 * @param indent the value to be passed as indent
	 * 
	 * @param list the list of products to be added
	 * 
	 * @see assignment07.Product#addAllParts(int, java.util.List)
	 */
	@Override
	protected void addAllParts(int indent, List<Product> list) {
		setIndent(indent);
		for (Product p : parts) {
			list.add(p);
			p.addAllParts(1 + indent, list);
		}
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

	/*
	 * Calls Collections#sort on parts
	 */
	public void sort() {
		Collections.sort(parts);
	}

}
