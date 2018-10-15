package bowling.frame;

import bowling.Score;
import bowling.rolls.Roll;

public class Frame {

    final Roll first;
    final Roll second;

    public Frame(Roll first, Roll second) {
        this.first = first;
        this.second = second;
    }

    public Score score() {
        if (isStrike() || isSpare()) {
            return Score.TEN;
        }

        return first.add(second);
    }

    boolean isSpare() {
        return second.isSpare();
    }

    boolean isStrike() {
        return first.isStrike();
    }

    public static Frame strike() {
        return new Frame(Roll.strike(), null);
    }

    public boolean isLast() {
        return false;
    }
}
