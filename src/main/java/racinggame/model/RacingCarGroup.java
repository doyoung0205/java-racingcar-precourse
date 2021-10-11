package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarGroup {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarGroup(String names) {
        final StringTokenizer nameTokens = new StringTokenizer(names, ",");
        while (nameTokens.hasMoreTokens()) {
            final String name = nameTokens.nextToken();
            racingCars.add(RacingCar.getInstanceByName(name));
        }
    }

    public int size() {
        return this.racingCars.size();
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
