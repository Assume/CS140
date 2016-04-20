package assignment07;

public interface Visitor {

	public void visit(Product p);
	
	public void visit(Subassembly p);
	
	public void visit(Piece p);
	
}
