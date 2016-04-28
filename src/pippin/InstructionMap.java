package pippin;

import java.util.Map;
import java.util.TreeMap;

public class InstructionMap {

	public static Map<String, Integer> opcode = new TreeMap<String, Integer>();

	static {
		opcode.put("NOP", 0x0);
		opcode.put("LOD", 0x1);
		opcode.put("STO", 0x2);
		opcode.put("JUMP", 0x3);
		
	}

}
