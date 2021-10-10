package racinggame.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racinggame.model.expcetion.InvalidRacingCarNameException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"일이삼사오", "12345", "1", "포르쉐", "람보르기니"})
    void 이름이_5자_이하인_레이싱카를_생성할_수_있다(String name) {
        RacingCar racingCar = RacingCar.getInstanceByName(name);
        assertEquals(racingCar.getName(), name);
        assertTrue(racingCar.isStartLine());
    }

    @ParameterizedTest
    @ValueSource(strings = {"일이삼사오육", "123456", "람보르기니우르스", "페라리포르포티노", "이거타면바로하늘나라"})
    void 이름이_5자_이하인_레이싱카를_생성할_수_없다(String name) {
        final InvalidRacingCarNameException invalidRacingCarNameException = assertThrows(InvalidRacingCarNameException.class, () -> {
            RacingCar.getInstanceByName(name);
        });
        assertEquals(invalidRacingCarNameException.getMessage(), "[ERROR] 경주할 자동차의 이름이 5자 초과하였습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 이름이_공백인_레이싱카를_생성할_수_없다(String name) {
        final InvalidRacingCarNameException invalidRacingCarNameException = assertThrows(InvalidRacingCarNameException.class, () -> {
            RacingCar.getInstanceByName(name);
        });
        assertEquals(invalidRacingCarNameException.getMessage(), "[ERROR] 경주할 자동차의 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void 레이스시_랜덤값이_5이상_일_경우_랩이_1추가_된다(int randomValue) {
        RacingCar racingCar = RacingCar.getInstanceByName("천하제일차");
        final int beforeLap = racingCar.getLap();
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomValue, 1, 9);
            Lap afterLap = racingCar.race();
            assertFalse(afterLap.isStartLine());
            assertEquals(afterLap.getLap(), beforeLap + 1);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 레이스시_랜덤값이_4이하_일_경우_랩이_추가되지_않는다(int randomValue) {
        RacingCar racingCar = RacingCar.getInstanceByName("천하제일차");
        final int beforeLap = racingCar.getLap();
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomValue, 1, 9);
            Lap afterLap = racingCar.race();
            assertTrue(afterLap.isStartLine());
            assertEquals(afterLap.getLap(), beforeLap);
        }
    }
}
