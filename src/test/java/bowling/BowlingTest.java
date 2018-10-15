package bowling;

import bowling.frame.Frame;
import bowling.frame.FrameWithBonus;
import bowling.frame.Frames;
import bowling.rolls.Roll;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static bowling.BowlingTest.DSL.scoreOf;

public class BowlingTest {

    @Test
    public void sum_all_throws_when_no_spare_nor_strike() {
        scoreOf("9- -- -- -- -- -- -- -- -- --").shouldBe(9);
        scoreOf("9- 8- -- -- -- -- -- -- -- --").shouldBe(17);
        scoreOf("81 9- -- -- -- -- -- -- -- --").shouldBe(18);
    }

    @Test
    public void score_for_spare_is_ten_plus_the_number_of_pins_knocked_down_on_next_throw() {
        scoreOf("8/ 9- -- -- -- -- -- -- -- --").shouldBe(19 + 9);
        scoreOf("8/ 9/ 9- -- -- -- -- -- -- --").shouldBe(19 + 19 + 9);
        scoreOf("8- 9/ X -- -- -- -- -- -- --").shouldBe(8 + 20 + 10);
        scoreOf("9/ 45 -- -- -- -- -- -- -- --").shouldBe(14 + 9);
    }

    @Test
    public void bonus_throw_score_after_a_spare_or_a_strike_is_added_to_score() {
        scoreOf("-- -- -- -- -- -- -- -- -- 9/9").shouldBe(19);
        scoreOf("-- -- -- -- -- -- -- -- -- X45").shouldBe(19);
        scoreOf("-- -- -- -- -- -- -- -- -- XXX").shouldBe(30);
    }

    @Test
    public void score_for_strike_is_ten_plus_the_number_of_pins_knocked_down_on_next_2_throws() {
        scoreOf("X 45 -- -- -- -- -- -- -- --").shouldBe(28);
        scoreOf("X X 9- -- -- -- -- -- -- --").shouldBe(29 + 19 + 9);
        scoreOf("X X 9/ 9- -- -- -- -- -- --").shouldBe(29 + 20 + 19 + 9);
        scoreOf("X X X 9- -- -- -- -- -- --").shouldBe(30 + 29 + 19 + 9);
    }


    static class DSL {
        private final Score score;

        private DSL(Score score) {
            this.score = score;
        }

        void shouldBe(int points){
            Assertions.assertThat(score).isEqualTo(Score.of(points));
        }

        static DSL scoreOf(String frames) {
            return new DSL(frames(frames).score());
        }

        private static Frames frames(String frames) {
            String[] split = frames.split(" ");
            List<Frame> list = new ArrayList<>();
            for (String frame : split) {
                list.add(getFrame(frame));
            }
            return new Frames(list);

        }

        private static Frame getFrame(String frame) {
            if (frame.length() == 3) {
                return new FrameWithBonus(new Roll(frame.charAt(0)), new Roll(frame.charAt(1)), new Roll(frame.charAt(2)));
            } else if (frame.length() == 2) {
                return new Frame(new Roll(frame.charAt(0)), new Roll(frame.charAt(1)));
            }
            return Frame.strike();
        }
    }


}
