package pippin;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CPUViewPanel implements Observer {

	private MachineView machine_view;
	private JTextField acc = new JTextField();
	private JTextField pc = new JTextField();

	public CPUViewPanel(MachineView machine_view) {
		this.machine_view = machine_view;
		this.machine_view.addObserver(this);
	}

	public JComponent createCPUDisplay() {
		JPanel returnPanel = new JPanel();
		returnPanel.setLayout(new GridLayout(1, 0));
		returnPanel.add(new JLabel("Accumulator: ", JLabel.RIGHT));
		returnPanel.add(acc);
		returnPanel.add(new JLabel("Program Counter: ", JLabel.RIGHT));
		returnPanel.add(pc);
		return returnPanel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (machine_view != null) {
			acc.setText("" + machine_view.getAccum());
			pc.setText("" + machine_view.getPC());
		}
	}

}
