package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingEngine {

    private static final int ZERO = 0;
    private static final int TORQUE = 1;
    private static final int REPULSIVE_OF_PEDAL = 4;

    private RacingEngine() {}

    public static RacingEngine setup() {
        return new RacingEngine();
    }

    public int movement() {
        if(pedalingIsEffective()) {
            return TORQUE;
        }
        return ZERO;
    }

    private boolean pedalingIsEffective() {
        return pushingPedal() >= REPULSIVE_OF_PEDAL;
    }

    private int pushingPedal() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
