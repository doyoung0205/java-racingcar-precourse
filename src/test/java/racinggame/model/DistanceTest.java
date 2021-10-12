package racinggame.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.expcetion.InvalidDistanceValueException;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void 인스턴스를_생성하면_값이_0_을_가지고_있다() {
        final Distance distance = Distance.getInstance();
        assertTrue(distance.getDistance() == 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -555, -6676, -777, -8888, -9999})
    void 음수인값을_매개변수로_인스턴스를_생성할_수_없다(int number) {
        assertThrows(InvalidDistanceValueException.class, () -> {
            Distance.valueOf(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 555, 6676, 777, 8888, 9999})
    void 양수의_매개변수로_인스턴스를_생성할_수_있다(int number) {
        assertDoesNotThrow(() -> {
            Distance.valueOf(number);
        });
    }

    @Test
    void 앞으로_전진한_거리가_0이면_스타트_라인이다() {
        assertAll(() -> {
            assertTrue(Distance.getInstance().isStartLine());
            assertTrue(Distance.valueOf(0).isStartLine());
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 555, 6676, 777, 8888, 9999})
    void 앞으로_전진한_거리가_0이_아니면_스타트_라인이_아니다(int number) {
        assertAll(() -> {
            assertFalse(Distance.valueOf(number).isStartLine());
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 555, 6676, 777, 8888, 9999})
    void 앞으로_전진한_경우_전진_하기전의_거리보다_1_증가한다(int number) {
        final Distance distance = Distance.valueOf(number);
        final int beforeDistanceValue = distance.getDistance();
        distance.moveForward();
        final int afterDistanceValue = distance.getDistance();
        assertEquals(beforeDistanceValue + 1, afterDistanceValue);
    }

}