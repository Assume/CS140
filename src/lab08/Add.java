package lab08;

public class Add extends Expr {

	public Add(Expr expr_one, Expr expr_two) {
		super(expr_one, expr_two);
	}

	@Override
	int eval() {
		return expr_one.eval() + expr_two.eval();
	}

}
