package bowling.frame;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FramesTest {

    @Test
    public void max_size_is_10() {
        ArrayList<Frame> aListOf11Frames = Lists.list(Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike());
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Frames(aListOf11Frames)
        );
    }

    @Test
    public void min_size_is_10() {
        ArrayList<Frame> aListOf9Frames = Lists.list(Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike());
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Frames(aListOf9Frames)
        );
    }

    @Test
    public void size_should_be_10() {
        List<Frame> aListOf10Frames = Lists.list(Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike(), Frame.strike());
        new Frames(aListOf10Frames);
    }
}