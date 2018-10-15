package bowling.rolls;

import bowling.Score;

import static java.lang.Character.isDigit;

public class Roll {

    private Character roll;
    private final Integer score;

    public Roll(Character roll) {
        if (!(roll.equals('X') || roll.equals('-') || roll.equals('/') || isDigit(roll))) {
            throw new IllegalArgumentException("A roll in bowling is \"X\" or \"/\" or \"-\" or a digit");
        }
        this.roll = roll.equals('-') ? '0' : roll;
        score = compute();
    }

    public boolean isSpare() {
        return roll.equals('/');
    }

    public boolean isStrike() {
        return roll.equals('X');
    }

    private int compute() {
        if (roll.equals('X') || roll.equals('/')) {
            return 10;
        }
        return new Integer(roll.toString());
    }

    public static Roll strike() {
        return new Roll('X');
    }

    public Score add(Roll augend) {
        if (augend.isSpare()) {
            return Score.TEN;
        }
        return Score.of(score + augend.score);
    }

    public Score score() {
        return Score.of(score);
    }
}
