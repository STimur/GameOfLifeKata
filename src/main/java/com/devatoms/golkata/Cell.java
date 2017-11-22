package com.devatoms.golkata;

public class Cell {
    public boolean isAlive;
    private int numOfAliveNeighbours;

    public Cell(char c) {
        if (c == '*')
            isAlive = true;
    }

    public void addNeighbour(Cell cell) {
        if (cell.isAlive)
            numOfAliveNeighbours++;
    }

    public Cell nextGen() {
        if (isAlive && numOfAliveNeighbours == 2)
            return new Cell('*');
        if (numOfAliveNeighbours == 3)
            return new Cell('*');
        return new Cell('.');
    }
}
