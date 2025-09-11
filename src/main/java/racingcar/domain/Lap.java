package racingcar.domain;

import java.math.BigInteger;

public class Lap {

    private static final int MIN_LENGTH = 1;

    private final int goalLapTime;
    private final BigInteger currentLapTime;

    private Lap(int goalLapTime) {
        this.goalLapTime = goalLapTime;
        this.currentLapTime = BigInteger.ZERO;
    }

    public static Lap of(String lapTime) {
//        return new Lap(lapTime);
        return new Lap(Integer.parseInt(lapTime));
    }

    public Lap next() {
        return Lap.of(String.valueOf(nextLapNumber()));
    }

    private long nextLapNumber() {
        return currentLapTime.longValueExact() + 1;
    }

    private BigInteger parseAndValidate(String rawValue) {
        try {
            BigInteger parsed = new BigInteger(rawValue);
            validate(parsed);
            return parsed;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자: " + rawValue, e);
        }
    }

    private void validate(BigInteger parsed) {
        validateZeroLap(parsed);
        validateNonNegative(parsed);
        validateWithinLongRange(parsed);
    }

    private void validateZeroLap(BigInteger value) {
        if(value.equals(BigInteger.ZERO)){
            throw new IllegalArgumentException("0 바퀴는 입력될 수 없다.");
        }
    }

    private void validateNonNegative(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
    }

    private void validateWithinLongRange(BigInteger value) {
        try {
            long none = value.longValueExact();
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("숫자가 Long 범위를 초과합니다: " + value, e);
        }
    }

    private enum LapStatus {
        PENDING, IN_PROGRESS, COMPLETED
    }

//    public static Lap of(RacingEntry racingEntry) {
//        return new Lap(racingEntry);
//    }
//
//    public void race(int count) {
//
//    }
//
//    public void next(int count) {
//        this = Lap.of(racingEntry);
//    }
    //
//    public Lap next() {
//        return new Lap(this.racingEntry, this.leftLap - 1);
//    }
//
//    private String lapScore () {
//        return score.parsedFrom(racingEntry.racingResult());
//    }
}
