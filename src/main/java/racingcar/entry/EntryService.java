package racingcar.entry;

import java.util.LinkedHashMap;
import racingcar.entry.domain.RacingEntry;
import racingcar.entry.repository.RacingEntryRepository;

public class EntryService {

    private final RacingEntryRepository racingEntryRepository;

    public EntryService() {
        this.racingEntryRepository = new RacingEntryRepository();
    }

    public void setupRacingEntry(String participants) {
        this.racingEntryRepository.setup(RacingEntry.from(participants));
    }

    public void moveCars() {
        RacingEntry racingEntry = this.racingEntryRepository.getEntry();
        racingEntry.updateCarPositions();
        this.racingEntryRepository.updateRacingEntry(racingEntry);
    }

    public LinkedHashMap<String, Integer> getCurrentPositions() {
        return this.racingEntryRepository.getCarsPositions();
    }
}
