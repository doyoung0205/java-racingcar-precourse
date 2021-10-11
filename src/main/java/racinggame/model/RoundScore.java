package racinggame.model;

import java.util.List;

public class RoundScore {
    private final RacingCarCaptureGroups racingCarCaptureGroups;
    private final Round round;

    private RoundScore(List<RacingCarCapture> racingCars, int round) {
        racingCarCaptureGroups = RacingCarCaptureGroups.valueOf(racingCars);
        this.round = Round.valueOf(round);
    }

    public static RoundScore valueOf(List<RacingCarCapture> racingCars, int round) {
        return new RoundScore(racingCars, round);
    }

    public RacingCarCaptureGroups getMaxLapRacingCarGroups() {
        return racingCarCaptureGroups.getMaxLapRacingCarGroups();
    }
}
