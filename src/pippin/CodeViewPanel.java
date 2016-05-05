package pippin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class CodeViewPanel implements Observer {

	private MachineView machine_view;
	private Code code;
	private JScrollPane scroller;
	private JTextField[] code_text = new JTextField[Code.CODE_MAX];
	private int previous_color = -1;

	public CodeViewPanel(MachineView machine_view){
		this.machine_view = machine_view;
		this.machine_view.addObserver(this);
	}
	
	public JComponent createCodeDisplay() {
		JPanel returnPanel = new JPanel();
		JPanel panel = new JPanel();
		JPanel numPanel = new JPanel();
		JPanel sourcePanel = new JPanel();
		returnPanel.setPreferredSize(new Dimension(300,150));;
		returnPanel.setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		numPanel.setLayout(new GridLayout(0,1));
		sourcePanel.setLayout(new GridLayout(0,1));
		for(int i = 0; i < Code.CODE_MAX; i++) {
			numPanel.add(new JLabel(i+": ", JLabel.RIGHT));
			code_text[i] = new JTextField(10);
			sourcePanel.add(code_text[i]);
		}
		Border border = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Code Memory View",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		returnPanel.setBorder(border);

		panel.add(numPanel, BorderLayout.LINE_START);
		panel.add(sourcePanel, BorderLayout.CENTER);
		scroller = new JScrollPane(panel);
		returnPanel.add(scroller);
		return returnPanel;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 != null && arg1.equals("Load Code")) {
			for(int i = 0; i < Code.CODE_MAX; i++) {
				code_text[i].setText(code.getText(i));
			}	
			previous_color = machine_view.getPC();			
			code_text[previous_color].setBackground(Color.YELLOW);
		}	
		if(arg1 != null && arg1.equals("Clear")) {
			for(int i = 0; i < Code.CODE_MAX; i++) {
				code_text[i].setText("");
			}	
			if(previous_color >= 0 && previous_color < Code.CODE_MAX) {
				code_text[previous_color].setBackground(Color.WHITE);
			}
			previous_color = -1;
		}		
		if(this.previous_color >= 0 && previous_color < Code.CODE_MAX) {
			code_text[previous_color].setBackground(Color.WHITE);
			previous_color = machine_view.getPC();
			if(this.previous_color >= 0 && previous_color < Code.CODE_MAX) {
				code_text[previous_color].setBackground(Color.YELLOW);
			}
		} 

		if(scroller != null && code != null && machine_view!= null) {
			JScrollBar bar= scroller.getVerticalScrollBar();
			int pc = machine_view.getPC();
			if(pc < Code.CODE_MAX && code_text[pc] != null) {
				Rectangle bounds = code_text[pc].getBounds();
				bar.setValue(Math.max(0, bounds.y - 15*bounds.height));
			}
		}
	}
	
	
}
