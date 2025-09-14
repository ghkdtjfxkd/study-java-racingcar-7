package racingcar.config;

import racingcar.common.EventBus;
import racingcar.entry.EntryService;
import racingcar.entry.event.EntryEventHandler;
import racingcar.io.input.InputEventHandler;
import racingcar.io.output.OutputEventHandler;
import racingcar.lap.LapService;
import racingcar.lap.event.LapEventHandler;
import racingcar.race.RaceService;
import racingcar.race.event.RaceEventHandler;
import racingcar.score.ScoreService;
import racingcar.score.event.ScoreEventHandler;

public class GameConfiguration {

    public static Services createServices() {
        return new Services(
                new EntryService(),
                new LapService(),
                new RaceService(),
                new ScoreService()
        );
    }

    public static void registerEventHandlers(EventBus eventBus, Services services) {
        new InputEventHandler(eventBus);
        new OutputEventHandler(eventBus);

        new EntryEventHandler(eventBus, services.entryService());
        new LapEventHandler(eventBus, services.lapService());
        new RaceEventHandler(eventBus, services.raceService());
        new ScoreEventHandler(eventBus, services.scoreService());
    }

    public record Services(
            EntryService entryService,
            LapService lapService,
            RaceService raceService,
            ScoreService scoreService
    ) {}
}
