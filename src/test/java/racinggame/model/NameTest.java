package racinggame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.model.expcetion.InvalidRacingCarNameException;

class NameTest {

	@ParameterizedTest
	@ValueSource(strings = {"다섯글자", "한글자", "한", "두글", "람보르기니"})
	void 한글자에서_다섯글자_사이에_문자열로_생성할_수_있다(String message) {
		final Name name = Name.valueOf(message);
		assertEquals(name.getName(), message);
	}

	@Test
	void 문자열이_비어있다면_생성시_예외가_발생한다() {
		assertAll(() -> {
			assertThrows(InvalidRacingCarNameException.class, () -> Name.valueOf(""));
			assertThrows(InvalidRacingCarNameException.class, () -> Name.valueOf(null));
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"다섯글자가넘", "한글자가아니라다섯글자", "한둘셋넷다섯", "!!!!!!", "abcdef", "åß∂ƒßƒ"})
	void 다섯글자가_넘는_문자열로_생성시_예외가_발생한다(String message) {
		assertThrows(InvalidRacingCarNameException.class, () -> Name.valueOf(message));
	}
}
