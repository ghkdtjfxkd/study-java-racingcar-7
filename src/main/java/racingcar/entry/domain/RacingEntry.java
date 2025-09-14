package racingcar.entry.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingEntry {

    private final List<RacingCar> racingCars;
    private final RacingCarNames racingCarNames;

    private RacingEntry(String carNames) {
        this.racingCars = new ArrayList<>();
        this.racingCarNames = RacingCarNames.from(carNames);
        registerAllCars();
    }

    public static RacingEntry from(String carNames) {
        return new RacingEntry(carNames);
    }

    public void updateCarPositions() {
        racingCars.forEach(RacingCar::drive);
    }

    private List<String> carNames() {
        return racingCarNames.get();
    }

    private void registerAllCars() {
        carNames().forEach(this::assign);
    }

    private void assign(String carName) {
        racingCars.add(registerCar(carName));
    }

    private RacingCar registerCar(String carName) {
        return RacingCar.by(carName);
    }

    public LinkedHashMap<String, Integer> racingResult() {
        LinkedHashMap<String, Integer> score = new LinkedHashMap<>();

        for (RacingCar racingCar : this.racingCars) {
            score.put(racingCar.name(), racingCar.position());
        }

        return score;
    }
}
