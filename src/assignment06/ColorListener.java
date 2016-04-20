package assignment06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ColorListener implements ActionListener {

	private Graphic graphic;

	public ColorListener(Graphic graphic) {
		this.graphic = graphic;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Color newColor = JColorChooser.showDialog(graphic.getFrame(),
				"Select New Color", Color.GREEN);
		for (Box x : graphic.getList())
			x.setColor(newColor);
		graphic.callRepaint();
	}

}
