package bowling;

public class Score {

    public static final Score TEN = Score.of(10);
    public static final Score ZERO = Score.of(0);

    private final int value;

    private Score(int value) {
        this.value = value;
    }

    public static Score of(int points) {
        return new Score(points);
    }

    public Score add(Score points) {
        return new Score(value+points.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;

        Score score = (Score) o;

        return value == score.value;
    }
}
