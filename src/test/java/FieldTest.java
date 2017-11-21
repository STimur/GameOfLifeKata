import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {
    private Field field;

    private void assertNextGenerationFieldEquals(String expected) {
        assertEquals(expected, field.nextGen().toString());
    }

    @Test
    public void oneDeadCellFieldStaysDead() throws Exception {
        field = new Field(".");
        assertNextGenerationFieldEquals(".");
    }

    @Test
    public void threeHorizontalAliveCellField() throws Exception {
        field = new Field("***");
        assertNextGenerationFieldEquals(".*.");
    }

    @Test
    public void threeVerticalAliveCellField() throws Exception {
        field = new Field("*\n*\n*");
        assertNextGenerationFieldEquals(".\n*\n.");
    }
}
