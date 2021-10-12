package racinggame.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.expcetion.InvalidRoundsValueException;

import static org.junit.jupiter.api.Assertions.*;

class RoundsTest {
    private static final String ERROR_MESSAGE = "[ERROR] 라운드의 총 횟수는 0 에서 " + Integer.MAX_VALUE + "까지의 숫자만 입력 가능합니다.";

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 7, 9, 90, 0})
    void 최소_0이상의_숫자를_사용해서_라운드수를_생성(int number) {
        final Rounds rounds = Rounds.valueOf(number);

        assertAll(() -> {
            assertEquals(rounds.getRounds(), number);
            assertEquals(rounds.getCurrent(), 0);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -7, -9, -90})
    void 숫자_0미만의_숫자를_사용해서_라운드수를_생성하면_예외가_발생(int number) {
        assertInvalidRoundsValueException(() -> Rounds.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "9", "90", "0"})
    void 최소_0이상을_가지는_문자을를_사용해서_라운드수를_생성(String numberStr) {
        final Rounds rounds = Rounds.valueOf(numberStr);
        assertAll(() -> {
            assertEquals(rounds.getRounds(), Integer.parseInt(numberStr));
            assertEquals(rounds.getCurrent(), 0);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-9", "-90"})
    void 숫자_0미만의_숫자를_가진_문자열로_라운드수를_생성하면_예외가_발생(String numberStr) {
        assertInvalidRoundsValueException(() -> Rounds.valueOf(numberStr));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1aasdf", "adsfsad", "백", "입", "!", "ㅁㅁㄴㅇㄹㅁㄴㅇㄹㄹsdafsdfe"})
    void 숫자가_아닌_문자열을_이용해_라운드수를_생성하면_예외가_발생(String numberStr) {
        assertInvalidRoundsValueException(() -> Rounds.valueOf(numberStr));
    }

    @Test
    void 빈문자열을_사용해서_라운드수를_생성하면_예외가_발생() {
        assertInvalidRoundsValueException(() -> Rounds.valueOf(""));
    }

    @Test
    void 현재라운드_보다_총라운드수보다_작으면_다음라운드를_진행할_수_있다() {
        final Rounds rounds = Rounds.valueOf(1);
        assertEquals(rounds.getRounds(), 1);
        assertEquals(rounds.getCurrent(), 0);
        assertTrue(rounds.hasNextRound());
    }

    @Test
    void 다음라운드가_되면_현재라운드가_1증가한다() {
        final Rounds rounds = Rounds.valueOf(1);
        assertEquals(rounds.getCurrent(), 0);
        assertEquals(rounds.nextRound(), 1);
        assertEquals(rounds.getCurrent(), 1);
    }


    private void assertInvalidRoundsValueException(final Executable executable) {
        final InvalidRoundsValueException invalidRoundsValueException = assertThrows(InvalidRoundsValueException.class, executable);
        assertInvalidRoundsErrorMessage(invalidRoundsValueException);
    }


    private void assertInvalidRoundsErrorMessage(InvalidRoundsValueException invalidRoundsValueException) {
        assertEquals(invalidRoundsValueException.getMessage(), ERROR_MESSAGE);
    }
}