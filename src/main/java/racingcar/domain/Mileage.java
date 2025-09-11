package racingcar.domain;

public class Mileage {

    private static final int INITIAL_MILEAGE = 0;

    private final int distance;

    private Mileage(int distance) {
        this.distance = distance;
    }

    public static Mileage setup() {
        return new Mileage(INITIAL_MILEAGE);
    }

    public Mileage add(int distance) {
        return new Mileage(this.distance + distance);
    }

    public int getDistance() {
        return distance;
    }
}
