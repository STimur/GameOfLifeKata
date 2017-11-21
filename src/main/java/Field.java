public class Field {
    private final Cell[][] cells;
    private final int w;
    private final int h;

    public Field(String input) {
        String[] lines = input.split("\n");
        h = lines.length;
        w = lines[0].length();
        cells = new Cell[h][w];
        initCells(lines);
        initCellsNeighbours();
    }

    public Field nextGen() {
        Cell[][] nextGenCells = new Cell[h][w];
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                nextGenCells[y][x] = cells[y][x].nextGen();
        return new Field(cellsToString(nextGenCells));
    }

    public String toString() {
        return cellsToString(cells);
    }

    private void initCellsNeighbours() {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (x != 0)
                    cells[y][x].addNeighbour(cells[y][x - 1]);
                if (x != w - 1)
                    cells[y][x].addNeighbour(cells[y][x + 1]);
                if (y != 0)
                    cells[y][x].addNeighbour(cells[y - 1][x]);
                if (y != h - 1)
                    cells[y][x].addNeighbour(cells[y + 1][x]);
                if (x != 0 && y != 0)
                    cells[y][x].addNeighbour(cells[y - 1][x - 1]);
                if (x != w - 1 && y != 0)
                    cells[y][x].addNeighbour(cells[y - 1][x + 1]);
                if (x != w - 1 && y != h - 1)
                    cells[y][x].addNeighbour(cells[y + 1][x + 1]);
                if (x != 0 && y != h - 1)
                    cells[y][x].addNeighbour(cells[y + 1][x - 1]);
            }
        }
    }

    private void initCells(String[] lines) {
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                cells[y][x] = new Cell(lines[y].charAt(x));
    }

    private String cellsToString(Cell[][] cells) {
        String str = "";
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++)
                str += cells[y][x].toString();
            str += "\n";
        }
        return str.trim();
    }
}
