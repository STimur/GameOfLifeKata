import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CellTest {
    @Test
    public void underPopulation() throws Exception {
        Cell cell = new Cell(true);
        assertFalse(cell.nextGeneration().isAlive());
    }
}
