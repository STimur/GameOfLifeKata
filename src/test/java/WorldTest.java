import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    @Test
    public void printOneCellWorld() throws Exception {
        World world = new World("*");
        assertEquals("*", world.toString());
    }

    @Test
    public void horizontalCellWorldToString() throws Exception {
        World world = new World("*.**..**");
        assertEquals("*.**..**", world.toString());
    }
}
