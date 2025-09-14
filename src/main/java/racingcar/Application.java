package racingcar;

import java.util.concurrent.CompletableFuture;
import racingcar.common.EventBus;
import racingcar.common.RacingCarGames;
import racingcar.common.events.OutputEvents.RacingResultOffered;
import racingcar.config.GameConfiguration;

public class Application {

    public static void main(String[] args) {
        try {
            runWithEventDriven();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void runWithEventDriven() {
        EventBus eventBus = new EventBus();
        CompletableFuture<String> resultFuture = new CompletableFuture<>();

        eventBus.setExceptionCallback(resultFuture::completeExceptionally);
        subscribeGameResult(eventBus, resultFuture);

        RacingCarGames game = setupGame(eventBus);
        game.start();
        System.out.println(resultFuture.join());
    }

    private static void subscribeGameResult(EventBus eventBus, CompletableFuture<String> resultFuture) {
        eventBus.subscribe(RacingResultOffered.class,
                racingResult -> {
                    resultFuture.complete(racingResult.result());
                    eventBus.shutdown();
                }
        );
    }

    private static RacingCarGames setupGame(EventBus eventBus) {
        GameConfiguration.Services services = GameConfiguration.createServices();
        GameConfiguration.registerEventHandlers(eventBus, services);
        return new RacingCarGames(eventBus);
    }
}
