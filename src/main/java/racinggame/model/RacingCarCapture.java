package racinggame.model;

public class RacingCarCapture {
    private final Name name;
    private final Lap lap;

    public static RacingCarCapture valueOf(final RacingCar racingCar) {
        return new RacingCarCapture(racingCar.getName(), racingCar.getLap());
    }

    private RacingCarCapture(final String name, final int lap) {
        this.name = Name.valueOf(name);
        this.lap = Lap.valueOf(lap);
    }

    public String getName() {
        return name.getName();
    }

    public int getLap() {
        return lap.getLap();
    }
}
