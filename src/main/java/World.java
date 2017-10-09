public class World {
    private final Cell[][] cells;
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
}
