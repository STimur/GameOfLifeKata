import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final boolean alive;
    private List<Cell> neighbours = new ArrayList<>();
    private int numOfAliveNeighbours = 0;

    public Cell(boolean isAlive) {
        this.alive = isAlive;
    }

    public Cell nextGeneration() {
        if (numOfAliveNeighbours == 2 || numOfAliveNeighbours == 3)
            return new Cell(true);
        return new Cell(false);
    }

    public boolean isAlive() {
        return alive;
    }

    public void addNeighbour(Cell cell) {
        if (cell.isAlive())
            numOfAliveNeighbours++;
        neighbours.add(cell);
    }
}
