package pippin;

public class Memory {

	public static final int DATA_SIZE = 512;

	private int[] data = new int[DATA_SIZE];

	private int changed_index = -1;

	protected int[] getJUnitData() {
		return data;
	}

	public int getData(int index) {
		return data[index];
	}

	public int[] getData() {
		return data;
	}

	public void setData(int index, int value) {
		changed_index = index;
		data[index] = value;
	}

	public void clear() {
		changed_index = -1;
		data = new int[DATA_SIZE];
	}

	public int getChangedIndex() {
		return changed_index;
	}

}
