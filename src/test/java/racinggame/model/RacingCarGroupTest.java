package racinggame.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RacingCarGroupTest {
	@Test
	void 레이싱카그룹은_쉼표를_기준으로_레이싱카를_생성할_수_있다() {
		String names = "포르쉐,마세라티,람보르기니";
		final List<RacingCar> racingCarList = Arrays.asList(RacingCar.getInstanceByName("포르쉐"),
			RacingCar.getInstanceByName("마세라티"), RacingCar.getInstanceByName("람보르기니"));
		RacingCarGroups racingCarGroups = RacingCarGroups.getInstanceByNames(names);
		assertNotNull(racingCarGroups);
		assertEquals(racingCarGroups.size(), 3);
		assertRacingCarNameMatch(racingCarGroups, racingCarList);
	}

	private void assertRacingCarNameMatch(RacingCarGroups racingCarGroups, List<RacingCar> racingCarList) {
		final List<RacingCar> racingCars = racingCarGroups.getRacingCars();
		for (int i = 0; i < racingCarGroups.size(); i++) {
			final RacingCar racingCar = racingCars.get(i);
			assertEquals(racingCar.getName(), racingCarList.get(i).getName());
		}
	}
}
