package racingcar.lap.repository;

import racingcar.lap.domain.Lap;

public class LapRepository {

    private Lap lap;

    public void setup(Lap setup) {
        this.lap = setup;
    }

    public Lap getLap() {
        return lap;
    }

    public void update(Lap updatedLap) {
        this.lap = updatedLap;
    }
}
