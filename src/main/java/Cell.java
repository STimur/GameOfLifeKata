public class Cell {
    public final boolean isAlive;
    private int numOfAliveNeighbours;

    public Cell(char c) {
        if (c == '.')
            isAlive = false;
        else
            isAlive = true;
    }

    public Cell nextGen() {
        if (numOfAliveNeighbours == 3)
            return new Cell('*');
        return new Cell('.');
    }

    public void addNeighbour(Cell cell) {
        if (cell.isAlive)
            numOfAliveNeighbours++;
    }
}
