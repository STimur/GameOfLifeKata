import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    @Test
    public void rectangleWorldToString() throws Exception {
        String input = "*..\n.**\n..*";
        World world = new World(input);
        assertEquals(input, world.toString());
    }

    @Test
    public void oneCellWorldNextGeneration() throws Exception {
        World world = new World("*");
        assertEquals(".", world.nextGeneration().toString());
    }

    @Test
    public void horizontalCellWorldNextGenerationToString() throws Exception {
        World world = new World("****");
        assertEquals(".**.", world.nextGeneration().toString());
    }
}
