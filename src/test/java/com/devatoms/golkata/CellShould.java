package com.devatoms.golkata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CellShould {

    private Cell cell;

    private Cell createCell(boolean isAlive) {
        if (isAlive)
            return new Cell('*');
        return new Cell('.');
    }

    private void addAliveNeighbours(int numOfNeighbours) {
        for (int i = 0; i < numOfNeighbours; i++)
            cell.addNeighbour(createCell(true));
    }

    @Test
    @Parameters({
            "false, 3, true",
            "false, 0, false",
            "true, 2, true"
    })
    public void
    create_next_generation(boolean isAlive, int numOfAliveNeighbours, boolean isAliveInNextGeneration) {
        cell = createCell(isAlive);
        addAliveNeighbours(numOfAliveNeighbours);
        assertThat(cell.nextGen().isAlive, is(isAliveInNextGeneration));
    }
}
