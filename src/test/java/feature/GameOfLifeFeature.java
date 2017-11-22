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
            ".*.\n.*.\n.*., ...\n***\n...",
    })
    public void
    blinker_oscillator_pattern(String firstStepFieldAsString, String secondStepFieldAsString) {
        Field field = new Field(firstStepFieldAsString).nextGen();
        assertThat(field.toString(), is(secondStepFieldAsString));
        assertThat(field.nextGen().toString(), is(firstStepFieldAsString));
    }
}
