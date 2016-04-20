package pippin;

public class Memory {

	public static final int DATA_SIZE = 512;

	private int[] data = new int[DATA_SIZE];

	protected int[] getJUnitData() {
		return data;
	}

	public int getData(int index) {
		return data[index];
	}

	public int[] getData(){
		return data;
	}
	
	public void setData(int index, int value) {
		data[index] = value;
	}

	public void clear() {
		data = new int[DATA_SIZE];
	}

}
