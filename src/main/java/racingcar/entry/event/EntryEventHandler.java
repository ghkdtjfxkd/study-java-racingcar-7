package racingcar.entry.event;

import java.util.LinkedHashMap;
import racingcar.common.EventBus;
import racingcar.common.events.InputEvents;
import racingcar.common.events.LapEvents;
import racingcar.common.events.LapEvents.LapStarted;
import racingcar.common.events.RacingEntryEvents;
import racingcar.entry.EntryService;

public class EntryEventHandler {

    private final EventBus eventBus;
    private final EntryService entryService;

    public EntryEventHandler(EventBus eventBus, EntryService entryService) {
        this.eventBus = eventBus;
        this.entryService = entryService;
        registerHandlers();
    }

    private void registerHandlers() {
        eventBus.subscribe(InputEvents.UserEnteredParticipants.class, this::handleUserEnteredParticipants);
        eventBus.subscribe(LapEvents.LapStarted.class, this::handleRacingCarMoved);
    }

    private void handleUserEnteredParticipants(InputEvents.UserEnteredParticipants event) {
        entryService.setupRacingEntry(event.input());
        eventBus.publish(new RacingEntryEvents.RacingParticipantsReceived());

    }

    private void handleRacingCarMoved(LapStarted lapStarted) {
        entryService.moveCars();
        LinkedHashMap<String, Integer> currentPositions = entryService.getCurrentPositions();
        eventBus.publish(new RacingEntryEvents.RacingCarsMoved(currentPositions));
    }
}
