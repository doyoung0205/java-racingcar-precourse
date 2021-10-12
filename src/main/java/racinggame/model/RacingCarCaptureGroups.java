package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
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

    public static RacingCarCaptureGroups empty() {
        return new RacingCarCaptureGroups(new ArrayList<>());
    }

    public RacingCarCaptureGroups getMaxDistanceRacingCarGroups() {
        final int maxDistance = getMaxDistance();
        final List<RacingCarCapture> raceResultList = getRacingCarListByMaxDistance(maxDistance);
        return RacingCarCaptureGroups.valueOf(raceResultList);
    }

    public List<String> getNames() {
        final List<String> names = new ArrayList<>();
        for (RacingCarCapture carCapture : racingCarCaptures) {
            names.add(carCapture.getName());
        }
        return names;
    }

    public List<RacingCarCapture> getRacingCarCaptures() {
        return Collections.unmodifiableList(racingCarCaptures);
    }

    private int getMaxDistance() {
        List<RacingCarCapture> raceResults = new ArrayList<>(this.racingCarCaptures);
        raceResultsSortOrderByDistanceDesc(raceResults);
        final RacingCarCapture topRacingCar = raceResults.get(0);
        return topRacingCar.getDistance();
    }

    private List<RacingCarCapture> getRacingCarListByMaxDistance(final int maxDistance) {
        List<RacingCarCapture> raceResultList = new ArrayList<>();
        for (RacingCarCapture racingCarCapture : racingCarCaptures) {
            addIfDistanceEquals(maxDistance, raceResultList, racingCarCapture);
        }
        return raceResultList;
    }

    private void addIfDistanceEquals(int maxDistance, List<RacingCarCapture> raceResultList, RacingCarCapture racingCar) {
        if (racingCar.getDistance() == maxDistance) {
            raceResultList.add(racingCar);
        }
    }

    private void raceResultsSortOrderByDistanceDesc(List<RacingCarCapture> raceResults) {
        raceResults.sort(Comparator.comparing(RacingCarCapture::getDistance).reversed());
    }
}
