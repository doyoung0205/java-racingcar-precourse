package racinggame.model.racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.RacingCar;
import racinggame.model.expcetion.InvalidRacingCarNameException;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarGetInstanceTest {

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
}
