package feature;

import com.devatoms.golkata.Field;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeFeature {

    private Field field;

    private void assertNextGenerationFieldIs(String fieldAsString) {
        field = field.nextGen();
        assertThat(field.toString(), is(fieldAsString));
    }

    @Test
    public void
    field_with_blinker_oscillator_pattern() {
        field = new Field(".....\n..*..\n..*..\n..*..\n.....");
        assertNextGenerationFieldIs(".....\n.....\n.***.\n.....\n.....");
        assertNextGenerationFieldIs(".....\n..*..\n..*..\n..*..\n.....");
    }

    @Test
    public void
    field_with_glider_spaceship_pattern() {
        field = new Field(".....\n.*.*.\n..**.\n..*..\n.....");
        assertNextGenerationFieldIs(".....\n...*.\n.*.*.\n..**.\n.....");
        assertNextGenerationFieldIs(".....\n.*.*.\n..**.\n..*..\n.....");
        assertNextGenerationFieldIs(".....\n..*..\n...**\n..**.\n.....");
        assertNextGenerationFieldIs(".....\n...*.\n....*\n..***\n.....");
        assertNextGenerationFieldIs(".....\n.....\n..*.*\n...**\n...*.");
        assertNextGenerationFieldIs(".....\n.....\n....*\n..*.*\n...**");
    }
}
