package pippin;

import java.util.Map;
import java.util.TreeMap;

public class InstructionMap {

	public static Map<String, Integer> opcode = new TreeMap<String, Integer>();

	public static Map<Integer, String> mnemonics = new TreeMap<Integer, String>();

	static {
		opcode.put("NOP", 0x0);
		opcode.put("LOD", 0x1);
		opcode.put("STO", 0x2);
		opcode.put("JUMP", 0x3);
		opcode.put("JMPZ", 0x4);
		opcode.put("ADD", 0x5);
		opcode.put("SUB", 0x6);
		opcode.put("MUL", 0x7);
		opcode.put("DIV", 0x8);
		opcode.put("AND", 0x9);
		opcode.put("NOT", 0xA);
		opcode.put("CMPL", 0xB);
		opcode.put("CMPZ", 0xC);
		opcode.put("HALT", 0xF);
		opcode.put("FOR", 0xD);
		for (String x : opcode.keySet())
			mnemonics.put(opcode.get(x), x);

	}

}
