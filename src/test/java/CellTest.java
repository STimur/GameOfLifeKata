import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {
    private void assertDeadInNextGeneration(Cell cell) {
        assertFalse(cell.nextGen().isAlive);
    }

    private void assertAliveInNextGeneration(Cell cell) {
        assertTrue(cell.nextGen().isAlive);
    }

    private void addManyAliveNeighboursToCell(Cell cell, int numOfNeighbours) {
        for (int i = 0; i < numOfNeighbours; i++)
            cell.addNeighbour(new Cell('*'));
    }

    private void addManyDeadNeighboursToCell(Cell cell, int numOfNeighbours) {
        for (int i = 0; i < numOfNeighbours; i++)
            cell.addNeighbour(new Cell('.'));
    }

    @Test
    public void deadCellWithNoNeighboursStaysDead() throws Exception {
        Cell cell = new Cell('.');
        assertDeadInNextGeneration(cell);
    }

    @Test
    public void deadCellWithThreeAliveNeighboursBecomesAlive() throws Exception {
        Cell cell = new Cell('.');
        addManyAliveNeighboursToCell(cell, 3);
        assertAliveInNextGeneration(cell);
    }

    @Test
    public void deadCellWithThreeDeadNeighboursStaysDead() throws Exception {
        Cell cell = new Cell('.');
        addManyDeadNeighboursToCell(cell, 3);
        assertDeadInNextGeneration(cell);
    }

    @Test
    public void aliveCellWithTwoAliveNeighboursStaysAlive() throws Exception {
        Cell cell = new Cell('*');
        addManyAliveNeighboursToCell(cell, 2);
        assertAliveInNextGeneration(cell);
    }

    @Test
    public void aliveCellWithNoNeighboursBecomesDead() throws Exception {
        Cell cell = new Cell('*');
        assertDeadInNextGeneration(cell);
    }

    @Test
    public void aliveCellWithFourAliveNeighboursBecomesDead() throws Exception {
        Cell cell = new Cell('*');
        addManyAliveNeighboursToCell(cell, 4);
        assertDeadInNextGeneration(cell);
    }
}
