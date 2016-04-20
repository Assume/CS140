package assignment02;

public class Utilities02 {

	public static int countNulls(Object[] array) {
		if (array == null || array.length == 0)
			return 0;
		int total = 0;
		for (Object item : array)
			if (item == null)
				total++;

		return total;
	}

	public static int countSpaces(String str) {
		if (str == null)
			return -1;
		int count = 0;
		for (char c : str.toCharArray())
			if (c == ' ')
				count++;
		return count;
	}

	public static String first(String str) {
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || countSpaces(str) == len)
			return "";
		int space_index = str.indexOf(' ');
		if (space_index >= 0)
			return str.substring(0, space_index);
		return str;
	}

	public static String rest(String str) {
		return str == null ? null : str.substring(str.indexOf(' ') + 1).trim();
	}

	public static String withoutExtraSpaces(String str) {
		if(str == null)
			return null;
		str = str.trim();
		return str.replaceAll("  ", " ");
	}

	public static String[] splitOnSpaces(String str) {
		if (str == null)
			return null;
		if (!str.contains(" "))
			return new String[0];
		return str.trim().split(" ");
	}

	public static int[] strLengths(String str) {
		if(str == null)
			return null;
		String[] split = splitOnSpaces(str);
		if(split.length == 0)
			return new int[0];
		int[] lengths = new int[split.length];
		for (int i = 0; i < lengths.length; i++)
			lengths[i] = split[i].length();
		return lengths;
	}

	public static String[] splitOnSpaces1(String str) {
		if (str == null)
			return null;
		if (!str.contains(" "))
			return new String[0];
		return str.trim().split(" ");
	}

}
