package racingcar.score.repository;

import racingcar.score.domain.LapScore;

public class ScoreRepository {

    private LapScore lapScore;

    public void setup(LapScore lapScore) {
        this.lapScore = lapScore;
    }

    public LapScore update(LapScore lapScore) {
        this.lapScore = lapScore;
        return lapScore;
    }

    public LapScore getLapScore() {
        return this.lapScore;
    }

    public boolean isEmpty () {
        return this.lapScore == null;
    }
}
