package racingcar.lap;

import racingcar.lap.domain.Lap;
import racingcar.lap.repository.LapRepository;

public class LapService {

    private final LapRepository lapRepository;

    public LapService() {
        this.lapRepository = new LapRepository();
        lapRepository.setup(Lap.setup());
    }

    public void shiftToInProgress() {
        Lap lap = getCurrentLap();
        lapRepository.update(lap.startLap());
    }

    public void shiftToPending() {
        Lap lap = getCurrentLap();
        lapRepository.update(lap.completeLap());
    }

    private Lap getCurrentLap() {
        return lapRepository.getLap();
    }

}
