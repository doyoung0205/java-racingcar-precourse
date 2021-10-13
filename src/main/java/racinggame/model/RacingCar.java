package racinggame.model;

import nextstep.utils.Randoms;

public class RacingCar {
    private static final int MOVE_FORWARD_THRESHOLD = 4;
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;

    private final Name name;
    private final Distance distance;

    private RacingCar(final String name) {
        this.name = Name.valueOf(name);
        this.distance = Distance.getInstance();
    }

    public static RacingCar getInstanceByName(final String name) {
        return new RacingCar(name);
    }

    public boolean race() {
        if (isMoveAble()) {
            distance.moveForward();
            return true;
        }
        return false;
    }

    private boolean isMoveAble() {
        final int pickNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        return pickNumber >= MOVE_FORWARD_THRESHOLD;
    }

    public boolean isStartLine() {
        return distance.isStartLine();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        if (!name.equals(racingCar.name)) return false;
        return distance.equals(racingCar.distance);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + distance.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name=" + name +
                ", distance=" + distance +
                '}';
    }

    public RacingCarCapture toCapture() {
        return RacingCarCapture.valueOf(this);
    }
}
