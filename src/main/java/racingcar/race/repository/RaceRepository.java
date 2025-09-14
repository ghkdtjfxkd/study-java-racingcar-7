package racingcar.race.repository;

import racingcar.race.domain.Race;

public class RaceRepository {

    private Race race;

    public void create(Race race) {
        this.race = race;
    }

    public Race update(Race updatedRace) {
        this.race = updatedRace;
        return race;
    }

    public Race getRace() {
        return race;
    }
}
