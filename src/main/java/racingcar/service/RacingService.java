package racingcar.service;

import racingcar.dto.RacingLapCountRequest;
import racingcar.dto.RacingLapScoreResponse;
import racingcar.dto.RacingParticipantsRequest;

public interface RacingService {
    void setupRacingCar(RacingParticipantsRequest participantsRequest);
    void setupLapCount(RacingLapCountRequest lapCountRequest);
    RacingLapScoreResponse race();
    Object winner();
}
