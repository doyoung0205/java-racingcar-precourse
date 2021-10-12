package racinggame.controller.dto;

import racinggame.model.RacingCarCapture;

import java.util.ArrayList;
import java.util.List;

public class RoundScoreResponseDto {
    private final List<CarCaptureResponseDto> carCaptures;

    private RoundScoreResponseDto(List<CarCaptureResponseDto> carCaptures) {
        this.carCaptures = carCaptures;
    }

    public static RoundScoreResponseDto toDto(List<RacingCarCapture> racingCarCaptureGroups) {
        final List<CarCaptureResponseDto> carCaptures = new ArrayList<>();
        for (RacingCarCapture racingCarCapture : racingCarCaptureGroups) {
            carCaptures.add(CarCaptureResponseDto.toDto(racingCarCapture));
        }
        return new RoundScoreResponseDto(carCaptures);
    }

    public List<CarCaptureResponseDto> getCarCaptures() {
        return carCaptures;
    }
}
