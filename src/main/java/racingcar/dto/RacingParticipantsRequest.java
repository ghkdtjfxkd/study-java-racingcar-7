package racingcar.dto;

public record RacingParticipantsRequest(String cars) {
    public static RacingParticipantsRequest from(String input) {
        return new RacingParticipantsRequest(input);
    }
}
