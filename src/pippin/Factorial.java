package pippin;

public class Factorial {

	public static void main(String[] args) {
		MachineModel test = new MachineModel();
		test.setData(0, 8);
		test.setRunning(true);
		// LOD
		test.setCode(1 * 8 + 1, 0);
		// STO
		test.setCode(2 * 8 + 1, 1);
		// LOD
		test.setCode(1 * 8 + 1, 0);
		// SUB
		test.setCode(6 * 8 + 1 + 2, 1);
		// STO
		test.setCode(2 * 8 + 1, 0);
		// CMPZ
		test.setCode(0xC * 8, 0);
		// SUB
		test.setCode(6 * 8 + 1 + 2, 1);
		// JPMZ
		test.setCode(4 * 8 + 1, 4);
		// LOD
		test.setCode(1 * 8 + 1, 0);
		// MUL
		test.setCode(7 * 8 + 1, 1);
		// JUMP
		test.setCode(3 * 8 + 1 + 2, 1);
		// HALT
		test.setCode(0xF * 8, 0);
		int result = 0;
		while (test.isRunning()) {
			if (result != test.getData(1)) {
				result = test.getData(1);
				System.out.println("0 => " + test.getData(0) + "; 1 => " + result);
			}
			test.step();
		}
	}

}
