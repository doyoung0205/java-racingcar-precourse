package racinggame.controller.dto;

import racinggame.model.RacingCarCapture;

public class CarCaptureResponseDto {
    private final String name;
    private final int lap;

    private CarCaptureResponseDto(String name, int lap) {
        this.name = name;
        this.lap = lap;
    }

    public static CarCaptureResponseDto toDto(RacingCarCapture racingCarCapture) {
        final String name = racingCarCapture.getName();
        final int lap = racingCarCapture.getLap();
        return new CarCaptureResponseDto(name, lap);
    }

    public String getName() {
        return name;
    }

    public int getLap() {
        return lap;
    }
}
