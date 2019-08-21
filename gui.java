import java.awt.*;
import java.awt.event.*;

public class Gui {
	Frame frame = new Frame();
	WindowListener closeWindow = new WindowListener(){
		@Override
		public void windowClosing(WindowEvent evt){
			System.exit(0);
		}

		@Override public void windowOpened(WindowEvent e) { }
		@Override public void windowIconified(WindowEvent e) { }
		@Override public void windowDeiconified(WindowEvent e) { }
		@Override public void windowDeactivated(WindowEvent e) { }
		@Override public void windowClosed(WindowEvent e) { }
		@Override public void windowActivated(WindowEvent e) { }
	}; 
	int gens = 0;
	Label generations = new Label("Generations: " + gens, Label.RIGHT);
	Label alive = new Label("Alive: 0", Label.RIGHT);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	public Gui(ActionListener[] l) throws IndexOutOfBoundsException {
		Panel pnl = new Panel(new GridLayout(2,4));
		Button play = new Button("Play");
		Button pause = new Button("Pause");
		Button clear = new Button("Clear");
		Button reset = new Button("Reset");
		Button choice = new Button("Choice");
		Button random = new Button("Random");
		ActionListener actionPlay = new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				play();
			}
		};
		ActionListener actionPause = new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
			}
		};
		ActionListener actionClear = new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		};
		ActionListener actionReset = new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		};
		ActionListener actionRandom = new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				random();
			}
		};
		play.addActionListener(actionPlay);
		pause.addActionListener(actionPause);
		clear.addActionListener(actionClear);
		reset.addActionListener(actionReset);
		random.addActionListener(actionRandom);
		play.addActionListener(l[0]);
		pause.addActionListener(l[1]);
		clear.addActionListener(l[2]);
		reset.addActionListener(l[3]);
		random.addActionListener(l[4]);
		pnl.add(play);
		pnl.add(pause);
		pnl.add(clear);
		pnl.add(generations);
		pnl.add(reset);
		pnl.add(random);
		pnl.add(new Label());
		pnl.add(alive);
		
		frame.setLayout(new BorderLayout());
		frame.add(pnl, BorderLayout.NORTH);
		frame.setTitle("Conway's Game of Life");
		frame.setSize((int)width, (int)height);
		frame.addWindowListener(closeWindow);
		frame.setVisible(true);
	}
	/**
	 * 
	 * @param i number of living cells
	 */
	public void updateLabels(int i) {
		gens++;
		generations.setText("Generations: " + gens);
		alive.setText("Alive: " + i);
	}

	public void resetLabels(){
		gens = 0;
		generations.setText("Generations: 0");
		alive.setText("Alive: 0");
	}

	private void play() {
		int i = 1;
	}
	private void pause(){
		int i = 1;
	}
	private void clear(){
		int i = 1;
	}
	private void reset(){
		int i = 1;
	}
	private void choice(){
		int i = 1;
	}
	private void random(){
		int i = 1;
	}
}