package racinggame.model;

public class RacingCarCapture {
	private final Name name;
	private final Distance distance;

	public static RacingCarCapture valueOf(final RacingCar racingCar) {
		return new RacingCarCapture(racingCar.getName(), racingCar.getDistance());
	}

	private RacingCarCapture(final String name, final int distance) {
		this.name = Name.valueOf(name);
		this.distance = Distance.valueOf(distance);
	}

	public String getName() {
		return name.getName();
	}

	public int getDistance() {
		return distance.getDistance();
	}

	@Override
	public String toString() {
		return "RacingCarCapture{"
			+ "name=" + name
			+ ", distance=" + distance
			+ '}';
	}
}
