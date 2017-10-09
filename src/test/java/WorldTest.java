import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    @Test
    public void rectangleWorldToString() throws Exception {
        String input = "*..\n.**\n..*";
        World world = new World(input);
        assertEquals(input, world.toString());
    }
}
