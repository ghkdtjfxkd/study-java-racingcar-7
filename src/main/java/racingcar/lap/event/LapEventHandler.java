package racingcar.lap.event;

import racingcar.common.EventBus;
import racingcar.common.events.LapEvents;
import racingcar.common.events.RaceEvents;
import racingcar.common.events.RaceEvents.LapIsLeft;
import racingcar.common.events.ScoreEvents;
import racingcar.common.events.ScoreEvents.RacingRecorded;
import racingcar.lap.LapService;

public class LapEventHandler {

    private final EventBus eventBus;
    private final LapService lapService;

    public LapEventHandler(EventBus eventBus, LapService lapService) {
        this.eventBus = eventBus;
        this.lapService = lapService;
        registerHandlers();
    }

    private void registerHandlers() {
        eventBus.subscribe(RaceEvents.LapIsLeft.class, this::handleLapShiftInProgress);
        eventBus.subscribe(ScoreEvents.RacingRecorded.class, this::handleLapShiftPending);
    }

    private void handleLapShiftInProgress(LapIsLeft lapIsLeft) {
        lapService.shiftToInProgress();
        eventBus.publish(new LapEvents.LapStarted());
    }

    private void handleLapShiftPending(RacingRecorded racingRecorded) {
        lapService.shiftToPending();
        eventBus.publish(new LapEvents.LapCompleted());
    }
}
