package racingcar.domain;

import java.util.List;
import java.util.Map;

public class LapScore {

    private static final String MILEAGE_SIGN = "-";
    private static final String CAR_SCORE_FORMAT = "%s : %s";

    private final List<String> carNames;
    private final String score;

    private LapScore(List<String> carNames, String score) {
        this.carNames = carNames;
        this.score = score;
    }

//    public LapScore update(String newScore) {
//        return new LapScore(recordedNewScore(newScore));
//    }
//
//    public String parsedFrom(Map<String, Integer> currentScore) {
//        currentScore.p stream()
//        return
//    }

    private String recordedNewScore(String newScore) {
        return this.score + System.lineSeparator() + newScore;
    }

    public String currentCarScoreFrom(RacingCar car) {
        return String.format(CAR_SCORE_FORMAT, car.name(), car.position() ) + System.lineSeparator();
    }

    private String carMileageParsing(int mileage) {
        return MILEAGE_SIGN.repeat(mileage);
    }
}
