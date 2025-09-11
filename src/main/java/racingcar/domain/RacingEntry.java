package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<RacingCar> getRacingCars() {
        return List.copyOf(racingCars);
    }

    public List<String> carNames() {
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

    public Map<String, Integer> racingResult() {
        Map<String, Integer> score = new HashMap<>();

        for (RacingCar racingCar : racingCars) {
            score.put(racingCar.name(), racingCar.position());
        }

        return score;
    }

    private void updateLap() {
        racingCars.forEach(RacingCar::drive);
    }



}
