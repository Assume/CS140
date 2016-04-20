package lab08;

public class Const extends Expr {

	public Const(int val) {
		super(val);
	}
	
	@Override
	int eval() {
		return val;
	}

}
