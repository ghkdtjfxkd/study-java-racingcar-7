package racingcar.score.event;

import racingcar.common.EventBus;
import racingcar.common.events.RaceEvents;
import racingcar.common.events.RaceEvents.RaceIsCompleted;
import racingcar.common.events.RacingEntryEvents;
import racingcar.common.events.RacingEntryEvents.RacingCarsMoved;
import racingcar.common.events.ScoreEvents;
import racingcar.score.ScoreService;

public class ScoreEventHandler {

    private final EventBus eventBus;
    private final ScoreService scoreService;

    public ScoreEventHandler(EventBus eventBus, ScoreService scoreService) {
        this.eventBus = eventBus;
        this.scoreService = scoreService;
        registerHandlers();
    }

    public void registerHandlers() {
        eventBus.subscribe(RacingEntryEvents.RacingCarsMoved.class, this::handleUpdateCurrentScore);
        eventBus.subscribe(RaceEvents.RaceIsCompleted.class, this::handleRacingResult);
    }

    private void handleUpdateCurrentScore(RacingCarsMoved racingCarsMoved) {
        scoreService.recordScore(racingCarsMoved);
        eventBus.publish(new ScoreEvents.RacingRecorded());
    }

    private void handleRacingResult(RaceIsCompleted raceIsCompleted) {
        eventBus.publish(new ScoreEvents.RacingResultDerived(scoreService.result()));
    }

}
