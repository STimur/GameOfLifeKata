public class World {
    private Cell[][] cells;
    private final int h;
    private final int l;

    public World(String input) {
        String[] lines = input.split("\n");
        h = lines.length;
        l = lines[0].length();
        cells = new Cell[h][l];
        boolean isAlive = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (lines[i].charAt(j) == '*')
                    isAlive = true;
                else
                    isAlive = false;
                cells[i][j] = new Cell(isAlive);
            }
        }
        addNeighbours();
    }

    private void addNeighbours() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (j + 1 < l)
                    cells[i][j].addNeighbour(cells[i][j + 1]);
                if (j - 1 >= 0)
                    cells[i][j].addNeighbour(cells[i][j - 1]);
                if (i - 1 >= 0)
                    cells[i][j].addNeighbour(cells[i - 1][j]);
                if (i + 1 < h)
                    cells[i][j].addNeighbour(cells[i + 1][j]);
                if (i - 1 >= 0 && j - 1 >= 0)
                    cells[i][j].addNeighbour(cells[i - 1][j - 1]);
                if (i - 1 >= 0 && j + 1 < l)
                    cells[i][j].addNeighbour(cells[i - 1][j + 1]);
                if (i + 1 < h && j - 1 >= 0)
                    cells[i][j].addNeighbour(cells[i + 1][j - 1]);
                if (i + 1 < h && j + 1 < l)
                    cells[i][j].addNeighbour(cells[i + 1][j + 1]);
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (cells[i][j].alive)
                    str += "*";
                else
                    str += ".";
            }
            str += "\n";
        }
        return str.trim();
    }

    public World nextGeneration() {
        Cell[][] newCells = new Cell[h][l];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < l; j++)
                newCells[i][j] = cells[i][j].nextGeneration();
        cells = newCells;
        return this;
    }
}
