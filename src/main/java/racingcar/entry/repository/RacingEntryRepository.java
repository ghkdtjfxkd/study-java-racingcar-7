package racingcar.entry.repository;

import java.util.LinkedHashMap;
import racingcar.entry.domain.RacingEntry;

public class RacingEntryRepository {

    private RacingEntry racingEntry;

    public void setup(RacingEntry racingEntry) {
        this.racingEntry = racingEntry;
    }

    public RacingEntry getEntry() {
        return this.racingEntry;
    }

    public void updateRacingEntry(RacingEntry racingEntry) {
        this.racingEntry = racingEntry;
    }


    public LinkedHashMap<String, Integer> getCarsPositions() {
        return this.racingEntry.racingResult();
    }
}
