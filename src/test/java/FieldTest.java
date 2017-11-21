import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {
    @Test
    public void oneDeadCellFieldStaysDead() throws Exception {
        Field field = new Field(".");
        assertEquals(".", field.nextGen().toString());
    }

    @Test
    public void threeHorizontalAliveCellField() throws Exception {
        Field field = new Field("***");
        assertEquals(".*.", field.nextGen().toString());
    }
}
