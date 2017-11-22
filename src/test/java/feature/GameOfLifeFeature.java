package feature;

import com.devatoms.golkata.Field;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GameOfLifeFeature {

    @Test
    @Parameters({
            ".",
            "***",
            "*\n*\n*",
            ".*.\n.*.\n.*."
    })
    public void
    have_string_representation(String input) {
        Field field = new Field(input);
        assertThat(field.toString(), is(input));
    }

    @Test
    @Parameters({
            "., .",
            "***, .*.",
            "*\n*\n*, .\n*\n.",
            ".*.\n.*.\n.*., ...\n***\n...",
            "...\n***\n..., .*.\n.*.\n.*."
    })
    public void
    create_next_generation(String input, String nextGenerationFieldAsString) {
        Field field = new Field(input);
        assertThat(field.nextGen().toString(), is(nextGenerationFieldAsString));
    }
}
