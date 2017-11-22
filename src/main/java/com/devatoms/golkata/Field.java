package com.devatoms.golkata;

public class Field {
    private final Cell[][] cells;
    private final int l;
    private final int h;

    public Field(String input) {
        String[] lines = input.split("\n");
        h = lines.length;
        l = lines[0].length();
        cells = new Cell[h][l];
        for (int y = 0; y < h; y++)
            for (int x = 0; x < l; x++)
                cells[y][x] = new Cell(lines[y].charAt(x));
        addCellNeighbours();
    }

    public Field nextGen() {
        Cell[][] nextGenerationCells = new Cell[h][l];
        for (int y = 0; y < h; y++)
            for (int x = 0; x < l; x++)
                nextGenerationCells[y][x] = cells[y][x].nextGen();
        return new Field(cellsToString(nextGenerationCells));
    }

    public String toString() {
        return cellsToString(cells);
    }

    private void addCellNeighbours() {
        for (int y = 0; y < h; y++)
            for (int x = 0; x < l; x++)
                addNeighboursForCell(y, x);
    }

    private void addNeighboursForCell(int y, int x) {
        addWestNeighbourForCell(y, x);
        addNorthWestNeighbourForCell(y, x);
        addNorthNeighbourForCell(y, x);
        addNorthEastNeighbourForCell(y, x);
        addEastNeighbourForCell(y, x);
        addSouthEastNeighbourForCell(y, x);
        addSouthNeighbourForCell(y, x);
        addSouthWestNeighbourForCell(y, x);
    }

    private void addSouthWestNeighbourForCell(int y, int x) {
        if (y != h - 1 && x != 0)
            cells[y][x].addNeighbour(cells[y + 1][x - 1]);
    }

    private void addSouthEastNeighbourForCell(int y, int x) {
        if (y != h - 1 && x != l - 1)
            cells[y][x].addNeighbour(cells[y + 1][x + 1]);
    }

    private void addNorthEastNeighbourForCell(int y, int x) {
        if (y != 0 && x != l - 1)
            cells[y][x].addNeighbour(cells[y - 1][x + 1]);
    }

    private void addNorthWestNeighbourForCell(int y, int x) {
        if (y != 0 && x != 0)
            cells[y][x].addNeighbour(cells[y - 1][x - 1]);
    }

    private void addSouthNeighbourForCell(int y, int x) {
        if (y != h - 1)
            cells[y][x].addNeighbour(cells[y + 1][x]);
    }

    private void addNorthNeighbourForCell(int y, int x) {
        if (y != 0)
            cells[y][x].addNeighbour(cells[y - 1][x]);
    }

    private void addWestNeighbourForCell(int y, int x) {
        if (x != 0)
            cells[y][x].addNeighbour(cells[y][x - 1]);
    }

    private void addEastNeighbourForCell(int y, int x) {
        if (x != l - 1)
            cells[y][x].addNeighbour(cells[y][x + 1]);
    }

    private String cellsToString(Cell[][] nextGenerationCells) {
        String str = "";
        for (Cell[] row : nextGenerationCells) {
            for (Cell c : row)
                str += c.toString();
            str += "\n";
        }
        return str.trim();
    }
}
