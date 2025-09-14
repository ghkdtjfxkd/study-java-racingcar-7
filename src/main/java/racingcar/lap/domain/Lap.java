package racingcar.lap.domain;

public class Lap {

    private enum Status { PENDING, IN_PROGRESS }

    private final Status status;

    private Lap() {
        this.status = Status.PENDING;
    }

    public static Lap setup() {
        return new Lap();
    }

    private Lap(Status status) {
        this.status = status;
    }

    public Lap startLap() {
        if(!canStart()){
            throw new IllegalArgumentException("Lap이 이미 진행 중");
        }
        return new Lap(Status.IN_PROGRESS);
    }

    public Lap completeLap() {
        if(!isInProgress()){
            throw new IllegalStateException("진행 중인 Lap이 없음");
        }
        return new Lap(Status.PENDING);
    }

    private boolean canStart() {
        return status == Status.PENDING;
    }

    public boolean isInProgress() {
        return status == Status.IN_PROGRESS;
    }
}
