package racingcar.observer;

import racingcar.domain.Lap;

public interface LapObserver {
    void update(Lap lap);
}
