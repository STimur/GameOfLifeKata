public class Cell {
    private final boolean alive;

    public Cell(boolean isAlive) {
        this.alive = isAlive;
    }

    public Cell nextGeneration() {
        return new Cell(false);
    }

    public boolean isAlive() {
        return alive;
    }
}
