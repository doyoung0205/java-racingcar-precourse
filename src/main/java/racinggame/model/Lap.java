package racinggame.model;

public class Lap {
    private static final int ZERO = 0;

    private int lap;

    private Lap(int lap) {
        this.lap = lap;
    }

    public static Lap init() {
        return new Lap(ZERO);
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
}
