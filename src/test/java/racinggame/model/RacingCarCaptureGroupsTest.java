package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarCaptureGroupsTest extends NSTest {
    private static final int MOVE_FORWARD = 5;

    @Test
    void 레이싱카캡처들로_레이싱카캡처그룹을_생성할_수_있다() {
        List<RacingCarCapture> racingCars = new ArrayList<>();
        final RacingCar racingCar = RacingCar.getInstanceByName("테스트차1");
        final RacingCar racingCar2 = RacingCar.getInstanceByName("테스트차2");
        alwaysMoveForward(racingCar);
        alwaysMoveForward(racingCar);
        alwaysMoveForward(racingCar2);
        racingCars.add(RacingCarCapture.valueOf(racingCar));
        racingCars.add(RacingCarCapture.valueOf(racingCar2));

        final RacingCarCaptureGroups carCaptureGroups = RacingCarCaptureGroups.valueOf(racingCars);
        assertAll(() -> {
            final RacingCarCapture racingCarCapture = carCaptureGroups.getRacingCarCaptures().get(0);
            final RacingCarCapture racingCarCapture2 = carCaptureGroups.getRacingCarCaptures().get(1);

            assertEquals(racingCarCapture.getName(), "테스트차1");
            assertEquals(racingCarCapture.getDistance(), 2);
            assertEquals(racingCarCapture2.getName(), "테스트차2");
            assertEquals(racingCarCapture2.getDistance(), 1);

        });

        carCaptureGroups.getRacingCarCaptures();
    }

    @Test
    void 가장_먼_거리를_간_레이싱카그룹을_확인할_수_있다() {
        List<RacingCarCapture> racingCars = new ArrayList<>();
        final RacingCar racingCar = RacingCar.getInstanceByName("테스트차1");
        final RacingCar racingCar2 = RacingCar.getInstanceByName("테스트차2");
        alwaysMoveForward(racingCar);
        alwaysMoveForward(racingCar);
        alwaysMoveForward(racingCar2);
        racingCars.add(RacingCarCapture.valueOf(racingCar));
        racingCars.add(RacingCarCapture.valueOf(racingCar2));

        final RacingCarCaptureGroups carCaptureGroups = RacingCarCaptureGroups.valueOf(racingCars);
        final RacingCarCaptureGroups maxDistanceRacingCarGroups = carCaptureGroups.getMaxDistanceRacingCarGroups();
        assertAll(() -> {
            assertEquals(maxDistanceRacingCarGroups.getRacingCarCaptures().size(), 1);
            assertEquals(maxDistanceRacingCarGroups.getRacingCarCaptures().get(0).getName(), "테스트차1");
            assertEquals(maxDistanceRacingCarGroups.getRacingCarCaptures().get(0).getDistance(), 2);
        });
    }

    public void alwaysMoveForward(RacingCar racingCar) {
        assertRandomTest(racingCar::race, MOVE_FORWARD, 1, 9);
    }

    @Override
    protected void runMain() {

    }
}