package pippin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Assembler {

	public static void main(String[] args) {
		StringBuilder error = new StringBuilder();
		System.out.println("Enter the name of the file without extension: ");
		try (Scanner keyboard = new Scanner(System.in)) {
			String filename = keyboard.nextLine();
			int i = assemble(new File(filename + ".pasm"), new File(filename + ".pexe"), error);
			System.out.println(i + " " + error);
		}
	}

	public static Set<String> noArgument = new TreeSet<String>();

	static {
		noArgument.add("HALT");
		noArgument.add("NOP");
		noArgument.add("NOT");
	}

	/**
	 * Method to assemble a file to its executable representation. If the input
	 * has errors one of the errors will be reported the StringBulder. The error
	 * may not be the first error in the code and will depend on the order in
	 * which instructions are checked. The line number of the error that is
	 * reported is returned as the value of the method. A return value of 0
	 * indicates that the code had no errors and an output file was produced and
	 * saved. If the input or output cannot be opened, the return value is -1.
	 * The unchecked exception IllegalArgumentException is thrown if the error
	 * parameter is null, since it would not be possible to provide error
	 * information about the source code.
	 * 
	 * @param input
	 *            the source assembly language file
	 * @param output
	 *            the executable version of the program if the source program is
	 *            correctly formatted
	 * @param error
	 *            the StringBuilder to store the description of the error that
	 *            is reported. It will be empty (length zero) if no error is
	 *            found.
	 * @return 0 if the source code is correct and the executable is saved, -1
	 *         if the input or output files cannot be opened, otherwise the line
	 *         number of the reported error.
	 */
	public static int assemble(File input, File output, StringBuilder error) {
		if (error == null)
			throw new IllegalArgumentException("Coding error: the error buffer is null");

		ArrayList<String> input_text = new ArrayList<>();
		int ret_val = 0;
		try (Scanner inp = new Scanner(input)) {
			int line_num = 0;
			boolean blank_line_found = false;
			int first_blank_line_num = 0;
			while (inp.hasNextLine() && ret_val == 0) {
				String line = inp.nextLine();
				if (line.trim().length() == 0) {
					blank_line_found = true;
					first_blank_line_num = line_num;
				} else if (blank_line_found) {
					error.append("Illegal blank line in the source file");
					ret_val = first_blank_line_num;
				} else if (line.charAt(0) == ' ' || line.charAt(0) == '\t') {
					error.append("Line starts with illegal white space");
					ret_val = line_num;
				} else
					input_text.add(line.trim());
				line_num++;

			}
			if (ret_val != 0)
				return ret_val;

		} catch (FileNotFoundException e) {
			error.append("Unable to open the assembled file");
			ret_val = -1;
		}

		ArrayList<String> output_code = new ArrayList<>();
		if (ret_val == 0)
			for (int i = 0; i < input_text.size() && ret_val == 0; i++) {
				String[] parts = input_text.get(i).split("\\s+");
				if (!InstructionMap.opcode.containsKey(parts[0].toUpperCase())) {
					error.append("Error on line " + (i + 1) + ": illegal mnemonic");
					ret_val = i + 1;
				} else if (!parts[0].equals(parts[0].toUpperCase())) {
					error.append("Error on line " + (i + 1) + ": mnemonic must be upper case");
					ret_val = i + 1;
				} else if (noArgument.contains(parts[0])) {
					if (parts.length > 1) {
						error.append("Error on line " + (i + 1) + ": this mnemonic cannot take arguments");
						ret_val = i + 1;
					} else {
						int op_part = 8 * InstructionMap.opcode.get(parts[0]);
						op_part += Instruction.numOnes(op_part) % 2;
						output_code.add(Integer.toString(op_part, 16) + " 0");
					}
				} else {
					if (parts.length > 2) {
						error.append("Error on line " + (i + 1) + ": this mnemonic has too many arguments");
						ret_val = i + 1;
					} else if (parts.length == 1) {
						error.append("Error on line " + (i + 1) + ": this mnemonic is missing arguments");
						ret_val = i + 1;
					} else {
						int flags = 0;

						switch (parts[1].charAt(0)) {
						case '#':
							flags = 2;
							parts[1] = parts[1].substring(1);
							break;
						case '@':
							flags = 4;
							parts[1] = parts[1].substring(1);
							break;
						case '&':
							flags = 6;
							parts[1] = parts[1].substring(1);
							break;
						}

						try {
							int arg = Integer.parseInt(parts[1], 16);
							int op_part = 8 * InstructionMap.opcode.get(parts[0]) + flags;
							op_part += Instruction.numOnes(op_part) % 2;
							output_code.add(Integer.toString(op_part, 16) + " " + Integer.toString(arg, 16));
						} catch (NumberFormatException e) {
							error.append("Error on line " + (i + 1) + ": argument is not a hex number");
							ret_val = i + 1;
						}
					}
				}
			}

		if (ret_val == 0)
			try (PrintWriter outp = new PrintWriter(output)) {
				for (String str : output_code)
					outp.println(str);
				outp.close();
			} catch (FileNotFoundException e) {
				error.append("Error: Unable to write the assembled program to the output file");
				ret_val = -1;
			}

		return ret_val;
	}
}
