package racingcar.common.events;

public class LapEvents {

    // Producer: lap Domain, Consumer: entry Domain
    public record LapStarted() {}

    // Producer: lap Domain, Consumer: race Domain
    public record LapCompleted() {}
}
