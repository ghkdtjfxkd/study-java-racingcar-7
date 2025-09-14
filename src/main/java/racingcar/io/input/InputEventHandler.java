package racingcar.io.input;

import racingcar.common.EventBus;
import racingcar.common.events.InputEvents;
import racingcar.common.events.RacingEntryEvents;

public class InputEventHandler {

    private final EventBus eventBus;

    public InputEventHandler(EventBus eventBus) {
        this.eventBus = eventBus;
        registerHandlers();
    }

    private void registerHandlers() {
        eventBus.subscribe(InputEvents.InputStart.class, this::handleUserEnteredParticipants);
        eventBus.subscribe(RacingEntryEvents.RacingParticipantsReceived.class, this::handleUserEnteredLapCount);
    }

    private void handleUserEnteredParticipants(InputEvents.InputStart event) {
        String input = UserInput.participants();
        eventBus.publish(new InputEvents.UserEnteredParticipants(input));
    }

    private void handleUserEnteredLapCount(RacingEntryEvents.RacingParticipantsReceived event) {
        String input = UserInput.lapCount();
        UserInput.close();
        eventBus.publish(new InputEvents.UserEnteredLapCount(input));
    }
}
