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

    public boolean race() {
        final int pickNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (pickNumber > 4) {
            lap.plus();
            return true;
        }
        return false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        if (!name.equals(racingCar.name)) return false;
        return lap.equals(racingCar.lap);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lap.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name=" + name +
                ", lap=" + lap +
                '}';
    }

    public RacingCarCapture toCapture() {
        return RacingCarCapture.valueOf(this);
    }
}
