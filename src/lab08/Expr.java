package lab08;

public abstract class Expr {

	protected Expr expr_one;
	protected Expr expr_two;

	protected int val;

	public Expr(Expr expr_one, Expr expr_two) {
		this.expr_one = expr_one;
		this.expr_two = expr_two;
	}

	public Expr(Expr expr_one) {
		this.expr_one = expr_one;
	}

	public Expr(int val) {
		this.val = val;
	}

	abstract int eval();

}
