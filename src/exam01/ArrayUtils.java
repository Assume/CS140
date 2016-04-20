package exam01;


public class ArrayUtils {

	public static void main(String[] args) {
		int[] x = ArrayUtils.drop(new int[] { 1 }, 0);
	}

	public static int alternateOddSum(int[] array) {
		if (array.length < 2)
			return 0;
		int sum = 0;

		for (int i = 1; i < array.length; i += 2)
			if (array[i] % 2 == 1)
				sum += array[i];
		return sum;
	}

	public static int[] reverse(int[] array) {
		int[] reversed = new int[array.length];
		for (int i = 0; i < array.length; i++)
			reversed[array.length - 1 - i] = array[i];
		return reversed;
	}

	public static int[] drop(int[] array, int n) {
		if (n > array.length)
			return new int[0];

		int[] new_array = new int[array.length - n];

		for (int i = 0; i < new_array.length; i++) {
			new_array[i] = array[array.length - (n - 1) + i];
		}
		return new_array;

	}

}