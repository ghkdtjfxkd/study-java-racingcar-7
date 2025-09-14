package racingcar.score.domain;

import java.util.LinkedHashMap;

public class LapScore {

    private static final String RACING_LOG_FORMAT = "%s : %s";
    private static final String MILEAGE_SIGN = "-";

    private final String racingDetails;
    private Winner winner;

    // 생성용
    private LapScore(LinkedHashMap<String,Integer> currentScore) {
        this.racingDetails = parseCurrentScore(currentScore);
        this.winner = Winner.of(currentScore);
    }

    // 업데이트용
    private LapScore(String racingDetails, Winner winner) {
        this.racingDetails = racingDetails;
        this.winner = winner;
    }

    public static LapScore of(LinkedHashMap<String,Integer> currentScore) {
        return new LapScore(currentScore);
    }

    public LapScore updateTo(LinkedHashMap<String,Integer> currentScore) {
        String currentRacingDetails = parseCurrentScore(currentScore);
        String updatedRacingDetails = appendRacingDetails(currentRacingDetails);

        return new LapScore(updatedRacingDetails, Winner.of(currentScore));
    }

    private String appendRacingDetails(String currentRacingDetails) {
        return this.racingDetails + System.lineSeparator() + currentRacingDetails;
    }

    private String parseCurrentScore(LinkedHashMap<String,Integer> currentScore) {
        StringBuilder buffer = new StringBuilder();

        currentScore.forEach((carName, position) -> {
            buffer.append(parseRacingLog(carName,position));
            buffer.append(System.lineSeparator());
        });

        return buffer.toString();
    }

    private String parseRacingLog(String carName, Integer position){
        return String.format(RACING_LOG_FORMAT, carName, parsePosition(position));
    }

    private String parsePosition(int position) {
        return MILEAGE_SIGN.repeat(position);
    }

    public String result() {
        return racingDetails + System.lineSeparator() + winner.winnerLogOf();
    }
}
