package racingcar.entry.domain;

public class Mileage {

    private static final int SETUP_MILEAGE = 0;

    private final int distance;

    private Mileage(int distance) {
        this.distance = distance;
    }

    public static Mileage setup() {
        return new Mileage(SETUP_MILEAGE);
    }

    public Mileage add(int torque) {
        return new Mileage(this.distance + torque);
    }

    public int getDistance() {
        return distance;
    }
}
