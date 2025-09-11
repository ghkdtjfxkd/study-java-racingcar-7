package racingcar;

import racingcar.controller.RacingController;
import racingcar.io.OutputView;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        RacingService racingService = new RacingServiceImpl(new RacingCarRepository());
        RacingController controller = new RacingController(racingService, new OutputView());
        controller.run();
    }
}
