package pippin;

public interface Instruction {

	void execute(int arg, int flags);

	static int numOnes(int i) {
		/*
		 * String str = Integer.toUnsignedString(input, 2); int total = 0; for
		 * (char x : str.toCharArray()) if (x == '1') total++; return total;
		 */
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
	}

	static void checkParity(int input) {
		if (input % 2 != 0)
			throw new ParityCheckException("The instruction is corrupted.");
	}

}
