package racingcar.race.vo;

public class RemainingLaps {

    private static final int ZERO = 0;
    private static final int DECREASE = 1;

    private final int count;

    private RemainingLaps(int count) {
        this.count = count;
    }

    public static RemainingLaps of(int count) {
        return new RemainingLaps(count);
    }

    public RemainingLaps decrease() {
        return new RemainingLaps(count - DECREASE);
    }

    public boolean hasLapsLeft() {
        return count != ZERO;
    }
}
