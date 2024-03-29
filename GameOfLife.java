import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.*;

public class GameOfLife {
    private Timer timer;
    private Gui gui;
	private Board gameBoard;
	private boolean[][] savedStatus;
	
    public static void main(String[] args) {
		new GameOfLife();
	}
	
	public GameOfLife (){
		gameBoard = new Board(100, 100);
	
		ActionListener actionPlay = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
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
		ActionListener step = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				step();
			}
		};
		ActionListener[] l = { actionPlay, actionPause, actionClear, actionReset, actionRandom, step };
		gui = new Gui(l, gameBoard);
		random();
		start();
	}

    private void start(){
        if (timer == null){
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() { 
                @Override
                public void run() {
					int i = gameBoard.updateStatus();
					gui.updateLabels(i);
					gameBoard.repaint();
					timer.cancel();
					timer.purge();
					timer = null;
					start();
                }
			}, 10*gui.getSpeedSlider(), 1);
        }
		if (savedStatus == null){
			savedStatus = gameBoard.getStatus();
		}
	}

    private void pause(){
		if (timer != null){
			timer.cancel();
			timer.purge();
			timer = null;
		}
	}
	
	private void clear(){
		gameBoard.clear();
		pause();
		gui.resetLabels();
		savedStatus = null;
		gameBoard.repaint();
	}

	private void reset(){
		gui.resetLabels();
		pause();
		gameBoard.setStatus(savedStatus);
		gameBoard.repaint();
	}

	private void step(){
		int i = gameBoard.updateStatus();
		gui.updateLabels(i);
		gameBoard.repaint();
	}

	private void random(){
		gui.resetLabels();
		boolean[][] b = gameBoard.getStatus();
		int l = b.length;
		int h = b[0].length;
		boolean[][] newBoard = new boolean[l][h];
		for (int x = 0; x < l; x++){
			for (int y = 0; y < h; y++){
				boolean newState;
				if (Math.random() < 0.4){
					newState = false;
				}
				else {
					newState = true;
				}
				newBoard[x][y] = newState;
			}
		}
		gameBoard.setStatus(newBoard);
		savedStatus = null;
		gameBoard.repaint();
	}
}