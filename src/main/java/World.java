public class World {
    private final Cell[][] cells;
    private final int h = 1;
    private final int l;

    public World(String input) {
        l = input.length();
        cells = new Cell[1][l];
        boolean isAlive = false;
        for (int i = 0; i < l; i++) {
            if (input.charAt(i) == '*')
                isAlive = true;
            else
                isAlive = false;
            cells[0][i] = new Cell(isAlive);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < h; i++)
            for (int j = 0; j < l; j++)
                if (cells[i][j].alive)
                    str += "*";
                else
                    str += ".";
        return str;
    }
}
