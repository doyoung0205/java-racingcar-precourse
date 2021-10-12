package racinggame.model.racingcar;

import org.junit.jupiter.api.Test;
import racinggame.model.RacingCar;
import racinggame.model.RacingCarCapture;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarToCaptureTest {

    @Test
    void 레이싱카의_현재_상태를_캡처할_수_있다() {
        final RacingCar racingCar = RacingCar.getInstanceByName("d");
        final RacingCarCapture racingCarCapture = racingCar.toCapture();
        assertAll(() -> {
            assertEquals(racingCar.getName(), racingCarCapture.getName());
            assertEquals(racingCar.getDistance(), racingCarCapture.getDistance());
        });
    }
}
