package racingcar.score;

import racingcar.common.events.RacingEntryEvents.RacingCarsMoved;
import racingcar.score.domain.LapScore;
import racingcar.score.repository.ScoreRepository;

public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService() {
        this.scoreRepository = new ScoreRepository();
    }

    public void recordScore(RacingCarsMoved racingCarsMoved) {
        if(this.scoreRepository.isEmpty()){
            setupLapScore(racingCarsMoved);
            return;
        }

        updateCurrentScore(racingCarsMoved);
    }

    private void setupLapScore(RacingCarsMoved racingCarsMoved) {
        this.scoreRepository.setup(LapScore.of(racingCarsMoved.currentScore()));
    }

    private void updateCurrentScore(RacingCarsMoved racingCarsMoved) {
        LapScore lapScore = this.scoreRepository.getLapScore();
        this.scoreRepository.update(lapScore.updateTo(racingCarsMoved.currentScore()));
    }

    public String result() {
        LapScore lapScore = scoreRepository.getLapScore();
        return lapScore.result();
    }
}
