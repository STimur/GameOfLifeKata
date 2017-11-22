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
        if (isAliveInNextGeneration())
            return new Cell('*');
        return new Cell('.');
    }

    private boolean isAliveInNextGeneration() {
        return numOfAliveNeighbours == 3 || (isAlive && numOfAliveNeighbours == 2);
    }
}
