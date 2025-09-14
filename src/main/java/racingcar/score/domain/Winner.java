package racingcar.score.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class Winner {

    private static final String WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_DELIMITER = ", ";

    private final int mostFarMileage;
    private final List<String> winners;

    private Winner(LinkedHashMap<String,Integer> currentScore) {
        this.mostFarMileage =  mostFarMileages(scoresFrom(currentScore));
        this.winners = pickWinnersFrom(currentScore);
    }

    public static Winner of(LinkedHashMap<String,Integer> currentScore) {
        return new Winner(currentScore);
    }

    public String winnerLogOf() {
        StringJoiner joiner = new StringJoiner(WINNER_DELIMITER);

        this.winners.forEach(joiner::add);
        return String.format(WINNERS_FORMAT,joiner.toString().trim());
    }

    private List<String> pickWinnersFrom(LinkedHashMap<String,Integer> currentScore) {
        return currentScore.entrySet().stream()
                .filter(this::isFastestCars)
                .map(Entry::getKey)
                .toList();
    }

    private List<Integer> scoresFrom(LinkedHashMap<String, Integer> currentScore) {
        return currentScore.values().stream().toList();
    }

    private int mostFarMileages(List<Integer> mileages) {
        return mileages.stream().max(Integer::compareTo).orElse(0);
    }

    private boolean isFastestCars(Entry<String, Integer> racingCarScore) {
        return racingCarScore.getValue().equals(this.mostFarMileage);
    }
}
