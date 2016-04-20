package assignment07;

public class CostIncreaseVisitor implements Visitor {

	private double increase;

	/*
	 * @param increase the percentage by which to increase cost
	 */
	public CostIncreaseVisitor(double increase) {
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
	 * Increases the cost of p by the percent in increase
	 * @param p The piece of which cost should be increased
	 */
	@Override
	public void visit(Piece p) {
		p.setCost(p.getCost() + (p.getCost() * (increase / 100)));
	}

}
