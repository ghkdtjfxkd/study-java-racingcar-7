package racingcar.common.events;

public class OutputEvents {

    // Producer: output Domain, Consumer: <End Point> main Application
    public record RacingResultOffered(String result) {}
}
