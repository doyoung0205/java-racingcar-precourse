package racinggame.controller.dto;

import racinggame.model.RacingCarCapture;

public class CarCaptureResponseDto {
	private final String name;
	private final int distance;

	private CarCaptureResponseDto(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public static CarCaptureResponseDto toDto(RacingCarCapture racingCarCapture) {
		final String name = racingCarCapture.getName();
		final int distance = racingCarCapture.getDistance();
		return new CarCaptureResponseDto(name, distance);
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}
}
