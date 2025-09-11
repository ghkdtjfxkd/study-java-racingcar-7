package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarNames {

    private final String rawInput;

    private RacingCarNames(String rawInput) {
        validateVacantInput(rawInput);
        this.rawInput = rawInput;
    }

    public static RacingCarNames from(String rawInput) {
        return new RacingCarNames(rawInput);
    }

    private void validateVacantInput(String rawInput) {
        if(inputIsNullOrEmpty(rawInput)) {
            throw new IllegalArgumentException("빈 입력");
        }
    }

    private boolean inputIsNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public List<String> get() {
        validateSameNameExist();
        return carNames();
    }

    private void validateSameNameExist() {
        if(hasSameCarName()) {
            throw new IllegalArgumentException("동일한 차이름 존재");
        }
    }

    private boolean hasSameCarName() {
        return carNames().size() > uniqueCarNames().size();
    }

    private List<String> carNames() {
        return List.of(this.rawInput.split(","));
    }

    private Set<String> uniqueCarNames() {
        return new HashSet<>(carNames());
    }
}
