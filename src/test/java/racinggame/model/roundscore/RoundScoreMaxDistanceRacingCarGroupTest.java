package racinggame.model.roundscore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;
import racinggame.model.RacingCar;
import racinggame.model.RacingCarCapture;
import racinggame.model.RacingCarCaptureGroups;
import racinggame.model.RoundScore;

class RoundScoreMaxDistanceRacingCarGroupTest extends NSTest {
	private static final int MOVE_FORWARD = 5;
	RoundScore roundScore;
	List<RacingCarCapture> racingCars;

	@BeforeEach
	public void setup() {
		final List<RacingCarCapture> racingCars = new ArrayList<>();
		final RacingCar racingCar = RacingCar.getInstanceByName("테스트차1");
		alwaysMoveForward(racingCar);
		alwaysMoveForward(racingCar);
		racingCars.add(RacingCarCapture.valueOf(racingCar));

		final RacingCar racingCar2 = RacingCar.getInstanceByName("테스트차2");
		alwaysMoveForward(racingCar2);
		racingCars.add(RacingCarCapture.valueOf(racingCar2));

		this.roundScore = RoundScore.valueOf(racingCars);
		this.racingCars = racingCars;
	}

	@Test
	void 최대값을_반환하는_레이싱카그룹_확인() {
		final RacingCarCaptureGroups maxDistanceRacingCarGroups = roundScore.getMaxDistanceRacingCarGroups();
		final List<RacingCarCapture> racingCarCaptures = maxDistanceRacingCarGroups.getRacingCarCaptures();
		assertAll(() -> {
			assertEquals(racingCarCaptures.size(), 1);
			assertEquals(racingCarCaptures.get(0).getDistance(), 2);
			assertEquals(racingCarCaptures.get(0).getName(), "테스트차1");
		});
	}

	public void alwaysMoveForward(RacingCar racingCar) {
		assertRandomTest(racingCar::race, MOVE_FORWARD, 1, 9);
	}

	@Override
	protected void runMain() {
	}
}
