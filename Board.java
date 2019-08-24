import java.awt.*;

class Board extends Canvas {

    private int height;
    private int width;
    private Cell[][] cells;
    private int alive = 0;
    int rectWidth = 9;
    int rectHeight = 9;

    public Board(int h, int w) {
        height = h;
        width = w;
        cells = new Cell[h][w];
        for (int i = 0; i < h; i++) {
            for (int x = 0; x < w; x++) {
                cells[i][x] = new Cell(false);
            }
        }
        setBackground(Color.white);
        setBounds(0, 0, w*rectWidth, h*rectHeight);
    }

    public Board(Cell[][] c) {
        height = c.length;
        width = c[0].length;
        cells = c;
    }

    public boolean[][] getStatus() {
        boolean[][] statusArray = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                statusArray[y][x] = cells[y][x].getCellState();
            }   
        }
        return statusArray;
    }

    public void setStatus(boolean[][] statusArray) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x].setCellState(statusArray[y][x]);
            }   
        }
    }
    private int[][] getNeighbors(int x, int y, int xBound, int yBound) {
        int[][] neighborsXY = new int[8][2];
        int[][] noWraparoundXY = {
            {x-1, y-1},
            {x, y-1}, 
            {x+1, y-1},
            {x-1, y},
            {x+1, y},
            {x-1, y+1},
            {x, y+1}, 
            {x+1, y+1},
        };
        for (int i = 0; i < 8; i++) {
            int neighborX = 0;
            int neighborY = 0;
            if(noWraparoundXY[i][0] > 0 && noWraparoundXY[i][0] < xBound) {
                neighborX = noWraparoundXY[i][0];
            }
    
            else if(noWraparoundXY[i][0] < 0) {
                neighborX = xBound;
            }
    
            else if(noWraparoundXY[i][0] > xBound) {
                neighborX = 0;
            }
    
            if(noWraparoundXY[i][1] > 0 && noWraparoundXY[i][1] < yBound) {
                neighborY = noWraparoundXY[i][1];
            }
            
            else if(noWraparoundXY[i][1] < 0) {
                neighborY = yBound;
                
            }
    
            else if(noWraparoundXY[i][1] > yBound) {
                neighborY = 0;
            }
            neighborsXY[i][0] = neighborX;
            neighborsXY[i][1] = neighborY;
        }
        return neighborsXY;
    }
    private boolean[][] evaluateStatus(boolean[][] input) {
        alive = 0;
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[0].length; x++) {
                int aliveNeighbors = 0;
                int[][] neighborXY = getNeighbors(x, y, width-1, height-1);
                for (int[] coordinates : neighborXY) {
                    if(cells[coordinates[1]][coordinates[0]].getCellState()) {
                        aliveNeighbors++;
                    }
                }

                if(aliveNeighbors == 3) {
                    input[y][x] = true;
                    alive++;
                }

                else if(aliveNeighbors == 2 && cells[y][x].getCellState()) {
                    input[y][x] = true;
                    alive++;
                }
                
                else {
                    input[y][x] = false;
                }
            }  
        }
        return input;
    }

    public int updateStatus() {
        boolean[][] statusArray = getStatus();
        String arrayString = "";
        for (boolean[] row : statusArray) {
            for (boolean item : row) {
                arrayString += item + " ";
            }
            arrayString += "\n";
        }
        setStatus(evaluateStatus(statusArray));
        return alive;
    }
    public void clear(){
        boolean[][] statusArray = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                statusArray[y][x] = false;
            }   
        }
        setStatus(statusArray);
    }

    @Override
	public void paint(Graphics g){
        boolean[][] boardState = getStatus();
		g.setColor(Color.BLACK);
		for (int x = 0; x < boardState.length;x++){
			for (int y = 0; y < boardState[0].length;y++){
				if (boardState[x][y]){
					g.fillRect(x*rectWidth, y*rectHeight, rectWidth, rectHeight);
				}
			}
		}
	}
}