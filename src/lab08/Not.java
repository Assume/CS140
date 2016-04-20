package lab08;

public class Not extends Expr {

	public Not(Expr expr_one) {
		super(expr_one);

	}

	@Override
	int eval() {
		int value = expr_one.eval();
		return value > 0 || value < 0 ? 0 : 1;
	}

}
