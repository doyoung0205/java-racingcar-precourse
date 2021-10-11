package racinggame.model;

import nextstep.utils.Randoms;

public class RacingCar {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;

    private final Name name;
    private final Lap lap;

    private RacingCar(final String name) {
        this.name = Name.valueOf(name);
        this.lap = Lap.init();
    }

    public static RacingCar getInstanceByName(final String name) {
        return new RacingCar(name);
    }

    public Lap race() {
        final int pickNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (pickNumber > 4) {
            lap.plus();
        }
        return this.lap;
    }

    public boolean isStartLine() {
        return lap.isStartLine();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getLap() {
        return lap.getLap();
    }

}
