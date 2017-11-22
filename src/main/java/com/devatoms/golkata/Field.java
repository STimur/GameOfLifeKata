package com.devatoms.golkata;

public class Field {
    private final char[] cells;
    private final int l;

    public Field(String input) {
        l = input.length();
        cells = new char[l];
        for (int i = 0; i < l; i++)
            cells[i] = input.charAt(i);
    }

    public Field nextGen() {
        return new Field(new String(cells));
    }

    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return new String(cells);
    }
}
