package pippin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

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

	private String default_dir, data_dir, executable_dir, source_dir;

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

	private void locateDefaultDirectory() {
		// CODE TO DISCOVER THE ECLIPSE DEFAULT DIRECTORY:
		File temp = new File("propertyfile.txt");
		if (!temp.exists()) {
			PrintWriter out;
			try {
				out = new PrintWriter(temp);
				out.close();
				default_dir = temp.getAbsolutePath();
				temp.delete();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			default_dir = temp.getAbsolutePath();
		}
		// change to forward slashes
		default_dir = default_dir.replace('\\', '/');
		int lastSlash = default_dir.lastIndexOf('/');
		default_dir = default_dir.substring(0, lastSlash + 1);
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

	public void step() {
		if (model.isRunning()) {
			try {
				model.step();
			} catch (CodeAccessException e) {
				halt();
				JOptionPane.showMessageDialog(frame,
						"Illegal access to code from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
						"Run time error", JOptionPane.OK_OPTION);
			} catch (ArrayIndexOutOfBoundsException e) {
				halt();
				JOptionPane.showMessageDialog(frame,
						"Illegal access to data from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
						"Run time error", JOptionPane.OK_OPTION);
			} catch (NullPointerException e) {
				halt();
				JOptionPane.showMessageDialog(frame, "Illegal access to null data from line " + getPC() + "\n"
						+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			} catch (IllegalInstructionException e) {
				halt();
				JOptionPane.showMessageDialog(frame,
						"Illegal flags from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
						"Run time error", JOptionPane.OK_OPTION);
			} catch (DivideByZeroException e) {
				halt();
				JOptionPane.showMessageDialog(frame,
						"Divide By Zero from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
						"Run time error", JOptionPane.OK_OPTION);
			} catch (ParityCheckException e) {
				halt();
				JOptionPane.showMessageDialog(frame,
						"Parity exception from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
						"Run time error", JOptionPane.OK_OPTION);
			}
			setChanged();
			notifyObservers();
		} else
			halt();
	}

	public void execute() {
		while (running) {
			if (model.isRunning()) {
				try {
					model.step();
				} catch (CodeAccessException e) {
					halt();
					JOptionPane.showMessageDialog(frame, "Illegal access to code from line " + getPC() + "\n"
							+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
				} catch (ArrayIndexOutOfBoundsException e) {
					halt();
					JOptionPane.showMessageDialog(frame, "Illegal access to data from line " + getPC() + "\n"
							+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
				} catch (NullPointerException e) {
					halt();
					JOptionPane.showMessageDialog(frame, "Illegal access to null data from line " + getPC() + "\n"
							+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
				} catch (IllegalInstructionException e) {
					halt();
					JOptionPane.showMessageDialog(frame,
							"Illegal flags from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
							"Run time error", JOptionPane.OK_OPTION);
				} catch (DivideByZeroException e) {
					halt();
					JOptionPane.showMessageDialog(frame,
							"Divide By Zero from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
							"Run time error", JOptionPane.OK_OPTION);
				} catch (ParityCheckException e) {
					halt();
					JOptionPane.showMessageDialog(frame,
							"Parity exception from line " + getPC() + "\n" + "Exception message: " + e.getMessage(),
							"Run time error", JOptionPane.OK_OPTION);
				}

			} else
				halt();
			setChanged();
			notifyObservers();
		}
	}

	public void toggleAutoStep() {
		setAutoStepOn(!auto_step_on);
	}

	public void setAutoStepOn(boolean what) {
		auto_step_on = what;
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

	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(frame, "Do you really wish to exit?", "Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void loadFile() {
		JFileChooser chooser = new JFileChooser(executable_dir);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Pippin Executable Files", "pexe");
		chooser.setFileFilter(filter);
		// CODE TO LOAD DESIRED FILE
		int openOK = chooser.showOpenDialog(null);
		if(openOK == JFileChooser.APPROVE_OPTION) {
			current_program_file = chooser.getSelectedFile();
		}
		if(current_program_file != null && current_program_file.exists()) {
			// CODE TO REMEMBER WHICH DIRECTORY HAS THE pexe FILES
			executable_dir = current_program_file .getAbsolutePath();
			executable_dir = executable_dir.replace('\\','/');
			int lastSlash = executable_dir.lastIndexOf('/');
			executable_dir = executable_dir.substring(0, lastSlash + 1);
			try { 
				properties.setProperty("SourceDirectory", source_dir);
				properties.setProperty("ExecutableDirectory", executable_dir);
				properties.setProperty("DataDirectory", data_dir);
				properties.store(new FileOutputStream("propertyfile.txt"), 
						"File locations");
			} catch (Exception e) {
				System.out.println("Error writing properties file");
			}			
			program_loaded = true;
			int needData = JOptionPane.showConfirmDialog(
					frame, 
					"Data may be needed before the program can execute\n"
							+ "Do you need to load data?",
							"Program Load",
							JOptionPane.YES_NO_OPTION);
			if(needData == JOptionPane.NO_OPTION) {
				no_data_needed = true;
				finalLoad_ReloadStep();			
			} else {
				loadData();
			}
		}
	}

	public void loadData() {
		if(!program_loaded) {
			JOptionPane.showMessageDialog(
					frame, 
					"No program loaded. Please load a program",
					"Error",
					JOptionPane.OK_OPTION);
			return;
		}
		JFileChooser chooser = new JFileChooser(data_dir);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Pippin Data Files", "dat");
		chooser.setFileFilter(filter);
		// CODE TO LOAD DESIRED FILE
		int openOK = chooser.showOpenDialog(null);
		if(openOK == JFileChooser.APPROVE_OPTION) {
			current_data_file = chooser.getSelectedFile();
		}
		if(current_data_file != null && current_data_file.exists()) {
			// CODE TO REMEMBER WHICH DIRECTORY HAS THE dat FILES
			data_dir = current_data_file .getAbsolutePath();
			data_dir = data_dir.replace('\\','/');
			int lastSlash = data_dir.lastIndexOf('/');
			data_dir = data_dir.substring(0, lastSlash + 1);
			try { 
				properties.setProperty("SourceDirectory", source_dir);
				properties.setProperty("ExecutableDirectory", executable_dir);
				properties.setProperty("DataDirectory", data_dir);
				properties.store(new FileOutputStream("propertyfile.txt"), 
						"File locations");
			} catch (Exception e) {
				System.out.println("Error writing properties file");
			}			
			finalLoad_ReloadStep();
		} 
	}		

	private void finalLoad_ReloadStep() {
		clearAll();
		String str = "";
		if(no_data_needed)
			str = Loader.load(model, current_program_file);
		else
			str = Loader.load(model, current_program_file, current_data_file);
		if(str.equals("success")) {
			model.setRunning(true);
			setRunning(true);
			setAutoStepOn(false);
			setChanged();
			notifyObservers("Load Code");
		}
		else {
			JOptionPane.showMessageDialog(
					frame, 
					"The file being selected has problems.\n" +
							str + "\n" +
							"Cannot load the program",
							"Warning",
							JOptionPane.OK_OPTION);
		}
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
