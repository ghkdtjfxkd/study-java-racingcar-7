package racingcar.controller;

import racingcar.io.OutputView;
import racingcar.io.UserInput;
import racingcar.service.RacingService;

public class RacingController {

    private final RacingService racingService;
    private final OutputView outputView;

    public RacingController(RacingService racingService, OutputView outputView) {
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        process(this::setupCars);
        process(this::setupLap);
        process(this::race);
    }

    private void setupCars() {
        racingService.setupRacingCar(UserInput.participants());
    }

    private void setupLap() {
        racingService.setupLapCount(UserInput.tryingCount());
    }

    private void race() {}

//    private void winningResult() {
//        outputView.result(racingService.winner());
//    }

    private void process(Runnable action) {
        action.run();
    }
}
