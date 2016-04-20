package assignment07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Product implements Iterable<Product>, Comparable<Product> {

	private String description;

	private int indent;

	/*
	 * @param description the description of the product
	 */
	public Product(String description) {
		this.description = description;
	}

	protected abstract void addAllParts(int indent, List<Product> list);

	public abstract double getCost();

	public abstract double getManufactureTime();

	abstract void accept(Visitor v);

	/*
	 * @return the value in indent
	 */
	public int getIndent() {
		return indent;
	}

	/*
	 * @param the value to set indent to
	 */
	public void setIndent(int indent) {
		this.indent = indent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Product> iterator() {
		List<Product> list = new ArrayList<Product>();
		list.add(this);
		addAllParts(0, list);
		return list.iterator();
	}

	/*
	 * @param the value to set cost to
	 * 
	 * @throws UnsupportedOperationException always
	 */
	public void setCost(double cost) {
		throw new UnsupportedOperationException("Method setCost cannot be " + "called on this object");
	}

	/*
	 * @param the value to set manufacture_time to
	 * 
	 * @throws UnsupportedOperationException always
	 */
	public void setManufactureTime(double time) {
		throw new UnsupportedOperationException("Method setManufactureTime cannot be " + "called on this object");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Product other) {
		if (this instanceof Piece && other instanceof Subassembly)
			return -1;
		if (this instanceof Subassembly && other instanceof Piece)
			return 1;
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < indent; i++)
			builder.append("--");
		builder.append(description);
		return builder.toString();
	}

}
