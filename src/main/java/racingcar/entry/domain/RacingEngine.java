package racingcar.entry.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingEngine {

    private static final int MIN_PEDALING_RANGE = 0;
    private static final int MAX_PEDALING_RANGE = 9;

    private static final int REPULSIVE_OF_PEDAL = 4;
    private static final int TORQUE = 1;

    private Mileage mileage;

    private RacingEngine() {
        this.mileage = Mileage.setup();
    }

    public static RacingEngine setup() {
        return new RacingEngine();
    }

    public void movement() {
        if(pedalingIsEffective()) {
            mileage = mileage.add(TORQUE);
        }
    }

    public int mileage() {
        return mileage.getDistance();
    }

    private boolean pedalingIsEffective() {
        return pushingPedal() >= REPULSIVE_OF_PEDAL;
    }

    private int pushingPedal() {
        return Randoms.pickNumberInRange(MIN_PEDALING_RANGE, MAX_PEDALING_RANGE);
    }

}
