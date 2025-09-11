package racingcar.repository;

import racingcar.domain.RacingEntry;
import racingcar.dto.RacingParticipantsRequest;

public class RacingCarRepository {

    private RacingEntry racingEntry;

    public void setupTo(RacingEntry racingEntry) {
        this.racingEntry = racingEntry;
    }

    public RacingEntry getRacingEntry() {
        return racingEntry;
    }
}
