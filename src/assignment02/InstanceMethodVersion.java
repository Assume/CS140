package assignment02;

public class InstanceMethodVersion {

	private String string;
	
	public InstanceMethodVersion(String str) {
		this.string = str;
	} 
	

	public  int countSpaces(String str) {
		if (str == null)
			return -1;
		int count = 0;
		for (char c : str.toCharArray())
			if (c == ' ')
				count++;
		return count;
	}

	public  String first(String str) {
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

	public  String rest(String str) {
		return str == null ? null : str.substring(str.indexOf(' ') + 1).trim();
	}

	public  String withoutExtraSpaces(String str) {
		if(str == null)
			return null;
		str = str.trim();
		return str.replaceAll("  ", " ");
	}

	public  String[] splitOnSpaces(String str) {
		if (str == null)
			return null;
		if (!str.contains(" "))
			return new String[0];
		return str.trim().split(" ");
	}

	public  int[] strLengths(String str) {
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


	
	
}
