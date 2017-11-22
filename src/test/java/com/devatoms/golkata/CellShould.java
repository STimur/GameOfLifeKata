package com.devatoms.golkata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CellShould {
    @Test
    public void
    revive_if_has_three_alive_neighbours() {
        Cell cell = new Cell('.');
        cell.addNeighbour(new Cell('*'));
        cell.addNeighbour(new Cell('*'));
        cell.addNeighbour(new Cell('*'));
        assertThat(cell.nextGen().isAlive, is(true));
    }
}
