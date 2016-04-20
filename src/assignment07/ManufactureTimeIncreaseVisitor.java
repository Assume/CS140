package assignment07;

public class ManufactureTimeIncreaseVisitor implements Visitor {

	private double increase;

	/*
	 * @param increase the percentage by which to increase manufacture time
	 */
	public ManufactureTimeIncreaseVisitor(double increase) {
		this.increase = increase;
	}

	/*
	 * Unused
	 */
	@Override
	public void visit(Product p) {
		// TODO Auto-generated method stub

	}

	/*
	 * Unused
	 */
	@Override
	public void visit(Subassembly p) {
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 * Increases the manufacture time of p by the percent in increase
	 * 
	 * @param p The piece of which manufacture time should be increased
	 */
	@Override
	public void visit(Piece p) {
		p.setManufactureTime(p.getManufactureTime() + (p.getManufactureTime() * (increase / 100)));
	}

}
