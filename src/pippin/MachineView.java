package pippin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.Observable;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MachineView extends Observable {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MachineView(new MachineModel(true));
			}
		});
	}

	static final int TICK = 500;

	private MachineModel model;

	private String default_dir, data_dir, executable_dir;

	private Properties properties;

	private CodeViewPanel code_view_panel;

	private MemoryViewPanel memory_view_panel_1, memory_view_panel_2, memory_view_panel_3;

	private ControlPanel control_panel;

	private CPUViewPanel cpu_view_panel;

	private MenuBarBuilder menu_bar_builder;

	private JFrame frame;

	private Timer timer;
	private States state;

	private File current_program_file, current_data_file;

	private boolean running, program_loaded, no_data_needed, auto_step_on;

	public MachineView(MachineModel model) {
		this.model = model;
		locateDefaultDirectory();
		loadPropertiesFile();
		createAndShowGUI();
	}

	public void locateDefaultDirectory() {

	}

	public void loadPropertiesFile() {

	}

	public void createAndShowGUI() {
		frame = new JFrame("Pippin Simulator");
		code_view_panel = new CodeViewPanel(this);
		memory_view_panel_1 = new MemoryViewPanel(this, 0, 160);
		memory_view_panel_2 = new MemoryViewPanel(this, 160, 240);
		memory_view_panel_3 = new MemoryViewPanel(this, 240, Memory.DATA_SIZE);
		cpu_view_panel = new CPUViewPanel(this);
		frame.add(code_view_panel.createCodeDisplay(), BorderLayout.LINE_START);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 3));
		frame.add(center, BorderLayout.CENTER);
		center.add(memory_view_panel_1.createMemoryDisplay());
		center.add(memory_view_panel_2.createMemoryDisplay());
		center.add(memory_view_panel_3.createMemoryDisplay());
		frame.add(cpu_view_panel.createCPUDisplay(), BorderLayout.PAGE_START);
		frame.add(control_panel.createControlDisplay(), BorderLayout.PAGE_END);
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		bar.add(menu_bar_builder.createFileMenu());
		bar.add(menu_bar_builder.createExecuteMenu());
		frame.setSize(1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void clearAll() {
		model.clear();
		program_loaded = false;
		no_data_needed = false;
		state = States.NOTHING_LOADED;
		state.enter();
		setChanged();
		notifyObservers("Clear");
	}

	public void halt() {
		setRunning(false);
	}

	public boolean isAutoStepOn() {
		return auto_step_on;
	}

	public States getState() {
		return state;
	}

	public void setRunning(boolean what) {
		running = what;
		if (running)
			state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
		else {
			auto_step_on = false;
			state = States.PROGRAM_HALTED;
		}
		state.enter();
		setChanged();
		notifyObservers();
	}

	public void setPeriod(int period) {
		if (timer == null)
			return;
		timer.setDelay(period);
	}

	public int getData(int i) {
		return model.getData(i);
	}

	public int getAccum() {
		return model.getAccum();
	}

	public Code getCode() {
		return model.getCode();
	}

	public int getChangedIndex() {
		return model.getChangedIndex();
	}

	public int getPC() {
		return model.getPC();
	}

}
