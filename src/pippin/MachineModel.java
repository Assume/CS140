package pippin;

public class MachineModel {

	public final Instruction[] INSTRUCTIONS = new Instruction[0x10];
	private CPU cpu = new CPU();
	private Memory memory = new Memory();

	private boolean with_gui = false;

	public MachineModel(boolean with_gui) {
		this.with_gui = with_gui;

		// INSTRUCTION_MAP entry for "NOP"
		INSTRUCTIONS[0] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags != 0) {
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// LOD
		INSTRUCTIONS[0x1] = (arg, flags) -> {
			flags = flags & 0x6;
			switch (flags) {
			case 0:
				cpu.accum = memory.getData(arg);
				break;
			case 2:
				cpu.accum = arg;
				break;
			case 4:
				cpu.accum = memory.getData(memory.getData(arg));
				break;
			default:
				throw new IllegalArgumentException();
			}
			cpu.pc++;
		};

		// STO
		INSTRUCTIONS[0x2] = (arg, flags) -> {
			flags = flags & 0x6;
			switch (flags) {
			case 0:
				memory.setData(arg, cpu.accum);
				break;
			case 4:
				memory.setData(memory.getData(arg), cpu.accum);
				break;
			default:
				throw new IllegalArgumentException();
			}
			cpu.pc++;
		};

		// JUMP
		INSTRUCTIONS[0x3] = (arg, flags) -> {
			flags = flags & 0x6;
			switch (flags) {
			case 0:
				cpu.pc += arg;
				break;
			case 2:
				cpu.pc = arg;
				break;
			case 4:
				cpu.pc += memory.getData(arg);
				break;
			default:
				cpu.pc = memory.getData(arg);
			}
		};

		// JUMPZ
		INSTRUCTIONS[0x4] = (arg, flags) -> {
			flags = flags & 0x6;
			if (cpu.accum == 0)
				switch (flags) {
				case 0:
					cpu.pc += arg;
					break;
				case 2:
					cpu.pc = arg;
					break;
				case 4:
					cpu.pc += memory.getData(arg);
					break;
				default:
					cpu.pc = memory.getData(arg);
				}
			else
				cpu.pc++;
		};

		// ADD
		INSTRUCTIONS[0x5] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) { // direct addressing
				cpu.accum += memory.getData(arg);
			} else if (flags == 2) { // immediate addressing
				cpu.accum += arg;
			} else if (flags == 4) { // indirect addressing
				cpu.accum += memory.getData(memory.getData(arg));
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// SUB
		INSTRUCTIONS[0x6] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) { // direct addressing
				cpu.accum -= memory.getData(arg);
			} else if (flags == 2) { // immediate addressing
				cpu.accum -= arg;
			} else if (flags == 4) { // indirect addressing
				cpu.accum -= memory.getData(memory.getData(arg));
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// MUL
		INSTRUCTIONS[0x7] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) { // direct addressing
				cpu.accum *= memory.getData(arg);
			} else if (flags == 2) { // immediate addressing
				cpu.accum *= arg;
			} else if (flags == 4) { // indirect addressing
				cpu.accum *= memory.getData(memory.getData(arg));
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// DIV
		INSTRUCTIONS[0x8] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) { // direct addressing
				int divisor = memory.getData(arg);
				if (divisor == 0)
					throw new DivideByZeroException();
				cpu.accum /= memory.getData(arg);
			} else if (flags == 2) { // immediate addressing
				if (arg == 0)
					throw new DivideByZeroException();
				cpu.accum /= arg;
			} else if (flags == 4) { // indirect addressing
				int divisor = memory.getData(memory.getData(arg));
				if (divisor == 0)
					throw new DivideByZeroException();
				cpu.accum /= divisor;
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// AND
		INSTRUCTIONS[0x9] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) { // direct addressing
				cpu.accum = cpu.accum != 0 && memory.getData(arg) != 0 ? 1 : 0;
			} else if (flags == 2) { // immediate addressing
				cpu.accum = cpu.accum != 0 && arg != 0 ? 1 : 0;
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// NOT
		INSTRUCTIONS[0xA] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) {// direct addressing
				cpu.accum = cpu.accum == 0 ? 1 : 0;
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// CMPL
		INSTRUCTIONS[0xB] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) {// direct addressing
				cpu.accum = memory.getData(arg) < 0 ? 1 : 0;
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// CMPZ
		INSTRUCTIONS[0xC] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) {// direct addressing
				cpu.accum = memory.getData(arg) == 0 ? 1 : 0;
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			cpu.pc++;
		};

		// HALT
		INSTRUCTIONS[0xF] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been
									// verified
			if (flags == 0) {// direct addressing
				halt();
			} else { // here the illegal case is "11"
				String fString = "(" + (flags % 8 > 3 ? "1" : "0") + (flags % 4 > 1 ? "1" : "0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
		};

	}

	public void halt() {
		if (!with_gui)
			System.exit(0);
	}

	private class CPU {
		private int accum;
		private int pc;

	}

	public void setData(int i, int j) {
		memory.setData(i, j);
	}

	public Instruction get(int i) {
		return INSTRUCTIONS[i];
	}

	int[] getData() {
		return memory.getData();
	}

	public int getPC() {
		return cpu.pc;
	}

	public int getAccum() {
		return cpu.accum;
	}

	public void setAccum(int i) {
		cpu.accum = i;
	}

}
