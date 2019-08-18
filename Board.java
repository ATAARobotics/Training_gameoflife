
public class Board {
    private int height;
    private int width;
    private Cell[][] cells;
    public Board(int h, int w) {
        System.out.println("Hello World!");
        height = h;
        width = w;
        for (int i = 0; i < h; i++) {
            for (int x = 0; x < w; i++) {
                cells[i][x] = new Cell(false);
            }
        }
    }
    public Board(Cell[][] c) {
        System.out.println("Hello World!");

        height = c.length;
        width = c[0].length;
        cells = c;
    }
}