class Board {

    private int height;
    private int width;
    private Cell[][] cells;

    public Board(int h, int w) {
        height = h;
        width = w;
        for (int i = 0; i < h; i++) {
            for (int x = 0; x < w; i++) {
                cells[i][x] = new Cell(false);
            }
        }
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

    private void setStatus(boolean[][] statusArray) {
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
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[0].length; x++) {
                int aliveNeighbors = 0;
                int[][] neighborXY = getNeighbors(x, y, height-1, width-1);
                for (int[] coordinates : neighborXY) {
                    if(cells[coordinates[1]][coordinates[0]].getCellState()) {
                        aliveNeighbors++;
                    }
                }

                if(aliveNeighbors == 3) {
                    input[y][x] = true;
                }

                else if(aliveNeighbors == 2 && cells[y][x].getCellState()) {
                    input[y][x] = true;
                }
                
                else {
                    input[y][x] = false;
                }
            }  
        }
        return input;
    }

    public void updateStatus() {
        boolean[][] statusArray = getStatus();
        String arrayString = "";
        for (boolean[] row : statusArray) {
            for (boolean item : row) {
                arrayString += item + " ";
            }
            arrayString += "\n";
        }
        System.out.println(arrayString);
        setStatus(evaluateStatus(statusArray));
    }
}