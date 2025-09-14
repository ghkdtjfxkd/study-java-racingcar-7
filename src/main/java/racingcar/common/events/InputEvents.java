package racingcar.common.events;

public class InputEvents {

    // Producer: <Starter> racing Car Games, Consumer: input Domain
    public record InputStart() {}

    // Producer: input Domain, Consumer: entry Domain
    public record UserEnteredParticipants(String input) {}

    // Producer: input Domain, Consumer: race Domain
    public record UserEnteredLapCount(String input) {}
}
