package assignment06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Driver1 {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Random rand = new Random();
				List<Box> list = new ArrayList<Box>();
				for (int i = 0; i < 5; i++)
					list.add(new Box(rand.nextInt(10) * 10, rand.nextInt(10)* 10));

				Graphic g = new Graphic("Lander");
				g.setList(list);
			}
		});
	}

}
