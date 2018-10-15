package bowling.frame;

import bowling.Score;

import java.util.List;

public class Frames {

    private final List<Frame> frames;

    public Frames(List<Frame> frames) {
        if (frames.size() != 10) {
            throw new IllegalArgumentException("A bowling game is composed by 10 frames");
        }
        this.frames = frames;
    }

    public Score score() {
        Score score = Score.ZERO;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if (!frame.isLast() && frame.isStrike()) {
                score = score.add(strike(frames.get(i + 1), frames.get(i + 2)));
            } else if (!frame.isLast() && frame.isSpare()) {
                score = score.add(spare(frames.get(i + 1)));
            } else {
                score = score.add(frame.score());
            }
        }

        return score;
    }


    private Score strike(Frame frame, Frame frame2) {
        if (frame.isStrike()) {
            return Score.TEN.add(Score.TEN).add(frame2.first.score());
        }
        return frame.score().add(Score.TEN);
    }


    private Score spare(Frame frame) {
        return frame.first.score().add(Score.TEN);
    }

}
