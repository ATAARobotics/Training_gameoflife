package gui

import java.awt.*
import javax.swing.JFrame;

public class Gui extends JFrame {
	public void MakeGui() {
		Panel pnl = new Panel();
		Button play = new Button("Play");
		Button pause = new Button("Pause");
		Button clear = new Button("Clear");
		Button reset = new Button("Reset");
		Button choice = new Button("Choice");
		Button random = new Button("Random");
		pnl.add(play);
		pnl.add(pause);
		pnl.add(clear);
		pnl.add(reset);
		pnl.add(choice);
		pnl.add(random);
	}
	
	public static void main(String[] args) {
		MakeGui();
	}
}