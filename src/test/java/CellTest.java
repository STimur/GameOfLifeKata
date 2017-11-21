import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {
    @Test
    public void deadCellWithNoNeighboursStaysDead() throws Exception {
        Cell cell = new Cell('.');
        assertFalse(cell.nextGen().isAlive);
    }

    @Test
    public void deadCellWithThreeAliveNeighboursBecomesAlive() throws Exception {
        Cell cell = new Cell('.');
        cell.addNeighbour(new Cell('*'));
        cell.addNeighbour(new Cell('*'));
        cell.addNeighbour(new Cell('*'));
        assertTrue(cell.nextGen().isAlive);
    }
}
