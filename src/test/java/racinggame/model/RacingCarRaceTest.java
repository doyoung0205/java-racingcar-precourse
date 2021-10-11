package racinggame.model;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarRaceTest extends NSTest {
    RacingCar racingCar;

    @BeforeEach
    void setup() {
        racingCar = RacingCar.getInstanceByName("천하제일차");
    }

    @Override
    protected void runMain() {
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void 레이스시_랜덤값이_5이상_일_경우_랩이_1추가_된다(int randomValue) {
        final int beforeLap = racingCar.getLap();
        assertRandomTest(() -> {
            Lap afterLap = racingCar.race();
            assertAll(() -> {
                assertFalse(afterLap.isStartLine());
                assertEquals(afterLap.getLap(), beforeLap + 1);
            });
        }, randomValue, 1, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 레이스시_랜덤값이_4이하_일_경우_랩이_추가되지_않는다(int randomValue) {
        final int beforeLap = racingCar.getLap();
        assertRandomTest(() -> {
            Lap afterLap = racingCar.race();
            assertAll(() -> {
                assertTrue(afterLap.isStartLine());
                assertEquals(afterLap.getLap(), beforeLap);
            });
        }, randomValue, 1, 9);
    }


}
