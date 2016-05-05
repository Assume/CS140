package pippin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MemoryViewPanel implements Observer {

	private MachineView machine_view;

	private JScrollPane scroller;

	private JTextField[] data_decimal = new JTextField[Memory.DATA_SIZE];

	private JTextField[] data_hex = new JTextField[Memory.DATA_SIZE];

	private int lower, upper, previous_color = -1;

	public MemoryViewPanel(MachineView machine_view, int lower, int upper) {
		this.machine_view = machine_view;
		this.lower = lower;
		this.upper = upper;
		machine_view.addObserver(this);
	}

	public JComponent createMemoryDisplay() {
		JPanel returnPanel = new JPanel();
		returnPanel.setLayout(new BorderLayout());
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Data Memory View [" + lower + "-" + upper + "]", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		returnPanel.setBorder(border);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel numPanel = new JPanel();
		JPanel decimalPanel = new JPanel();
		JPanel hexPanel = new JPanel();
		numPanel.setLayout(new GridLayout(0, 1));
		decimalPanel.setLayout(new GridLayout(0, 1));
		hexPanel.setLayout(new GridLayout(0, 1));
		panel.add(numPanel, BorderLayout.LINE_START);
		panel.add(decimalPanel, BorderLayout.CENTER);
		panel.add(hexPanel, BorderLayout.LINE_END);
		for (int i = lower; i < upper; i++) {
			numPanel.add(new JLabel(i + ": ", JLabel.RIGHT));
			data_decimal[i] = new JTextField(10);
			data_hex[i] = new JTextField(10);
			decimalPanel.add(data_decimal[i]);
			hexPanel.add(data_hex[i]);
		}
		scroller = new JScrollPane(panel);
		returnPanel.add(scroller);
		return returnPanel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for (int i = lower; i < upper; i++) {
			data_decimal[i].setText("" + machine_view.getData(i));
			data_hex[i].setText(Integer.toHexString(machine_view.getData(i)));
		}
		if (arg1 != null && arg1.equals("Clear")) {
			for (int i = lower; i < upper; i++) {
				data_decimal[i].setText("");
				data_hex[i].setText("");
			}
			if (lower <= previous_color && previous_color < upper) {
				// was for debuggin System.out.println("\tagain" +
				// previous_color);
				data_decimal[previous_color].setBackground(Color.WHITE);
				data_hex[previous_color].setBackground(Color.WHITE);
				previous_color = -1;
			}
		} else {
			if (previous_color >= lower && previous_color < upper) {
				data_decimal[previous_color].setBackground(Color.WHITE);
				data_hex[previous_color].setBackground(Color.WHITE);
			}
			previous_color = machine_view.getChangedIndex();
			if (previous_color >= lower && previous_color < upper) {
				data_decimal[previous_color].setBackground(Color.YELLOW);
				data_hex[previous_color].setBackground(Color.YELLOW);
			}
		}
		if (scroller != null && machine_view != null) {
			JScrollBar bar = scroller.getVerticalScrollBar();
			if (machine_view.getChangedIndex() >= lower && machine_view.getChangedIndex() < upper
					&& data_decimal[machine_view.getChangedIndex()] != null) {
				Rectangle bounds = data_decimal[machine_view.getChangedIndex()].getBounds();
				bar.setValue(Math.max(0, bounds.y - 15 * bounds.height));
			}
		}
	}

}
