package racingcar.dto;

public record RacingLapCountRequest(String count) {
    public static RacingLapCountRequest from(String input) {
        return new RacingLapCountRequest(input);
    }
}
