package assignment06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class RotateListener implements ActionListener {

	private Graphic graphic;

	public RotateListener(Graphic graphic) {
		this.graphic = graphic;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Box x : graphic.getList()) {
			Rectangle2D.Double r = x.getBox();
			r.setRect(0, 0, r.getHeight(), r.getWidth());
		}
		graphic.callRepaint();
	}
}
