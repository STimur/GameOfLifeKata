public class Field {
    private final Cell[] cells;
    private final int l;

    public Field(String input) {
        l = input.length();
        cells = new Cell[l];
        initCells(input);
        initCellsNeighbours();
    }

    private void initCellsNeighbours() {
        for (int i = 0; i < l; i++) {
            if (i != 0)
                cells[i].addNeighbour(cells[i - 1]);
            if (i != l - 1)
                cells[i].addNeighbour(cells[i + 1]);
        }
    }

    private void initCells(String input) {
        for (int i = 0; i < l; i++)
            cells[i] = new Cell(input.charAt(i));
    }

    public Field nextGen() {
        String input = "";
        for (Cell c : cells)
            input += c.nextGen();
        return new Field(input);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < l; i++)
            str += cells[i];
        return str;
    }
}
