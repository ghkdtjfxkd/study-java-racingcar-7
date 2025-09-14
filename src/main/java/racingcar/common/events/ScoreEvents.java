package racingcar.common.events;

public class ScoreEvents {

    // Producer: score Domain, Consumer: lap domain
    // 해당하는 랩의 점수 기록이 완료되어야 랩을 마무리 할 수 있음
    public record RacingRecorded() {}

    // Producer: score Domain, Consumer: io domain
    public record RacingResultDerived(String result) {}
}
