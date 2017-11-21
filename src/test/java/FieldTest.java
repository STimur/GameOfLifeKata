import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {
    private Field field;

    private void assertNextGenerationFieldEquals(String expected) {
        field = field.nextGen();
        assertEquals(expected, field.toString());
    }

    @Test
    public void fieldWithOneDeadCell() throws Exception {
        field = new Field(".");
        assertNextGenerationFieldEquals(".");
    }

    @Test
    public void horizontalFieldWithThreeAliveCells() throws Exception {
        field = new Field("***");
        assertNextGenerationFieldEquals("...");
    }

    @Test
    public void verticalFieldWithThreeAliveCells() throws Exception {
        field = new Field("*\n*\n*");
        assertNextGenerationFieldEquals(".\n.\n.");
    }

    @Test
    public void fieldWithBlinkerOscillator() throws Exception {
        field = new Field(".....\n..*..\n..*..\n..*..\n.....");
        assertNextGenerationFieldEquals(".....\n.....\n.***.\n.....\n.....");
        assertNextGenerationFieldEquals(".....\n..*..\n..*..\n..*..\n.....");
    }

    @Test
    public void fieldWithGlider() throws Exception {
        field = new Field(".....\n.*.*.\n..**.\n..*..\n.....");
        assertNextGenerationFieldEquals(".....\n...*.\n.*.*.\n..**.\n.....");
        assertNextGenerationFieldEquals(".....\n..*..\n...**\n..**.\n.....");
        assertNextGenerationFieldEquals(".....\n...*.\n....*\n..***\n.....");
        assertNextGenerationFieldEquals(".....\n.....\n..*.*\n...**\n...*.");
        assertNextGenerationFieldEquals(".....\n.....\n....*\n..*.*\n...**");
    }
}
