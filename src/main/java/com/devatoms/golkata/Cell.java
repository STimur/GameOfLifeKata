package com.devatoms.golkata;

public class Cell {
    public boolean isAlive = true;

    public Cell(char c) {

    }

    public void addNeighbour(Cell cell) {

    }

    public Cell nextGen() {
        return new Cell('*');
    }
}
