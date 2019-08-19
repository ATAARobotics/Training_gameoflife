public class Cell {
    private boolean isAlive;
    public Cell(boolean startValue) {
        isAlive = startValue;
    }
    public boolean getCellState() {
        return isAlive;
    }
    public void setCellState(boolean newState) {
        isAlive = newState;
    }
}