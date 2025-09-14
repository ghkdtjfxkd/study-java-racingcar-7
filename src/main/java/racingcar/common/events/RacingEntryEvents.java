package racingcar.common.events;

import java.util.LinkedHashMap;

public class RacingEntryEvents {

    // Producer: race Domain, Consumer: score Domain
    public record RacingParticipantsReceived() {}

    // Producer: entry Domain, Consumer: score Domain
    public record RacingCarsMoved(LinkedHashMap<String,Integer> currentScore) {}
}
