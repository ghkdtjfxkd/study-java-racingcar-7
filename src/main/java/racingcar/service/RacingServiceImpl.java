package racingcar.service;

import racingcar.domain.Lap;
import racingcar.domain.RacingEntry;
import racingcar.dto.RacingLapCountRequest;
import racingcar.dto.RacingLapScoreResponse;
import racingcar.dto.RacingParticipantsRequest;
import racingcar.repository.LapRepository;
import racingcar.repository.RacingCarRepository;

public class RacingServiceImpl implements RacingService {

    private final RacingCarRepository racingCarRepository;
    private LapRepository lapRepository;

    public RacingServiceImpl(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    @Override
    public void setupRacingCar(RacingParticipantsRequest participantsRequest) {
        racingCarRepository.setupTo(RacingEntry.from(participantsRequest.cars()));
    }

    @Override
    public void setupLapCount(RacingLapCountRequest lapCountRequest) {
        racingCarRepository.setupTo
    }

    @Override
    public RacingLapScoreResponse race() {
        return null;
    }

//    @Override
//    public RacingLapScoreResponse race(
//            RacingParticipantsRequest participantsRequest,
//            RacingLapCountRequest lapCountRequest) {
//
//        RacingEntry entry = RacingEntry.from(participantsRequest.cars());
//        Lap lap = Lap.of(lapCountRequest.count());
//
//        return executeRace(entry,lap);
//    }

    private RacingLapScoreResponse executeRace(RacingEntry entry, Lap lap) {
        entry.racingResult();
        return null;
    }

    @Override
    public Object winner() {
        return null;
    }

    private void validateVacantInput(String rawInput) {
        if(inputIsNullOrEmpty(rawInput)) {
            throw new IllegalArgumentException("빈 입력");
        }
    }

    private boolean inputIsNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
