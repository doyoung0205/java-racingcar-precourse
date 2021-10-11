package racinggame.model;

import racinggame.model.expcetion.InvalidLapValueException;

public class Lap {
    private static final int ZERO = 0;
    private static final String ROUNDS_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 랩의 최소 크기는 0 보다 크거나 같습니다.";

    private int lap;

    private Lap(int lap) {
        validateMinValue(lap);
        this.lap = lap;
    }

    public static Lap init() {
        return new Lap(ZERO);
    }

    public static Lap valueOf(int lap) {
        return new Lap(lap);
    }

    public boolean isStartLine() {
        return this.lap == ZERO;
    }

    public void plus() {
        this.lap++;
    }

    public int getLap() {
        return lap;
    }

    private static void validateMinValue(int rounds) {
        if (rounds < 0) {
            throw new InvalidLapValueException(ROUNDS_MIN_VALUE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lap lap1 = (Lap) o;

        return lap == lap1.lap;
    }

    @Override
    public int hashCode() {
        return lap;
    }

    @Override
    public String toString() {
        return "" + lap;
    }
}
