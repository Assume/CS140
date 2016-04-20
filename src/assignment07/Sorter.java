package assignment07;

public class Sorter implements Visitor {
	/*
	 * Unused
	 */
	@Override
	public void visit(Product p) {
		// TODO Auto-generated method stub
	}

	/*
	 * Sorts the Subassembly passed
	 * 
	 * @param p the Subassembly to be sorted
	 */
	@Override
	public void visit(Subassembly p) {
		p.sort();

	}

	/*
	 * Unused
	 */
	@Override
	public void visit(Piece p) {
		// TODO Auto-generated method stub

	}

}
