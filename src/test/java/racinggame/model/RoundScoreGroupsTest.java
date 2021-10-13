package racinggame.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundScoreGroupsTest {
	RacingCarGroups carGroups;

	@BeforeEach
	public void setup() {
		final String names = "a,b,c,d,e";
		this.carGroups = RacingCarGroups.getInstanceByNames(names);
	}

	@Test
	void valueOf() {
		List<RoundScore> beforeRoundScores = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			beforeRoundScores.add(carGroups.race());
		}
		final RoundScoreGroups roundScoreGroups = RoundScoreGroups.valueOf(beforeRoundScores);
		final List<RoundScore> afterRoundScores = roundScoreGroups.getRoundScores();
		for (int i = 0; i < afterRoundScores.size(); i++) {
			assertEquals(beforeRoundScores.get(i), afterRoundScores.get(i));
		}
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4, 5, 6, 7})
	void 마지막_라운드의_최대_점수를_받은_레이싱카그룹과_전체_라운드의_최대_점수를_받은_레이싱카그룹과_같다(
		int length) {
		// given
		final List<RoundScore> beforeRoundScores = new ArrayList<>();
		RacingCarCaptureGroups lastRoundRacingCarCaptureGroups = RacingCarCaptureGroups.empty();
		for (int i = 0; i < length; i++) {
			final RoundScore roundScore = carGroups.race();
			beforeRoundScores.add(roundScore);
			lastRoundRacingCarCaptureGroups = updateRacingCarCaptureGroupsIfLastRound(lastRoundRacingCarCaptureGroups,
				length, i, roundScore);
		}
		final RoundScoreGroups roundScoreGroups = RoundScoreGroups.valueOf(beforeRoundScores);
		// when
		final RacingCarCaptureGroups victoryGroups = roundScoreGroups.getVictoryGroups();
		// then
		assertEqualsRacingCarCaptureGroups(lastRoundRacingCarCaptureGroups, victoryGroups);
	}

	private void assertEqualsRacingCarCaptureGroups(RacingCarCaptureGroups lastRoundRacingCarCaptureGroups,
		RacingCarCaptureGroups victoryGroups) {
		final List<RacingCarCapture> racingCarCaptures = victoryGroups.getRacingCarCaptures();
		final List<RacingCarCapture> lastRoundRacingCarCaptures =
			lastRoundRacingCarCaptureGroups.getRacingCarCaptures();
		for (int i = 0; i < lastRoundRacingCarCaptures.size(); i++) {
			assertEquals(lastRoundRacingCarCaptures.get(i), racingCarCaptures.get(i));
		}
	}

	private RacingCarCaptureGroups updateRacingCarCaptureGroupsIfLastRound(
		RacingCarCaptureGroups lastRoundRacingCarCaptureGroups, int length, int index, RoundScore roundScore) {
		if (index == length - 1) {
			lastRoundRacingCarCaptureGroups = roundScore.getMaxDistanceRacingCarGroups();
		}
		return lastRoundRacingCarCaptureGroups;
	}
}
