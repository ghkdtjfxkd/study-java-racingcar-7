package racingcar.common.events;

public class RaceEvents {

    // Producer: race Domain, Consumer: lap Domain
    public record LapIsLeft() {}

    // Producer: race Domain, Consumer: score Domain
    public record RaceIsCompleted() {}
}
