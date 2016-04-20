package pippin;

public class Code {

	public static final int CODE_MAX = 256;

	private long[] code = new long[CODE_MAX];

	private int nextCodeIndex = 0;

	public static long join(int opPart, int arg) {
		long longOp = opPart;
		long longArg = arg;
		// move the opcode to the upper 32 bits
		longOp = longOp << 32;
		// if arg was negative, longArg will have 32 leading 1s,
		// remove them:
		longArg = longArg & 0x00000000FFFFFFFFL;
		// join the upper 32 bits and the lower 32 bits
		return longOp | longArg;
	}

	public void setCode(int op, int arg) {
		if (nextCodeIndex == CODE_MAX)
			throw new CodeAccessException("Attempt to access code outside its bounds");
		code[nextCodeIndex++] = join(op, arg);
	}

	public int getOpPart(int i) {
		if (i < 0 || i > nextCodeIndex)
			throw new CodeAccessException("Attempt to access code outside its bounds");
		return (int) (code[i] >> 32);
	}

	public int getArg(int i) {
		if (i < 0 || i > nextCodeIndex)
			throw new CodeAccessException("Attempt to access code outside its bounds");
		return (int) code[i];
	}

	public void clear() {
		code = new long[CODE_MAX];
		nextCodeIndex = 0;
	}

}
