import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CellTest {
    @Test
    public void deadCellWithNoNeighboursStaysDead() throws Exception {
        Cell cell = new Cell('.');
        assertFalse(cell.nextGen().isAlive());
    }
}
