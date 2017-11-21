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
        if (!isAlive)
            return nextGenForDeadCell();
        return nextGenForAliveCell();
    }

    private Cell nextGenForAliveCell() {
        if (shouldDie())
            return new Cell('.');
        return new Cell('*');
    }

    private Cell nextGenForDeadCell() {
        if (shouldRevive())
            return new Cell('*');
        return new Cell('.');
    }

    private boolean shouldDie() {
        return isUnderPopulated() || isOverPopulated();
    }

    private boolean isOverPopulated() {
        return numOfAliveNeighbours > 3;
    }

    private boolean isUnderPopulated() {
        return numOfAliveNeighbours < 2;
    }

    private boolean shouldRevive() {
        return numOfAliveNeighbours == 3;
    }

    public void addNeighbour(Cell cell) {
        if (cell.isAlive)
            numOfAliveNeighbours++;
    }

    public String toString() {
        if (isAlive)
            return "*";
        return ".";
    }
}
