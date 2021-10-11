package racinggame.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCarCaptureGroups {
    private final List<RacingCarCapture> racingCarCaptures = new ArrayList<>();

    private RacingCarCaptureGroups(List<RacingCarCapture> racingCarCaptures) {
        this.racingCarCaptures.addAll(racingCarCaptures);
    }

    public static RacingCarCaptureGroups valueOf(List<RacingCarCapture> racingCars) {
        return new RacingCarCaptureGroups(racingCars);
    }

    public RacingCarCaptureGroups getMaxLapRacingCarGroups() {
        final int maxLap = getMaxLap();
        final List<RacingCarCapture> raceResultList = getRacingCarListByMaxLap(maxLap);
        return RacingCarCaptureGroups.valueOf(raceResultList);
    }

    private int getMaxLap() {
        List<RacingCarCapture> raceResults = new ArrayList<>(this.racingCarCaptures);
        raceResultsSortOrderByLapDesc(raceResults);
        final RacingCarCapture topRacingCar = raceResults.get(0);
        return topRacingCar.getLap();
    }

    private List<RacingCarCapture> getRacingCarListByMaxLap(int maxLap) {
        List<RacingCarCapture> raceResultList = new ArrayList<>();
        for (RacingCarCapture racingCarCapture : racingCarCaptures) {
            addIfLapEquals(maxLap, raceResultList, racingCarCapture);
        }
        return raceResultList;
    }

    private void addIfLapEquals(int maxLap, List<RacingCarCapture> raceResultList, RacingCarCapture racingCar) {
        if (racingCar.getLap() == maxLap) {
            raceResultList.add(racingCar);
        }
    }

    private void raceResultsSortOrderByLapDesc(List<RacingCarCapture> raceResults) {
        raceResults.sort(Comparator.comparing(RacingCarCapture::getLap).reversed());
    }
}
