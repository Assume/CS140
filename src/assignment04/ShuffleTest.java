package assignment04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShuffleTest {

	public static void main(String[] args) {
		try (Scanner kbd = new Scanner(System.in);
				PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)))) {
			int count = 15;
			System.out.println("How many elements should the test have? (default is 15)");
			String str = kbd.nextLine();
			Scanner scan = new Scanner(str);
			if (scan.hasNextInt()) {
				count = scan.nextInt();
			}
			scan.close();
			output.println("Number of elements = " + count);
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < count; i++)
				list.add(i);
			int[][] d_array = new int[count][count];
			int length = 100;
			for (int x = 0; x < length; x++) {
				Collections.shuffle(list);
				System.out.println(list.toString());
				for (int i = 0; i < count; i++) {
					for (int j = 0; j < count; j++) {
						if (list.get(j) == i)
							d_array[i][j]++;
					}
				}
			}

			double mean = length / count;
			System.out.println(mean);
			output.println("Mean = " + mean);

			double total_for_sdev = 0.0;
			for (int i = 0; i < count; i++)
				for (int j = 0; j < count; j++)
					total_for_sdev += (d_array[i][j] - mean) * (d_array[i][j] - mean);


			total_for_sdev *= (1.0 / (count - 1.0));
			total_for_sdev = Math.sqrt(total_for_sdev);
			System.out.println(total_for_sdev);
			output.println("Standard Deviation = " + total_for_sdev);

	total_for_sdev *= (1.0 / (count - 1.0));
			total_for_sdev = Math.sqrt(total_for_sdev);
			System.out.println(total_for_sdev);
			output.println("Standard Deviation = " + total_for_sdev);	

			double sDev = 0.0;
			System.out.println(sDev);
			output.println("Standard Deviation = " + sDev);

		} catch (IOException e) {
			System.out.println("IO exception");
		}
	}
}
