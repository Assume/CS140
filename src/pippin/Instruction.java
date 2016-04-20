package pippin;

public interface Instruction {

	void execute(int arg, int flags);

	static int numOnes(int input) {
		String str = Integer.toUnsignedString(input, 2);
		int total = 0;
		for (char x : str.toCharArray())
			if (x == '1')
				total++;
		return total;
	}
	
	static void checkParity(int input){
		if(input % 2 != 0)
			throw new ParityCheckException("The instruction is corrupted.");
	}

}
