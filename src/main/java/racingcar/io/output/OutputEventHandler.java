package racingcar.io.output;

import racingcar.common.EventBus;
import racingcar.common.events.OutputEvents;
import racingcar.common.events.ScoreEvents;

public class OutputEventHandler {

    private static final String EXECUTE_RESULT = "실행 결과";
    private final EventBus eventBus;

    public OutputEventHandler(EventBus eventBus) {
        this.eventBus = eventBus;
        registerHandlers();
    }

    private void registerHandlers() {
        eventBus.subscribe(ScoreEvents.RacingResultDerived.class, this::handlePrintResult);
    }

    private void handlePrintResult(ScoreEvents.RacingResultDerived event) {
        String result = System.lineSeparator() + EXECUTE_RESULT + System.lineSeparator() + event.result();
        eventBus.publish(new OutputEvents.RacingResultOffered(result));
    }
}
