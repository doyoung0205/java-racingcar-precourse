package racinggame.model;

import java.util.List;

public class RoundScore {
    private final RacingCarCaptureGroups racingCarCaptureGroups;

    private RoundScore(List<RacingCarCapture> racingCars) {
        racingCarCaptureGroups = RacingCarCaptureGroups.valueOf(racingCars);
    }

    public static RoundScore valueOf(List<RacingCarCapture> racingCars) {
        return new RoundScore(racingCars);
    }

    public RacingCarCaptureGroups getMaxDistanceRacingCarGroups() {
        return racingCarCaptureGroups.getMaxDistanceRacingCarGroups();
    }

    public List<RacingCarCapture> getRacingCarCaptureGroups() {
        return racingCarCaptureGroups.getRacingCarCaptures();
    }

    @Override
    public String toString() {
        return racingCarCaptureGroups.toString();
    }
}
