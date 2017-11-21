public class Field {
    private final Cell[] cells;

    public Field(String input) {
        int l = input.length();
        cells = new Cell[l];
        for (int i = 0; i < l; i++)
            cells[i] = new Cell(input.charAt(i));
        for (int i = 0; i < l; i++) {
            if (i != 0)
                cells[i].addNeighbour(cells[i - 1]);
            if (i != l - 1)
                cells[i].addNeighbour(cells[i + 1]);
        }
    }

    public Field nextGen() {
        String input = "";
        for (Cell c : cells)
            input += c.nextGen();
        return new Field(input);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < cells.length; i++)
            str += cells[i];
        return str;
    }
}
