package racingcar.entry.domain;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;

    private final String carName;
    private final RacingEngine engine;

    private RacingCar(String carName) {
        validate(carName);

        this.carName = carName;
        this.engine = RacingEngine.setup();
    }

    public static RacingCar by(String carName) {
        return new RacingCar(carName);
    }

    public void drive() {
        pedaling();
    }

    private void pedaling() {
        engine.movement();
    }

    public int position() {
        return engine.mileage();
    }

    public String name() {
        return carName;
    }

    private void validate(String carName) {
        validateSuitableName(carName);
        validateVacantName(carName);
        validateEmptySpaceIsExistInCarName(carName);
    }

    private void validateSuitableName(String carName) {
        if(carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 너무 길어");
        }
    }

    private void validateVacantName(String carName) {
        if(carName.isEmpty()) {
            throw new IllegalArgumentException("구분자 사이에 비어있는 이름이 있어");
        }
    }

    private void validateEmptySpaceIsExistInCarName(String carName) {
        if(carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백 문자가 포함되었어");
        }
    }
}
