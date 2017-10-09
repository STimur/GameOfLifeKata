public class World {
    private final Cell[][] cells;

    public World(String input) {
        cells = new Cell[1][1];
        boolean isAlive = true;
        cells[0][0] = new Cell(isAlive);
    }

    @Override
    public String toString() {
        if (cells[0][0].alive)
            return "*";
        else
            return ".";
    }
}
