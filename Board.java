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
        boolean[][] statusArray = new boolean[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int x = 0; x < cells[i].length; x++) {
                statusArray[i][x] = cells[i][x].getCellState();
            }   
        }
        return statusArray;
    }

    private void setStatus(boolean[][] statusArray) {
        for (int i = 0; i < cells.length; i++) {
            for (int x = 0; x < cells[i].length; x++) {
                 cells[i][x].setCellState(statusArray[i][x]);
            }   
        }
    }
    private int[][] getNeighbors(int x, int y, int xLength, int yLength) {
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
            if(noWraparoundXY[i][0] > 0 && noWraparoundXY[i][0] < xLength) {
                neighborX = noWraparoundXY[i][0];
            }
    
            else if(noWraparoundXY[i][0] < 0) {
                neighborX = xLength;
            }
    
            else if(noWraparoundXY[i][0] > xLength) {
                neighborX = 0;
            }
    
            if(noWraparoundXY[i][1] > 0 && noWraparoundXY[i][1] < yLength) {
                neighborY = noWraparoundXY[i][1];
            }
            
            else if(noWraparoundXY[i][1] < 0) {
                neighborY = yLength;
            }
    
            else if(noWraparoundXY[i][1] > yLength) {
                neighborY = 0;
            }
            neighborsXY[i][0] = neighborX;
            neighborsXY[i][1] = neighborY;
        }
        return neighborsXY;
    }
    private boolean[][] evaluateStatus(boolean[][] input) {
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length; x++) {
                int aliveNeighbors = 0;
                int[][] neighborXY = getNeighbors(x, y, input[0].length, input.length);
                for (int[] coordinates : neighborXY) {
                    if(input[coordinates[0]][coordinates[1]]) {
                        aliveNeighbors++;
                    }
                }
                //Neighbor rules here
                if(aliveNeighbors == 3) {
                    input[x][y] = true;
                }

                else if(aliveNeighbors == 2 && cells[x][y].getCellState()) {
                    input[x][y] = true;
                }
                
                else {
                    input[x][y] = false;
                }
            }   
        }
        return input;
    }
    public void updateStatus() {
        boolean[][] statusArray = getStatus();
        setStatus(evaluateStatus(statusArray));
    }
}