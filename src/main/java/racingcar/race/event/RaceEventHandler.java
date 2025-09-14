package racingcar.race.event;

import racingcar.common.EventBus;
import racingcar.common.events.InputEvents;
import racingcar.common.events.LapEvents;
import racingcar.common.events.RaceEvents;
import racingcar.race.RaceService;

public class RaceEventHandler {

    private final EventBus eventBus;
    private final RaceService raceService;

    public RaceEventHandler(EventBus eventBus, RaceService raceService) {
        this.eventBus = eventBus;
        this.raceService = raceService;
        registerHandlers();
    }

    private void registerHandlers() {
        eventBus.subscribe(InputEvents.UserEnteredLapCount.class, this::handleUserInputLapCount);
        eventBus.subscribe(LapEvents.LapCompleted.class, this::handleLapCompleted);
    }

    private void handleUserInputLapCount(InputEvents.UserEnteredLapCount event) {
        try {
            raceService.startRace(event.input());
            eventBus.publish(new RaceEvents.LapIsLeft());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            eventBus.shutdown();
        }
    }

    private void handleLapCompleted(LapEvents.LapCompleted lapCompleted) {
        raceService.finishLap();

        if(raceIsCompleted()){
            eventBus.publish(new RaceEvents.RaceIsCompleted());
            return;
        }

        eventBus.publish(new RaceEvents.LapIsLeft());
    }

    private boolean raceIsCompleted() {
        return raceService.isCompleted();
    }

}
