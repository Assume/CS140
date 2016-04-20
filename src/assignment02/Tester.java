package assignment02;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Expected value 0");
		System.out.println(Utilities02.countNulls(null));
		Object[] test = {};
		System.out.println("Expected value 0");
		System.out.println(Utilities02.countNulls(test));
		System.out.println("Expected value -1");
		System.out.println(Utilities02.countSpaces(null));
		System.out.println("Expected value 0");
		System.out.println(Utilities02.countSpaces(""));
		System.out.println("Expected value 0");
		System.out.println(Utilities02.countSpaces("BLAHHHHHHHH"));
		System.out.println("Expected value 3");
		System.out.println(Utilities02
				.countSpaces("Blah HHHHHH DAHHHH HHHHHHH"));

		System.out.println("\nFIRST TEST\n");

		System.out.println("Expected value null");
		System.out.println(Utilities02.first(null));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.first(""));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.first("     "));
		System.out.println("Expected value blahhhh");
		System.out.println(Utilities02.first(" blahhhh "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.first("blah"));
		System.out.println("Expected value blah");
		System.out.println(Utilities02
				.first("        blah blah blah blah blah    "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.first("blah blah blah blah blah"));

		System.out.println("\nREST TEST\n");

		System.out.println("Expected value null");
		System.out.println(Utilities02.rest(null));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.rest(""));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.rest("     "));
		System.out.println("Expected value blahhhh");
		System.out.println(Utilities02.rest(" blahhhh "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.rest("blah"));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02
				.rest("        blah blah blah blah blah    "));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02.rest("blah blah blah blah blah"));

		System.out.println("\nwithoutExtraSpacesTest\n");

		System.out.println("Expected value null");
		System.out.println(Utilities02.withoutExtraSpaces(null));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.withoutExtraSpaces(""));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.withoutExtraSpaces("     "));
		System.out.println("Expected value blahhhh");
		System.out.println(Utilities02.withoutExtraSpaces(" blahhhh "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.withoutExtraSpaces("blah"));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02
				.withoutExtraSpaces("        blah  blah blah  blah blah    "));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02
				.withoutExtraSpaces("blah blah  blah  blah blah"));

		System.out.println("\nsplitOnSpacesTest\n");
		System.out.println("Expected value null");
		System.out.println(Utilities02.splitOnSpaces(null));
		System.out.println("Expected value empty array ie 0");
		System.out.println(Utilities02.splitOnSpaces("").length);
		System.out
				.println("Expected value \nblahhhh\nadhasdj\nasdjhasjdhjajd\nasdjhasjhdjash\nasdhasjkdjkasdj");
		for (String x : Utilities02
				.splitOnSpaces(" blahhhh adhasdj asdjhasjdhjajd asdjhasjhdjash asdhasjkdjkasdj"))
			System.out.println(x);

		System.out.println("\nsplitOnSpaces1Test1\n");
		System.out.println("Expected value null");
		System.out.println(Utilities02.splitOnSpaces1(null));
		System.out.println("Expected value empty array ie 0");
		System.out.println(Utilities02.splitOnSpaces1("").length);
		System.out
				.println("Expected value \nblahhhh\nadhasdj\nasdjhasjdhjajd\nasdjhasjhdjash\nasdhasjkdjkasdj");
		for (String x : Utilities02
				.splitOnSpaces1("blahhhh adhasdj asdjhasjdhjajd asdjhasjhdjash asdhasjkdjkasdj"))
			System.out.println(x);

		System.out.println("\nStringLengths Test\n");
		System.out.println("Expected value null");
		System.out.println(Utilities02.strLengths(null));
		System.out.println("Expected value empty array ie length == 0");
		System.out.println(Utilities02.strLengths("").length);
		System.out.println("Expected value \n7\n7\n14\n14\n15");
		for (int x : Utilities02
				.strLengths("blahhhh adhasdj asdjhasjdhjajd asdjhasjhdjash asdhasjkdjkasdj"))
			System.out.println(x);

		System.out.println("INSTANCE METHOD VERSION");
		InstanceMethodVersion Utilities02 = new InstanceMethodVersion(
				"hahaha see clever now need type less");
		System.out.println("Expected value -1");
		System.out.println(Utilities02.countSpaces(null));
		System.out.println("Expected value 0");
		System.out.println(Utilities02.countSpaces(""));
		System.out.println("Expected value 0");
		System.out.println(Utilities02.countSpaces("BLAHHHHHHHH"));
		System.out.println("Expected value 3");
		System.out.println(Utilities02
				.countSpaces("Blah HHHHHH DAHHHH HHHHHHH"));

		System.out.println("\nFIRST TEST\n");

		System.out.println("Expected value null");
		System.out.println(Utilities02.first(null));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.first(""));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.first("     "));
		System.out.println("Expected value blahhhh");
		System.out.println(Utilities02.first(" blahhhh "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.first("blah"));
		System.out.println("Expected value blah");
		System.out.println(Utilities02
				.first("        blah blah blah blah blah    "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.first("blah blah blah blah blah"));

		System.out.println("\nREST TEST\n");

		System.out.println("Expected value null");
		System.out.println(Utilities02.rest(null));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.rest(""));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.rest("     "));
		System.out.println("Expected value blahhhh");
		System.out.println(Utilities02.rest(" blahhhh "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.rest("blah"));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02
				.rest("        blah blah blah blah blah    "));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02.rest("blah blah blah blah blah"));

		System.out.println("\nwithoutExtraSpacesTest\n");

		System.out.println("Expected value null");
		System.out.println(Utilities02.withoutExtraSpaces(null));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.withoutExtraSpaces(""));
		System.out.println("Expected value empty string");
		System.out.println(Utilities02.withoutExtraSpaces("     "));
		System.out.println("Expected value blahhhh");
		System.out.println(Utilities02.withoutExtraSpaces(" blahhhh "));
		System.out.println("Expected value blah");
		System.out.println(Utilities02.withoutExtraSpaces("blah"));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02
				.withoutExtraSpaces("        blah  blah blah  blah blah    "));
		System.out.println("Expected value blah blah blah blah blah");
		System.out.println(Utilities02
				.withoutExtraSpaces("blah blah  blah  blah blah"));

		System.out.println("\nsplitOnSpacesTest\n");
		System.out.println("Expected value null");
		System.out.println(Utilities02.splitOnSpaces(null));
		System.out.println("Expected value empty array ie 0");
		System.out.println(Utilities02.splitOnSpaces("").length);
		System.out
				.println("Expected value \nblahhhh\nadhasdj\nasdjhasjdhjajd\nasdjhasjhdjash\nasdhasjkdjkasdj");
		for (String x : Utilities02
				.splitOnSpaces(" blahhhh adhasdj asdjhasjdhjajd asdjhasjhdjash asdhasjkdjkasdj"))
			System.out.println(x);

		System.out.println("\nStringLengths Test\n");
		System.out.println("Expected value null");
		System.out.println(Utilities02.strLengths(null));
		System.out.println("Expected value empty array ie length == 0");
		System.out.println(Utilities02.strLengths("").length);
		System.out.println("Expected value \n7\n7\n14\n14\n15");
		for (int x : Utilities02
				.strLengths("blahhhh adhasdj asdjhasjdhjajd asdjhasjhdjash asdhasjkdjkasdj"))
			System.out.println(x);

	}

}
