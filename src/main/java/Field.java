public class Field {
    private final Cell[][] cells;
    private final int l;
    private final int h;

    public Field(String input) {
        String[] lines = input.split("\n");
        h = lines.length;
        l = lines[0].length();
        cells = new Cell[h][l];
        initCells(lines);
        initCellsNeighbours();
    }

    private void initCellsNeighbours() {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < l; x++) {
                if (x != 0)
                    cells[y][x].addNeighbour(cells[y][x - 1]);
                if (x != l - 1)
                    cells[y][x].addNeighbour(cells[y][x + 1]);
                if (y != 0)
                    cells[y][x].addNeighbour(cells[y - 1][x]);
                if (y != h - 1)
                    cells[y][x].addNeighbour(cells[y + 1][x]);
            }
        }
    }

    private void initCells(String[] lines) {
        for (int y = 0; y < h; y++)
            for (int x = 0; x < l; x++)
                cells[y][x] = new Cell(lines[y].charAt(x));
    }

    public Field nextGen() {
        String input = "";
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < l; x++)
                input += cells[y][x].nextGen().toString();
            input += "\n";
        }
        return new Field(input.trim());
    }

    public String toString() {
        String str = "";
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < l; x++)
                str += cells[y][x].toString();
            str += "\n";
        }
        return str.trim();
    }
}
