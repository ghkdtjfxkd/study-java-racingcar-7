package racingcar.common;

import racingcar.common.events.InputEvents;

public class RacingCarGames {

    private final EventBus eventBus;

    public RacingCarGames(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void start() {
        eventBus.publish(new InputEvents.InputStart());
    }
}
