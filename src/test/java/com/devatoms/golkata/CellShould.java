package com.devatoms.golkata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CellShould {

    private Cell cell;

    private Cell createDeadCell() {
        return new Cell('.');
    }

    private Cell createAliveCell() {
        return new Cell('*');
    }

    private void addAliveNeighbours(int numOfNeighbours) {
        for (int i = 0; i < numOfNeighbours; i++)
            cell.addNeighbour(createAliveCell());
    }

    @Test
    public void
    revive_if_has_three_alive_neighbours() {
        cell = createDeadCell();
        addAliveNeighbours(3);
        assertThat(cell.nextGen().isAlive, is(true));
    }

    @Test
    public void
    stay_dead_if_has_no_neighbours() {
        cell = createDeadCell();
        assertThat(cell.nextGen().isAlive, is(false));
    }

    @Test
    public void
    stay_alive_if_has_two_alive_neighbours() {
        cell = createAliveCell();
        addAliveNeighbours(2);
        assertThat(cell.nextGen().isAlive, is(true));
    }
}
