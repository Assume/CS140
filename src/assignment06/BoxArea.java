package assignment06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class BoxArea extends JComponent {

	private List<Box> list = new ArrayList<Box>();

	public List<Box> getList() {
		return list;
	}

	public void setList(List<Box> list) {
		this.list = list;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		int current_x_offset = 10;
		int current_y_offset = 10;

		for (Box box : list) {
			g2.setColor(box.getColor());
			Rectangle2D.Double r = box.getBox();
			r.setRect(current_x_offset, current_y_offset, r.getWidth(),
					r.getHeight());
			g2.fill(r);
			g2.setColor(Color.BLACK);
			g2.draw(r);
			current_x_offset += r.getWidth() + 5;
			current_y_offset += r.getHeight() + 5;
		}
	}

}
