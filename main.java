import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        Cell[][] cellsArray = {
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false), new Cell(true),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false), new Cell(true),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false), new Cell(true), new Cell(true), new Cell(true),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
            {new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false),new Cell(false), new Cell(false),new Cell(false),new Cell(false), new Cell(false)},
        };
        Board gameBoard = new Board(cellsArray);
        timer.scheduleAtFixedRate(new TimerTask() { 
            @Override
            public void run() {
                gameBoard.updateStatus();
            }
        }, 0, 1000);
    }
}