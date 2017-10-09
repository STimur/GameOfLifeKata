import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    @Test
    public void printOneCellWorld() throws Exception {
        String input = "*";
        World world = new World(input);
        assertEquals(input, world.toString());
    }

    @Test
    public void horizontalCellWorldToString() throws Exception {
        String input = "*.**..**";
        World world = new World(input);
        assertEquals(input, world.toString());
    }

    @Test
    public void verticalCellWorldToString() throws Exception {
        String input = "*\n.\n.\n*";
        World world = new World(input);
        assertEquals(input, world.toString());
    }
}
