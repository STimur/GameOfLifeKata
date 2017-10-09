import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {
    @Test
    public void underPopulation() throws Exception {
        Cell cell = new Cell(true);
        assertFalse(cell.nextGeneration().isAlive());
    }

    @Test
    public void stayAlive() throws Exception {
        Cell cell = new Cell(true);
        cell.addNeighbour(new Cell(true));
        cell.addNeighbour(new Cell(true));
        assertTrue(cell.nextGeneration().isAlive());
    }

    @Test
    public void stayDead() throws Exception {
        Cell cell = new Cell(false);
        cell.addNeighbour(new Cell(true));
        cell.addNeighbour(new Cell(true));
        assertFalse(cell.nextGeneration().isAlive());
    }
}
