package racingcar.domain;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;

    private final String carName;
    private Mileage mileage;
    private RacingEngine engine;

    private RacingCar(String carName) {
        validateSuitableName(carName);
        validateVacantName(carName);

        this.carName = carName;

        baseSetup();
    }

    private void baseSetup() {
        this.mileage = Mileage.setup();
        this.engine = RacingEngine.setup();
    }

    public static RacingCar by(String carName) {
        return new RacingCar(carName);
    }

    private void validateSuitableName(String carName) {
        if(carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("너무 길어");
        }
    }

    private void validateVacantName(String carName) {
        if(carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 빈게 있어");
        }
    }

    public void drive() {
        pedaling();
    }

    private void pedaling() {
        this.mileage = mileage.add(engine.movement());
    }

    public int position() {
        return mileage.getDistance();
    }

    public String name() {
        return carName;
    }
}
