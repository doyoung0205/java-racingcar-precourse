package racinggame.model;

import racinggame.model.expcetion.InvalidDistanceValueException;

public class Distance {
	private static final int ZERO = 0;
	private static final String ROUNDS_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 랩의 최소 크기는 0 보다 크거나 같습니다.";

	private int distance;

	private Distance(int distance) {
		validateMinValue(distance);
		this.distance = distance;
	}

	public static Distance getInstance() {
		return new Distance(ZERO);
	}

	public static Distance valueOf(int distance) {
		return new Distance(distance);
	}

	public boolean isStartLine() {
		return this.distance == ZERO;
	}

	public void moveForward() {
		this.distance++;
	}

	public int getDistance() {
		return distance;
	}

	private static void validateMinValue(int rounds) {
		if (rounds < 0) {
			throw new InvalidDistanceValueException(ROUNDS_MIN_VALUE_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Distance distance1 = (Distance)obj;
		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return distance;
	}

	@Override
	public String toString() {
		return "" + distance;
	}
}
