package racingcar.repository;

import racingcar.domain.Lap;

public class LapRepository {

    private Lap lap;

    public void setupTo(Lap lap) {
        this.lap = lap;
    }

    public Lap getLap() {
        return lap;
    }
}
