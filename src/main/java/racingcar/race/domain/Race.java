package racingcar.race.domain;

import java.math.BigInteger;
import racingcar.race.vo.RemainingLaps;

public class Race {

    private final RemainingLaps remainingLaps;

    // 생성용
    private Race(String lapCount) {
        validate(lapCount);
        this.remainingLaps = RemainingLaps.of(Integer.parseInt(lapCount));
    }

    // 상태 업데이트 용
    private Race(RemainingLaps remainingLaps) {
        this.remainingLaps = remainingLaps;
    }

    public static Race of(String remainingLaps) {
        return new Race(remainingLaps);
    }

    public Race completeLap() {
        return new Race(remainingLaps.decrease());
    }

    public boolean isCompleted() {
        return !hasRemainingLaps();
    }

    private boolean hasRemainingLaps() {
        return remainingLaps.hasLapsLeft();
    }

    private void validate(String lapCount) {
        validateEmptyInput(lapCount);
        validateWrongLapCountRange(lapCount);
    }

    private void validateEmptyInput(String lapCount) {
        if(lapCount == null || lapCount.isEmpty()) {
            throw new IllegalArgumentException("랩 값 입력 안들어옴");
        }
    }

    private void validateWrongLapCountRange(String lapCount) {
        BigInteger count = new BigInteger(lapCount);

        if(count.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("입력값은 0보다 작으면 안돼");
        }

        if(count.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException("너무 큰 숫자야");
        }
    }
}
