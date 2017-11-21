public class Cell {
    public Cell(char c) {
    }

    public Cell nextGen() {
        return new Cell('.');
    }

    public boolean isAlive() {
        return false;
    }
}
