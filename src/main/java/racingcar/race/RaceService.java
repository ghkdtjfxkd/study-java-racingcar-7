package racingcar.race;

import racingcar.race.domain.Race;
import racingcar.race.repository.RaceRepository;

public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService() {
        this.raceRepository = new RaceRepository();
    }

    public void startRace(String lapCount) {
        this.raceRepository.create(Race.of(lapCount));
    }

    public void finishLap() {
        Race race = raceRepository.getRace();
        raceRepository.update(race.completeLap());
    }

    public boolean isCompleted() {
        Race currentRace = raceRepository.getRace();
        return currentRace.isCompleted();
    }
}
