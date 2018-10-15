package bowling.frame;

import bowling.Score;
import bowling.rolls.Roll;

public class FrameWithBonus extends Frame {

    private final Roll third;

    public FrameWithBonus(Roll first, Roll second, Roll third) {
        super(first, second);
        this.third = third;
    }

    public Score score() {
        return first.add(second).add(third.score());

    }

    public boolean isLast() {
        return true;
    }

}
